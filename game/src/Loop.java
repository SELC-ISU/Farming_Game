public class Loop {

    private Display display;

    public Loop(Display display){
        this.display = display;
    }

    public void Start() throws InterruptedException {

        while(true) {
                display.repaint();
                Thread.sleep(20);
            }
    }
}
