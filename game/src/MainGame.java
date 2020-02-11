
public class MainGame{

    public static void main(String[] args){

        System.out.println("Starting game...");
        Frame frame;
        Display display;
        Input keyInput;
        keyInput = new Input();
        display = new Display(keyInput); //Creates new display to draw objects
        Loop gameLoop = new Loop(display);
        frame = new Frame(display); //Creates new window and adds display
    }

}