import javafx.animation.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.image.*;
import javafx.stage.*;
import java.util.*;
import static javafx.scene.media.AudioClip.INDEFINITE;
public class Game extends maincrawl {
    private Stage window;
    private double initialAdinX = 500, initialAdinY = 425;
    public Game(Stage primaryStage) {
        this.window = primaryStage;
    }
    public void mainAction() {
        playSound("Ponoc-Themesong.wav", INDEFINITE);
        Group root = new Group();
        Scene level = new Scene(root, 1000, 500);
        window.setScene(level);
        Canvas layout = new Canvas(1000,500);
        root.getChildren().add(layout);
        ArrayList<String> input = new ArrayList<>();
        level.setOnKeyPressed( e -> {
            String code = e.getCode().toString();
            if (!input.contains(code)) {
                input.add(code);
            }
        });
        level.setOnKeyReleased( e -> {
            String code = e.getCode().toString();
            input.remove(code);
        });
        GraphicsContext gc = layout.getGraphicsContext2D();
        Image leveldesign = new Image(Game.class.getResourceAsStream("fightbackground.png"));
        Hero Adin = new Hero(initialAdinX, initialAdinY);
        Adin.setImage("adinright.png");
        Adin.setPosition(initialAdinX, initialAdinY);
        ArrayList<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            double px = 955 * Math.random();
            double py = 425 * Math.random();
            Enemy villain = new Enemy(px, py);
            villain.setImage("enemy.png");
            villain.setPosition(px, py);
            enemies.add(villain);
        }
        LongValue lastNanoTime = new LongValue(System.nanoTime());
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                lastNanoTime.value = currentNanoTime;
                Adin.setVelocity(0,0);
                if(input.contains("LEFT") || input.contains("A")) {
                    Adin.addVelocity(-75, 0);
                    Adin.setImage("adinleft.png");
                    if(Adin.getX() == 0) {
                        Adin.setVelocity(75,0);
                    }
                }
                if(input.contains("RIGHT") || input.contains("D")) {
                    Adin.addVelocity(75, 0);
                    Adin.setImage("adinright.png");
                    if(Adin.getX() == 1000 - Adin.getWidth()) {
                        Adin.setVelocity(-75,0);
                    }
                }
                if(input.contains("UP") || input.contains("W")) {
                    Adin.addVelocity(0, -75);
                    if(Adin.getY() == 0) {
                        Adin.setVelocity(0,75);
                    }
                }
                if(input.contains("DOWN") || input.contains("S")) {
                    Adin.addVelocity(0, 75);
                    if(Adin.getY() == 500 - Adin.getHeight()) {
                        Adin.setVelocity(0,-75);
                    }
                }
                if(input.contains("X")) {
                    if(input.contains("RIGHT") || input.contains("D")) {
                        Adin.swingSword(true, true);
                    }
                    else {
                        Adin.swingSword(true, false);
                    }
                }
                if(!input.contains("X")) {
                    if(input.contains("RIGHT") || input.contains("D")) {
                        Adin.swingSword(false, true);
                    }
                    else {
                        Adin.swingSword(false, false);
                    }
                }
                Adin.update(elapsedTime);
                Iterator<Enemy> enemyIter = enemies.iterator();
                while (enemyIter.hasNext()) {
                    Sprite villain = enemyIter.next();
                    if (Adin.intersects(villain)) {
                        enemyIter.remove();
                        playSound("enemydeath.wav", 1);
                        if(!Adin.checkSwordPos()) {
                            Adin.removeLife(1);
                            if(Adin.getLives() == 0) {
                                playSound("herodeath.wav", 1);
                                Adin.setVisible(false);
                            }
                        }
                    }
                }
                gc.clearRect(0, 0, 1000, 500);
                if(Adin.isVisible() == true) {
                    gc.drawImage(leveldesign, 0, 0);
                    Adin.render(gc);
                    for (Enemy villain : enemies) {
                        villain.render(gc);
                    }
                }
            }
        }.start();
    }
}