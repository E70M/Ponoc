import java.awt.*;
import java.util.*;
public class Enemy extends Sprite {
    private int dx, dy;
    public Enemy(double x, double y) {
        super(x,y);
    }
    public void move() {
        /*x += dx;
        y += dy;*/
    }
    public void jump(int jumpdir) {
        // Left
        /*if(jumpdir == 1) {
            dx = -1;
            loadImage("Enemy_jumpleft.png");
        }
        // Right
        else if(jumpdir == 2) {
            dx = 1;
            loadImage("Enemy_jumpright.png");
        }*/
    }
    public void enemyMovement() {
        /*int movementType = (int)(Math.random() * 3) + 1;
        // Left
        if(movementType == 1) {
            dx = -1;
            loadImage("Enemy_runleft.png");
        }
        // Right
        else if(movementType == 2) {
            dx = 1;
            loadImage("Enemy_runright.png");
        }
        // Up
        else {
            dy = 1;
            int jumpdir = (int)(Math.random() * 2) + 1;
            jump(jumpdir);
        }
        move();*/
    }
    /*int getDirection() {
        if(getImageName().equals("enemyright.png") || getImageName().equals("enemy_jumpright.png")) {
            return 1;
        }
        else {
            return 2;
        }
    }*/
}