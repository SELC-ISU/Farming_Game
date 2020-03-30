
public class Player {

	private int x;
	private int y;
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
		return x;
	}
	
	public int getY() {
		return y;
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
		y = Math.min(y, frameHeight-width);
	}
	
	public void moveRight() {
		x += 2;
		checkBoundsX();
	}
	
	public void moveLeft() {
		x -= 2;
		checkBoundsX();
	}
	
	public void moveUp() {
		y -= 2;
		checkBoundsY();
	}
	
	public void moveDown() {
		y += 2;
		checkBoundsY();
	}
}
