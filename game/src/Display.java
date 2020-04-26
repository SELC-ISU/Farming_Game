import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Display extends JPanel {

    int x, y, width, height;
    Input keyInput;
    int blockSize = 40;
    
    private int worldWidth = 32;
    private int worldHeight = 18;
    private int tool = 1; //tool first set to cultivate
    private int cropValue = 0;
    private int cash = 0;
    private String toolName = "Cultivator";
    private JLabel toolTitle = new JLabel("Current Tool = " +toolName);
    private Block[][] world = new Block[worldWidth][worldHeight];
    private int[][] saveTerrain = new int[worldWidth][worldHeight];
    private BufferedImage playerImage;
    private BufferedImage grass;
    private BufferedImage dirt;
    private BufferedImage growth1,growth2,finalGrowth;
    /*
     * Block id 0 - plain grass (Green)
     * Block id 1 - cultivated (Light Gray)
     * Block id 2 - planted (Grey)
     * Block id 3 - growing (Dark Grey)
     * Block id 4 - ready to harvest (Black)
     */
    
    private Save save;
    private Player player;

    public void initializeRectangleDimensions(){
        this.x = 100;
        this.y = 100;
        this.width = 30;
        this.height = 40;
        
        player = new Player(x,y,width,height,1280,720);
    }
    
    public void moveRectangle(char c) {
    	
     	if(c =='a') {
      		player.moveLeft();
      		System.out.println(player.getX());
      	}else if(c == 'd') {
      		player.moveRight();
      		System.out.println(player.getX());
   	   	}else if(c == 'w') {
   	    	player.moveUp();
   	    	System.out.println(player.getY());
   	   	}else if(c ==  's') { 
   	   		player.moveDown();
   	   	System.out.println(player.getY());
    	}else if(c == ' ') {
    		//use tool
    		cropValue = 0;
    		for(int i = 0; i < worldWidth;i++) {
    			for(int j = 0; j < worldHeight;j++) {
	    			if(tool == 1 && world[i][j].getBlockID() == 0 || tool == 2 && world[i][j].getBlockID() == 1 ||
	    					  tool == 0 && world[i][j].getBlockID() == 4) {
    					if (world[i][j].contains(player.getX()+player.getWidth()/2, player.getY()+player.getHeight())) {
	    					world[i][j].setBlockID(tool);
    					}
    					//turns cropVale to cash if you harvest block
    					if(world[i][j].contains(player.getX()+player.getWidth()/2, player.getY()+player.getHeight()) && tool ==0) {
    						cash+= 50;
    					}
	    			}
	    			if(world[i][j].getBlockID() == 4) {
						cropValue =  cropValue + 25;
					}
	    			
	    			if(world[i][j].getBlockID() == 2) {
	    				world[i][j].startGrowTime();
	    			}
	    			
    			}
    		}

    	
    	}else if(c == 'z') {
    		int i,j;
    		for(i = 0; i < worldWidth;i++) {
    			for(j = 0; j < worldHeight;j++) {
    				saveTerrain[j][i] = world[i][j].getBlockID();
    				}
    		}
    		
    		try {
				save.saveWorld(saveTerrain);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	//Cultivating grass when 1 is pressed
		}else if(c == '1') {
			tool = 1;
			toolName = "Cultivator";
		//planting but checking if cultivated first 
		}else if(c == '2') {
			tool = 2;
			toolName = "Planter";
		//harvesting
		}else if(c == '3') {
			tool = 0;
			toolName = "Harvester";
			
		}
    	
    }

    
    public Display(Input keyInput){
    	this.keyInput = keyInput;
        addKeyListener(keyInput);
        setFocusable(true);
        
        createBlankMap();
        
       save = new Save();
        
        saveTerrain = save.loadTerrain("resources/save.txt",worldWidth, worldHeight);
        
        int i,j;
		for(i = 0; i < worldWidth;i++) {
			for(j = 0; j < worldHeight;j++) {
				world[i][j].setBlockID(saveTerrain[j][i]);
				}
		}
		try {
			playerImage =  ImageIO.read(new File("..//Farming_Game//resources//farmer.jpg"));
			grass = ImageIO.read(new File("..//Farming_Game//resources//grass.jpg"));
			dirt = ImageIO.read(new File("..//Farming_Game//resources//dirt.jpg"));
			growth1 = ImageIO.read(new File("..//Farming_Game//resources//growth1.jpg"));
			growth2 = ImageIO.read(new File("..//Farming_Game//resources//growth2.jpg"));
			finalGrowth = ImageIO.read(new File("..//Farming_Game//resources//finalGrowth.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public void paintComponent(Graphics g){     //Method for drawing everything on screen
    	g.clearRect(0, 0, 1280, 720);
    	
    	//creates label in upper left
    	toolTitle.setText("<html>Current Tool = " +toolName +
    			"<br>Press 1 for Cultivator<br>Press 2 for Planter"
    			+ "<br>Press 3 for Harvester<br>Press z to Save!<br>Black = Ready to Harvest!<br>Harvest to sell!<br><br>Crop value = " +cropValue + "<br>Cash = " +cash + "</html>");
		toolTitle.setBounds(0, 0, 200, 125);
		toolTitle.setFont(new Font("Calibri", Font.BOLD, 10));
		add(toolTitle);
		
        for(int i = 0; i < worldWidth; i++) {
    		for(int j = 0; j < worldHeight; j++) {
    			//grows the plants
    			world[i][j].advanceGrowTime();
    			if(world[i][j].getGrowTime() == 2000) {
    				world[i][j].setBlockID(3);
    			}
    			if(world[i][j].getGrowTime() == 4000) {
    				world[i][j].setBlockID(4);
    			}
    			
    			//changes the color based on the block type
    			//grass
    			 
    			//cultivated
    			if(world[i][j].getBlockID()==1) {
    				g.drawImage(dirt,world[i][j].getX(), world[i][j].getY(), world[i][j].getWidth(), world[i][j].getHeight(),null);
    			}
    			//planted
    			else if(world[i][j].getBlockID()==2) {
    				g.drawImage(growth1,world[i][j].getX(), world[i][j].getY(), world[i][j].getWidth(), world[i][j].getHeight(),null);
    			}
    			//growing
    			else if(world[i][j].getBlockID()==3) {
    				g.drawImage(growth2,world[i][j].getX(), world[i][j].getY(), world[i][j].getWidth(), world[i][j].getHeight(),null);
    			}
    			//ready to harvest
    			else if(world[i][j].getBlockID()==4) {
    				g.drawImage(finalGrowth,world[i][j].getX(), world[i][j].getY(), world[i][j].getWidth(), world[i][j].getHeight(),null);
    			}
    			else if(world[i][j].getBlockID()==0) {
    				g.drawImage(grass,world[i][j].getX(), world[i][j].getY(), world[i][j].getWidth(), world[i][j].getHeight(),null);
    			}else {
    				g.fillRect(world[i][j].getX(), world[i][j].getY(), world[i][j].getWidth(), world[i][j].getHeight());
    			}
    			
    		}
    	}
        g.setColor(Color.black);
        g.drawImage(playerImage,player.getX(),player.getY(),player.getWidth(),player.getHeight(),null); //Draws rectangle
        moveRectangle(keyInput.key);
    }
    
    public void createBlankMap() {
    	for(int i = 0; i < worldWidth; i++) {
    		for(int j = 0; j < worldHeight; j++) {
    			world[i][j] = new Block(blockSize*i,blockSize*j,blockSize,blockSize, 0);
    		}
    	}
    	
    }
    

    	
}
