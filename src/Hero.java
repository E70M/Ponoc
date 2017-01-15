import java.awt.event.*;
public class Hero extends Sprite {
    static boolean pos = false;
    private int lives = 5;
    public Hero(double x, double y) {
        super(x,y);
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
}