import javafx.scene.image.*;
import java.util.*;
public class Hero extends Sprite {
    static boolean swordpos = false;
    private int lives = 5, maxFrameCount = 6;
    private ArrayList<Image> runLeft_frames, runRight_frames, swordLeft_frames, swordRight_frames;
    private ArrayList<Image> jumpLeft_frames, jumpRight_frames, jumpSwordLeft_frames, jumpSwordRight_frames;
    private String[][] filename = new String[8][maxFrameCount];
    Hero(double x, double y) {
        super(x,y);
        initFileNames();
        initRunLeft();
        initRunRight();
        initSwordLeft();
        initSwordRight();
        initJumpLeft();
        initJumpRight();
        initJumpSwordLeft();
        initJumpSwordRight();
    }
    void initFileNames() {
        filename[0][0] = ""; //runLeft
        filename[0][1] = "";
        filename[0][2] = "";
        filename[0][3] = "";
        filename[0][4] = "";
        filename[0][5] = "";
        filename[1][0] = ""; //runRight
        filename[1][1] = "";
        filename[1][2] = "";
        filename[1][3] = "";
        filename[1][4] = "";
        filename[1][5] = "";
        filename[2][0] = ""; //swordLeft
        filename[2][1] = "";
        filename[2][2] = "";
        filename[2][3] = "";
        filename[2][4] = "";
        filename[2][5] = "";
        filename[3][0] = ""; //swordRight
        filename[3][1] = "";
        filename[3][2] = "";
        filename[3][3] = "";
        filename[3][4] = "";
        filename[3][5] = "";
        filename[4][0] = ""; //jumpLeft
        filename[4][1] = "";
        filename[4][2] = "";
        filename[4][3] = "";
        filename[4][4] = "";
        filename[4][5] = "";
        filename[5][0] = ""; //jumpRight
        filename[5][1] = "";
        filename[5][2] = "";
        filename[5][3] = "";
        filename[5][4] = "";
        filename[5][5] = "";
        filename[6][0] = ""; //jumpSwordLeft
        filename[6][1] = "";
        filename[6][2] = "";
        filename[6][3] = "";
        filename[6][4] = "";
        filename[6][5] = "";
        filename[7][0] = ""; //jumpSwordRight
        filename[7][1] = "";
        filename[7][2] = "";
        filename[7][3] = "";
        filename[7][4] = "";
        filename[7][5] = "";
    }
    void initRunLeft() {
        runLeft_frames = new ArrayList<>(maxFrameCount);
        for(int i=0; i<runLeft_frames.size(); i++) {
            runLeft_frames.add(new Image(Hero.class.getResourceAsStream(filename[1][i])));
        }
    }
    void initRunRight() {
        runRight_frames = new ArrayList<>(maxFrameCount);
        for(int i=0; i<runLeft_frames.size(); i++) {
            runRight_frames.add(new Image(Hero.class.getResourceAsStream(filename[1][i])));
        }
    }
    void initSwordLeft() {
        swordRight_frames = new ArrayList<>(maxFrameCount);
        for(int i=0; i<runLeft_frames.size(); i++) {
            swordRight_frames.add(new Image(Hero.class.getResourceAsStream(filename[1][i])));
        }
    }
    void initSwordRight() {
        jumpRight_frames = new ArrayList<>(maxFrameCount);
        for(int i=0; i<runLeft_frames.size(); i++) {
            jumpRight_frames.add(new Image(Hero.class.getResourceAsStream(filename[1][i])));
        }
    }
    void initJumpLeft() {
        runLeft_frames = new ArrayList<>(maxFrameCount);
        for(int i=0; i<runLeft_frames.size(); i++) {
            runLeft_frames.add(new Image(Hero.class.getResourceAsStream(filename[1][i])));
        }
    }
    void initJumpRight() {
        jumpRight_frames = new ArrayList<>(maxFrameCount);
        for(int i=0; i<runLeft_frames.size(); i++) {
            jumpRight_frames.add(new Image(Hero.class.getResourceAsStream(filename[1][i])));
        }
    }
    void initJumpSwordLeft() {
        jumpSwordLeft_frames = new ArrayList<>(maxFrameCount);
        for(int i=0; i<runLeft_frames.size(); i++) {
            jumpSwordLeft_frames.add(new Image(Hero.class.getResourceAsStream(filename[1][i])));
        }
    }
    void initJumpSwordRight() {
        jumpSwordRight_frames = new ArrayList<>(maxFrameCount);
        for(int i=0; i<runLeft_frames.size(); i++) {
            jumpSwordRight_frames.add(new Image(Hero.class.getResourceAsStream(filename[1][i])));
        }
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
}