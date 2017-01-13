import java.awt.event.*;
public class Hero extends Sprite {
    private int dx, dy;
    static boolean pos = false;
    public Hero(double x, double y) {
        super(x,y);
        initHero();
    }
    private void initHero() {
        setImage("Adin.png");
        //getImageDimensions();
    }
    public void move() {
        /*x += dx;
        y += dy;*/
    }
    public void swingSword() {
        /*if(pos == true) {
            loadImage("Adin_swordswing.png");
        }
        else {
            loadImage("Adin.png");
        }*/
    }
    public boolean checkSwordPos() {
        if(pos == true) {
            return true;
        }
        else {
            return false;
        }
    }
    public void jump() {
        /*loadImage("Adin_jump.png");*/
    }
    public void roll(boolean pos) {
        /*if(pos == true) {
            loadImage("Adin_roll.png");
        }
        else {
            loadImage("Adin.png");
        }*/
    }
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_X || key == KeyEvent.VK_N) {
            pos = true;
            swingSword();
        }
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            dx = -1;
        }
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            dx = 1;
        }
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            dy = 1;
            jump();
        }
        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            roll(true);
        }
        move();
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_X || key == KeyEvent.VK_N) {
            pos = false;
            swingSword();
        }
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            dx = 0;
        }
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            dx = 0;
        }
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            dy = -1;
        }
        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            dy = 0;
            roll(false);
        }
        move();
    }
}