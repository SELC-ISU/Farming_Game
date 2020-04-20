public class Loop {

    private Display display;
    public Loop(Display display){
        this.display = display;
    }

    public void Start(){

    	
 
    	
        while(true) {
        	//only counts ticks for every second all computers run at the same pace
        	
        	  
        	display.repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    

    
}
