import javafx.scene.image.*;
import java.util.*;
public class Hero extends Sprite {
    static boolean swordpos = false;
    private int lives = 5, maxFrameCount = 6;
    private ArrayList<Image> runLeft_frames, runRight_frames, swordLeft_frames, swordRight_frames,
            jumpLeft_frames, jumpRight_frames, jumpSwordLeft_frames, jumpSwordRight_frames;
    private String[][] filename = new String[8][maxFrameCount];
    Hero(double x, double y) {
        super(x,y);
    
    }

    void swingSword(boolean toggle, boolean right) {
        if(toggle) {
            swordpos = true;
            if(right) {
                setImage("adin_swordright.png");
            }
            else {
                setImage("adin_swordleft.png");
            }
        }
        else {
            swordpos = false;
            if(right) {
                setImage("adinright.png");
            }
            else {
                setImage("adinleft.png");
            }
        }
    }
    boolean checkSwordPos() {
        if(swordpos) {
            return true;
        }
        else {
            return false;
        }
    }
    void removeLife(int factor) {
        lives -= factor;
    }
    int getLives() {
        return lives;
    }
    /*int getDirection() {
        if(getImageName().equals("adinright.png") || getImageName().equals("adin_swordright.png")
                || getImageName().equals("adin_jumpright.png") || getImageName().equals("adin_jumpswordright.png")) {
            return 1;
        }
        else {
            return 2;
        }
    }*/
}