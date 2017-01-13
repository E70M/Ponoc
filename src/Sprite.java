import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Rectangle2D;
public class Sprite {
    private Image image;
    private double posX, posY, vX, vY, width, height;
    public Sprite(double x, double y) {
        this.posX = x;
        this.posY = y;
        vX = 0;
        vY = 0;
    }
    public void setImage(String filename) {
        Image i = new Image(filename);
        width = i.getWidth();
        height = i.getHeight();
    }
    public void setPosition(double x, double y) {
        this.posX = x;
        this.posY = y;
    }
    public void setv(double x, double y) {
        this.vX = x;
        this.vY = y;
    }
    public void addv(double x, double y) {
        vX += x;
        vY += y;
    }
    public void update(double time) {
        posX += vX * time;
        posY += vY * time;
    }
    public void render(GraphicsContext gc) {
        gc.drawImage( image, posX, posY );
    }
    public Rectangle2D getBoundary() {
        return new Rectangle2D(posX,posY,width,height);
    }
    public boolean intersects(Sprite s) {
        return s.getBoundary().intersects(this.getBoundary());
    }
}