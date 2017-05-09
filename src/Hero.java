public class Hero extends Sprite {
    static boolean swordpos = false;
    private int lives = 5;
    ElementLoader loader = new ElementLoader();
    Hero(double x, double y) {
        super(x,y);
    }
    void swingSword(boolean toggle, boolean right) {
        if(toggle) {
            swordpos = true;
            if(right) {
                setImage(loader.getAdinSwordRight());
                setImageName("adin_swordright.png");
            }
            else {
                setImage(loader.getAdinSwordLeft());
                setImageName("adin_swordleft.png");
            }
        }
        else {
            swordpos = false;
            if(right) {
                setImage(loader.getAdinRight());
                setImageName("adinright.png");
            }
            else {
                setImage(loader.getAdinLeft());
                setImageName("adinleft.png");
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