public class Hero extends Sprite {
    static boolean swordpos = false;
    private int lives = 5;
    private boolean vis = true;
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
    boolean isVisible() {
        return vis;
    }
    void setVisible(Boolean visible) {
        vis = visible;
    }
}