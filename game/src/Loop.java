public class Loop {

    private Display display;

    public Loop(Display display){
        this.display = display;
    }

    public void Start(){

        while(true) {
                display.repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
