import java.awt.event.*;
public class Hero extends Sprite {
    static boolean swordpos = false;
    private int lives = 5;
    private boolean vis = true;
    public Hero(double x, double y) {
        super(x,y);
    }
    public void move() {
        /*x += dx;
        y += dy;*/
    }
    public void swingSword(boolean toggle, boolean right) {
        if(toggle == true) {
            swordpos = true;
            if(right == true) {
                setImage("adin_swordright.png");
            }
            else {
                setImage("adin_swordleft.png");
            }
        }
        else {
            swordpos = false;
            if(right == true) {
                setImage("adinright.png");
            }
            else {
                setImage("adinleft.png");
            }
        }
    }
    public boolean checkSwordPos() {
        if(swordpos == true) {
            return true;
        }
        else {
            return false;
        }
    }
    public void removeLife(int factor) {
        lives -= factor;
    }
    public int getLives() {
        return lives;
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
    public boolean isVisible() {
        return vis;
    }
    public void setVisible(Boolean visible) {
        vis = visible;
    }
}