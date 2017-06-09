import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Rectangle2D;
public class Sprite {
    private Image i;
    private double posX, posY, velocityX, velocityY, width, height;
    protected boolean falling = false, jumping = false;
    private double gravity = 50, maxSpeedUp = -500, maxSpeedDown = 500;
    private int lives;
    private String imagefile;
    private boolean vis = true;
    public Sprite(double x, double y) {
        this.posX = x;
        this.posY = y;
        velocityX = 0;
        velocityY = 0;
    }
    public void setImage(Image filename, String imagefile) {
        i = filename;
        this.imagefile = imagefile;
        width = i.getWidth();
        height = i.getHeight();
    }
    public String getImageName() {
        return imagefile;
    }
    public void setPosition(double x, double y) {
        this.posX = x;
        this.posY = y;
    }
    public double getX() {
        return posX;
    }
    public double getY() {
        return posY;
    }
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public void setVelocity(double x, double y) {
        velocityX = x;
        velocityY = y;
    }
    public void setVx(double x) {
        velocityX = x;
    }
    public void setVy(double y) {
        velocityY = y;
    }
    public void addVelocity(double x, double y) {
        velocityX += x;
        velocityY += y;
        if(getFalling() || getJumping()) {
            velocityY += gravity;
            if(velocityY < maxSpeedUp) {
                velocityY = maxSpeedUp;
                if(getFalling()) {
                    velocityY *= -1;
                }
            }
            if(velocityY > maxSpeedDown) {
                velocityY = maxSpeedDown;
            }
        }
    }
    public double getVy() {
        return velocityY;
    }
    void setFalling(boolean toggle) {
        this.falling = toggle;
    }
    void setJumping(boolean toggle) {
        this.jumping = toggle;
    }
    boolean getFalling() {
        return falling;
    }
    boolean getJumping() {
        return jumping;
    }
    double getMaxSpeedUp() {
        return maxSpeedUp;
    }
    double getMaxSpeedDown() {
        return maxSpeedDown;
    }
    public void update(double time) {
        posX += velocityX * time;
        posY += velocityY * time;
    }
    public void render(GraphicsContext gc) {
        gc.drawImage(i, posX, posY);
    }
    public Rectangle2D getBoundary() {
        return new Rectangle2D(posX, posY, width, height);
    }
    public boolean intersects(Sprite s) {
        return s.getBoundary().intersects(this.getBoundary());
    }
    public boolean isVisible() {
        return vis;
    }
    public void setVisible(Boolean visible) {
        vis = visible;
    }
    public void setLives(int n) {
        this.lives = n;
    }
    public int getLives() {
        return lives;
    }
    public void removeLife(int n) {
        lives -= n;
    }
}