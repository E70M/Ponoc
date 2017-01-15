import javafx.animation.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.image.*;
import javafx.stage.*;
import java.util.*;
public class Game {
    private Stage window;
    private double initialAdinX = 500, initialAdinY = 500;
    private int lives = 5;
    public Game(Stage primaryStage) {
        this.window = primaryStage;
    }
    public void mainAction() {
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
            if (!input.contains(code)) {
                input.remove(code);
            }
        });
        GraphicsContext gc = layout.getGraphicsContext2D();
        Image leveldesign = new Image(Game.class.getResourceAsStream("fightbackground.png"));
        gc.drawImage(leveldesign,0,0);
        Hero Adin = new Hero(initialAdinX, initialAdinY);
        Adin.setImage("adin.png");
        Adin.setPosition(initialAdinX, initialAdinY);
        ArrayList<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            double px = 1000 * Math.random();
            double py = 500 * Math.random();
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
                if (input.contains("LEFT")) {
                    Adin.addVelocity(-30, 0);
                }
                if (input.contains("RIGHT")) {
                    Adin.addVelocity(30, 0);
                }
                if (input.contains("UP")) {
                    Adin.addVelocity(0, -30);
                }
                if (input.contains("DOWN")) {
                    Adin.addVelocity(0, 30);
                }
                Adin.update(elapsedTime);
                Iterator<Enemy> enemyIter = enemies.iterator();
                while (enemyIter.hasNext()) {
                    Sprite villain = enemyIter.next();
                    if (Adin.intersects(villain)) {
                        enemyIter.remove();
                        if(Adin.checkSwordPos() == false) {
                            lives--;
                        }
                    }
                }
                Adin.render(gc);
                for (Sprite villain : enemies) {
                    villain.render(gc);
                }
            }
        }.start();
    }
}