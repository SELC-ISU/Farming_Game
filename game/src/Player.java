
public class Player {

	private double x;
	private double y;
	private int width;
	private int height;
	private int frameWidth;
	private int frameHeight;
	
	public Player(int x, int y, int width, int height, int frameWidth, int frameHeight) {
		    this.x = x;
	        this.y = y;
	        this.width = width;
	        this.height = height;
	        this.frameWidth = frameWidth;
	        this.frameHeight = frameHeight;
	        
	        checkBoundsX();
	        checkBoundsY();
	}
	
	public int getX() {
		return (int) x;
	}
	
	public int getY() {
		return (int) y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setX(int newX) {
		x = newX;
		checkBoundsX();
	}
	
	public void setY(int newY) {
		y = newY;
		checkBoundsY();
	}
	
	public int getFrameWidth() {
		return frameWidth;
	}
	
	public int getFrameHeight() {
		return frameHeight;
	}
	
	private void checkBoundsX() {
		x = Math.max(x, 0);
		x = Math.min(x, frameWidth-width);
	}
	
	private void checkBoundsY() {
		y = Math.max(y, 0);
		y = Math.min(y, frameHeight-height);
	}
	
	public void moveRight() {
		x += .25;
		checkBoundsX();
	}
	
	public void moveLeft() {
		x -= .25;
		checkBoundsX();
	}
	
	public void moveUp() {
		y -= .25;
		checkBoundsY();
	}
	
	public void moveDown() {
		y += .25;
		checkBoundsY();
	}
}
