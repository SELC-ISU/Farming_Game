
public class Timer {
	private int time = 0;
	private long lastTime;
	private final double amountOfTicks;
	private double ns;
	private double delta;
	private boolean timeStart;
	
	public Timer() {
		lastTime = System.nanoTime();
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
	public void setTime() {
		
	}
	public void startTime() {
		timeStart = true;
	}
	public int getTime() {
		return time;
	}
}
