import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Rectangle2D;
public class Sprite {
    private Image i;
    private double posX, posY, velocityX, velocityY, width, height;
    protected boolean falling = false, jumping = false;
    private double gravity = 5;
    private double maxSpeed = 50;
    private String imagefile;
    public Sprite(double x, double y) {
        this.posX = x;
        this.posY = y;
        velocityX = 0;
        velocityY = 0;
    }
    public void setImage(String filename) {
        i = new Image(Sprite.class.getResourceAsStream(filename));
        this.imagefile = filename;
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
        /*if(getFalling() || getJumping()) {
            velocityY += gravity;
        }
        if(velocityY > maxSpeed) {
            velocityY = maxSpeed;
        }*/
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
}