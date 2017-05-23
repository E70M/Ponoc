public class Boss extends Enemy {
    private int dx, dy, lives = 20;
    public Boss(double x, double y) {
        super(x, y);
    }
    public void removeLife(int n) {
        lives -= n;
    }
    public boolean isDead() {
        if(lives == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}