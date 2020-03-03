import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {

    int x, y, width, height;
    Input keyInput;
    
    private int worldSize = 20;
    
    private Block[][] world = new Block[worldSize][worldSize];

    public void setRectangleDimensions(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void initializeRectangleDimensions(){
        this.x = 100;
        this.y = 100;
        this.width = 50;
        this.height = 50;
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
        
        for(int i = 0; i < worldSize; i++) {
    		for(int j = 0; j < worldSize; j++) {
    			g.drawRect(world[i][j].getX(), world[i][j].getY(), world[i][j].getWidth(), world[i][j].getHeight());
    		}
    	}
        
    }
    
    public void createBlankMap() {
    	for(int i = 0; i < worldSize; i++) {
    		for(int j = 0; j < worldSize; j++) {
    			world[i][j] = new Block(10*i,10*j,10,10);
    		}
    	}
    	
    }

}
