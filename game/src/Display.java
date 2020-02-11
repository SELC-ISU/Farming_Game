import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {

    int x, y, width, height;

    public void setRectangleDimensions(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Display(Input keyInput){
        addKeyListener(keyInput);
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g){     //Method for drawing everything onscreen
        g.fillRect(x,y,width,height); //Draws rectangle

    }

}
