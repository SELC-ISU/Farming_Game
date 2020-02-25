import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

    public char key = '!';

    @Override
    public void keyTyped(KeyEvent e) {
        key = e.getKeyChar();
        System.out.println(key);

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    	
    }
}
