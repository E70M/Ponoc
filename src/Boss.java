public class Boss extends Enemy {
    private int dx, dy;
    public Boss(double x, double y) {
        super(x, y);
        super.setLives(20);
    }
    public boolean isDead() {
        if(super.getLives() == 0) {
            return true;
        }
    	return false;
    }
}