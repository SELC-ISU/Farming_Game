import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {

    int x, y, width, height;
    Input keyInput;
    int blockSize = 40;
    
    private int worldWidth = 32;
    private int worldHeight = 18;
    
    private Block[][] world = new Block[worldWidth][worldHeight];

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
    		x = Math.min(x, 1230);
    	}else if(c == 'w') {
    		//up
    		y -= 2;
    		y = Math.max(y, 0);
    	}else if(c ==  's') {
    		//down
    		y += 2;
    		y = Math.min(y, 670);
    	}
    }
    
    public Display(Input keyInput){
    	this.keyInput = keyInput;
        addKeyListener(keyInput);
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g){     //Method for drawing everything on screen
    	g.clearRect(0, 0, 1280, 720);
        g.fillRect(x,y,width,height); //Draws rectangle
        moveRectangle(keyInput.key);
        
        for(int i = 0; i < worldWidth; i++) {
    		for(int j = 0; j < worldHeight; j++) {
    			g.drawRect(world[i][j].getX(), world[i][j].getY(), world[i][j].getWidth(), world[i][j].getHeight());
    		}
    	}
        
    }
    
    public void createBlankMap() {
    	for(int i = 0; i < worldWidth; i++) {
    		for(int j = 0; j < worldHeight; j++) {
    			world[i][j] = new Block(blockSize*i,blockSize*j,blockSize,blockSize);
    		}
    	}
    	
    }

}
