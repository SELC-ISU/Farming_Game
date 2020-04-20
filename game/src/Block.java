import java.awt.Rectangle;

public class Block{

	private int x,y,width,height, blockID;

	private Timer t;
	
	public Block(int x,int y, int width, int height,int blockID) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.blockID = blockID;
		t = new Timer();
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getBlockID() {
		return blockID;
	}


	public void setBlockID(int blockID) {
		this.blockID = blockID;
	}
	
	public boolean contains(int givenX, int givenY) {
		return (givenY > y && givenY < y+height && givenX > x && givenX < x+width);
	}
	
	public void advanceGrowTime() {
		t.advanceTime();
	}
	public void startGrowTime() {
		t.startTime();
	}
	public int getGrowTime() {
    	return t.getTime();
    }
	
}
