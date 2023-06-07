import java.awt.event.*;

public class Mouse implements MouseListener {
    static boolean button = false;
    static boolean buttonJustPressed = false;

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
         button = true;
         buttonJustPressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
         button = false;
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {}
    
    @Override
    public void mouseExited(MouseEvent e) {}
}
