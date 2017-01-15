import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Rectangle2D;
public class Sprite {
    private Image i;
    private double posX, posY, velocityX, velocityY, width, height;
    public Sprite(double x, double y) {
        this.posX = x;
        this.posY = y;
        velocityX = 0;
        velocityY = 0;
    }
    public void setImage(String filename) {
        i = new Image(Sprite.class.getResourceAsStream(filename));
        width = i.getWidth();
        height = i.getHeight();
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
    public void addVelocity(double x, double y) {
        velocityX += x;
        velocityY += y;
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