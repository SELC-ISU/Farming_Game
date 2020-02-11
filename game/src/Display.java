import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {

    public Display(Input keyInput){
        addKeyListener(keyInput);
    }

    @Override
    public void paintComponent(Graphics g){     //Method for drawing everything onscreen
        g.fillRect(100,100,50,50); //Draws rectangle

    }

}
