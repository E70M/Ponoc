import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class fight extends Game implements KeyListener {
    public boolean over = false, paused;
    public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    public int direction = DOWN;
    public static void fightscene() {
        // Insert fxml
    }
    public void startGame() {
        over = false;
        paused = false;
        direction = DOWN;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int i = e.getKeyCode();
        if ((i == KeyEvent.VK_A || i == KeyEvent.VK_LEFT) && direction != RIGHT) {
            direction = LEFT;
        }
        if ((i == KeyEvent.VK_D || i == KeyEvent.VK_RIGHT) && direction != LEFT) {
            direction = RIGHT;
        }
        if ((i == KeyEvent.VK_W || i == KeyEvent.VK_UP) && direction != DOWN) {
            direction = UP;
        }
        if ((i == KeyEvent.VK_S || i == KeyEvent.VK_DOWN) && direction != UP) {
            direction = DOWN;
        }
        if (i == KeyEvent.VK_SPACE) {
            if (over) {
                startGame();
            }
            else {
                paused = !paused;
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
}
