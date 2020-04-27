/**
 * replicates a timer for each block. Controls the growth of the block
 * @author tonynuss
 *
 */
public class Timer {
	/**
	 * the time the block is at
	 */
	private int time = 0;
	/**
	 * all variables for the timer
	 */
	private long lastTime;
	private final double amountOfTicks;
	private double ns;
	private double delta;
	/**
	 * true if time should start
	 */
	private boolean timeStart;
	
	public Timer() {
    	amountOfTicks = 60D;
    	ns = 1000000000 / amountOfTicks;
    	delta  = 0;
    	timeStart = false;
	}
	
	/**
	 * advances the growth of the plants 
	 */
	public void advanceTime() {
		
		long now = System.nanoTime();
     	delta += (now - lastTime) / ns;
     	lastTime = now;
    	if(delta >= 1 && timeStart) {
     		time++;
     		delta--;
     	}
	}
	
	/**
	 * resets the growth time
	 */
	public void resetTime() {
		time = 0;
	}
	
	/**
	 * starts the timer for the block 
	 */
	public void startTime() {
		timeStart = true;
		lastTime = System.nanoTime();
	}
	
	/**
	 * gets the time of the block
	 * @return time
	 */
	public int getTime() {
		return time;
	}
	/**
	 * sets time to t
	 * @param t
	 */
	public void setTime(int t) {
		time = t;
	}
}
