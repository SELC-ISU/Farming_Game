import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Display extends JPanel {

    int x, y, width, height;
    Input keyInput;
    int blockSize = 40;
    
    private int worldWidth = 32;
    private int worldHeight = 18;
    private int tool = 1; //tool first set to cultivate
    private String toolName = "Cultivator";
    private JLabel toolTitle = new JLabel("Current Tool = " +toolName);
    private Block[][] world = new Block[worldWidth][worldHeight];
    private int[][] saveTerrain = new int[worldWidth][worldHeight];

    /*
     * Block id 0 - plain grass (Green)
     * Block id 1 - cultivated (Light Gray)
     * Block id 2 - planted (Grey)
     * Block id 3 - growing (Dark Grey)
     * Block id 4 - ready to harvest (Black)
     */
    
    private Save save;

    public void setRectangleDimensions(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void initializeRectangleDimensions(){
        this.x = 100;
        this.y = 100;
        this.width = 30;
        this.height = 40;
    }
    
    public void moveRectangle(char c) {
    	
    	if(c =='a') {
    		//left
    		x -= 2;
    		x = Math.max(x, 0);
    	}else if(c == 'd') {
    		//right
    		x += 2;
    		x = Math.min(x, 1280-width);
    	}else if(c == 'w') {
    		//up
    		y -= 2;
    		y = Math.max(y, 0);
    	}else if(c ==  's') {
    		//down
    		y += 2;
    		y = Math.min(y, 720-height);
    	}else if(c == ' ') {
    		//use tool
    		for(int i = 0; i < worldWidth;i++) {
    			for(int j = 0; j < worldHeight;j++) {
    				if (world[i][j].contains(x+width/2, y+height)) {
    					world[i][j].setBlockID(tool);
    				}
    			}
    		}
    	}else if(c == 'z') {
    		int i,j;
    		for(i = 0; i < worldWidth;i++) {
    			for(j = 0; j < worldHeight;j++) {
    				//world[i][j].setBlockID(saveTerrain[j][i]);
    				saveTerrain[j][i] =world[i][j].getBlockID();
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
		//planting but checking if cultivated first (TODO)
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
		
    }

    @Override
    public void paintComponent(Graphics g){     //Method for drawing everything on screen
    	g.clearRect(0, 0, 1280, 720);
    	
    	//creates label in upper left
    	toolTitle.setText("<html>Current Tool = " +toolName +"<br>Press 1 for Cultivator<br>Press 2 for Planter<br>Press 3 for Harvester</html>");
		toolTitle.setBounds(0, 0, 200, 50);
		toolTitle.setFont(new Font("Calibri", Font.BOLD, 10));
		add(toolTitle);
		
        for(int i = 0; i < worldWidth; i++) {
    		for(int j = 0; j < worldHeight; j++) {
    			
    			if(world[i][j].getBlockID()==0) {
    				g.setColor(Color.green);
    			}
    			
    			if(world[i][j].getBlockID()==1) {
    				g.setColor(Color.LIGHT_GRAY);
    			}
    			
    			if(world[i][j].getBlockID()==2) {
    				g.setColor(Color.GRAY);
    			}
    			
    			if(world[i][j].getBlockID()==3) {
    				g.setColor(Color.DARK_GRAY);
    			}
 
    			g.fillRect(world[i][j].getX(), world[i][j].getY(), world[i][j].getWidth(), world[i][j].getHeight());
    		}
    	}
        g.setColor(Color.black);
        g.fillRect(x,y,width,height); //Draws rectangle
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
