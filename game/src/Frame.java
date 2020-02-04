import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{

    public Frame(Display display){
        add(display);
        setSize(new Dimension(1280,720)); //Creates size value for window
        setTitle("Farming Game");
        setDefaultCloseOperation(Frame.EXIT_ON_CLOSE); //After the red x is hit, window will close
        setLocationRelativeTo(null); //Puts window in middle of screen
        setVisible(true);
    }


}