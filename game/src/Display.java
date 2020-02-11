import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {

    int x, y, width, height;



    public Display(Input keyInput){
        addKeyListener(keyInput);
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g){     //Method for drawing everything onscreen
        g.fillRect(x,y,width,height); //Draws rectangle

    }

}
