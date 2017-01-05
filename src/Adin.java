import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Adin extends Sprite {
    private int dx, dy;
    public Adin(int x, int y) {
        super(x, y);
        initAdin();
    }
    private void initAdin() {
        loadImage("Adin.png");
        getImageDimensions();
    }
    public void move() {
        x += dx;
        x += dy;
    }
    public void swingSword() {
        loadImage("Adin_swordswing.png");
    }
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_X || key == KeyEvent.VK_N) {
            swingSword();
            // (swing sword sprite)
        }
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            dx = -1;
        }
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            dx = 1;
        }
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            dy = 1;
            // jump()
        }
        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            dy = -1;
            // roll()
        }
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_X || key == KeyEvent.VK_N) {
            // original sprite;
        }
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            dx = 0;
        }
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            dx = 0;
        }
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            dy = 0;
        }
        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            dy = 0;
        }
    }
}
