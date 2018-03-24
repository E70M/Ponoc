public class Hero extends Sprite {
    private boolean swordPos;
    private ElementLoader loader;
    public Hero(double x, double y) {
        super(x,y);
        super.setLives(5);
        swordPos = false;
        loader = new ElementLoader();
    }
    public void swingSword(boolean toggle, boolean right) {
        if(toggle) {
            swordpos = true;
            if(right) {
                setImage(loader.getAdinSwordRight(), "adin_swordright.png");
            } else {
                setImage(loader.getAdinSwordLeft(), "adin_swordleft.png");
            }
        } else {
            swordpos = false;
            if(right) {
                setImage(loader.getAdinRight(), "adinright.png");
            } else {
                setImage(loader.getAdinLeft(), "adinleft.png");
            }
        }
    }
    public boolean checkSwordPos() {
        return swordPos;
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