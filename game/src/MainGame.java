
public class MainGame{

    public static void main(String[] args){

        System.out.println("Starting game...");
        Frame frame;
        Display display;

        display = new Display(); //Creates new display to draw objects
        frame = new Frame(display); //Creates new window and adds display
    }

}