
public class Timer {
	private int time = 0;
	private long lastTime;
	private final double amountOfTicks;
	private double ns;
	private double delta;
	private boolean timeStart;
	
	public Timer() {
		
    	amountOfTicks = 60D;
    	ns = 1000000000 / amountOfTicks;
    	delta  = 0;
    	timeStart = false;
	}

	public void advanceTime() {
		
		long now = System.nanoTime();
     	delta += (now - lastTime) / ns;
     	lastTime = now;
    	if(delta >= 1 && timeStart) {
     		time++;
     		delta--;
     	}
	}
	

	public void resetTime() {
		time = 0;
	}
	public void startTime() {
		timeStart = true;
		lastTime = System.nanoTime();
	}
	public int getTime() {
		return time;
	}
}
