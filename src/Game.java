import javafx.animation.*;
import javafx.concurrent.Task;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.image.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
        Font theFont = Font.font("Helvetica", FontWeight.BOLD, 24);
        gc.setFont(theFont);
        gc.setFill(Color.WHITE);
        gc.setStroke( Color.BLACK);
        gc.setLineWidth(1);
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
                    Adin.addVelocity(-100, 0);
                    Adin.setImage("adinleft.png");
                    if(Adin.getX() == 0) {
                        Adin.setVelocity(0,0);
                    }
                }
                if(input.contains("RIGHT") || input.contains("D")) {
                    Adin.addVelocity(100, 0);
                    Adin.setImage("adinright.png");
                    if(Adin.getX() == 1000 - Adin.getWidth()) {
                        Adin.setVelocity(0,0);
                    }
                }
                if(input.contains("UP") || input.contains("W")) {
                    Adin.addVelocity(0, -100);
                    if(Adin.getY() == Adin.getHeight()) {
                        Adin.setVy(0);
                    }
                }
                if(input.contains("DOWN") || input.contains("S")) {
                    Adin.addVelocity(0, 100);
                    if(Adin.getY() == 500 - Adin.getHeight()) {
                        Adin.setVy(0);
                    }
                }
                if(input.contains("X")) {
                    if(input.contains("RIGHT") || input.contains("D")) {
                        Adin.swingSword(true, true);
                    }
                    else if(input.contains("LEFT") || input.contains("A")){
                        Adin.swingSword(true, false);
                    }
                    else {
                        if(Adin.getImageName().equals("adin_swordleft.png") || Adin.getImageName().equals("adinleft.png")) {
                            Adin.setImage("adin_swordleft.png");
                        }
                        else {
                            Adin.setImage("adin_swordright.png");
                        }
                    }
                }
                if(!input.contains("X")) {
                    if(input.contains("RIGHT") || input.contains("D")) {
                        Adin.swingSword(false, true);
                    }
                    else if(input.contains("LEFT") || input.contains("A")) {
                        Adin.swingSword(false, false);
                    }
                    else {
                        if(Adin.getImageName().equals("adin_swordleft.png") || Adin.getImageName().equals("adinleft.png")) {
                            Adin.setImage("adinleft.png");
                        }
                        else {
                            Adin.setImage("adinright.png");
                        }
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
                if(Adin.isVisible()) {
                    gc.drawImage(leveldesign, 0, 0);
                    Adin.render(gc);
                    for (Enemy villain : enemies) {
                        villain.render(gc);
                    }
                    String lives = "Lives: " + Adin.getLives();
                    gc.fillText(lives, 10, 30);
                    gc.strokeText(lives, 10, 30);
                }
                else {

                }
            }
        }.start();
    }
}