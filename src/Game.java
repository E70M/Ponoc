import javafx.animation.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
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
        gc.setFill(Color.YELLOW);
        gc.setStroke(Color.YELLOW);
        gc.setLineWidth(1);
        Image leveldesign = new Image(Game.class.getResourceAsStream("fightbackground.png"));
        Hero Adin = new Hero(initialAdinX, initialAdinY);
        Adin.setImage("adinright.png");
        Adin.setPosition(initialAdinX, initialAdinY);
        ArrayList<Enemy> enemies = new ArrayList<>();
        collisionBound floor = new collisionBound(0, 500);
        collisionBound ceiling = new collisionBound(0,0);
        collisionBound leftWall = new collisionBound(0,0);
        collisionBound rightWall = new collisionBound(1000,0);
        for (int i = 0; i < 15; i++) {
            double px = spawnCoord(1000, "X");
            double py = spawnCoord(425,"Y");
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
                        Adin.setVx(0);
                    }
                }
                if(input.contains("RIGHT") || input.contains("D")) {
                    Adin.addVelocity(100, 0);
                    Adin.setImage("adinright.png");
                    if(Adin.getX() == 1000 - Adin.getWidth()) {
                        Adin.setVx(0);
                    }
                }
                if(input.contains("UP") || input.contains("W")) {
                    Adin.setJumping(true);
                    Adin.addVelocity(0, -100);
                    if(Adin.getY() == Adin.getHeight()) {
                        Adin.setVy(0);
                    }
                }
                if(!input.contains("UP") || !input.contains("W")) {
                    Adin.setJumping(false);
                    Adin.setFalling(true);
                    Adin.addVelocity(0,0);
                    if(Adin.getY() == 500 - Adin.getHeight()) {
                        Adin.setFalling(false);
                    }
                }
                if(input.contains("DOWN") || input.contains("S")) {
                    Adin.addVelocity(0, 100);
                    if(Adin.intersects(floor)) {
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
                if(Adin.intersects(leftWall) || Adin.intersects(rightWall)) {
                    Adin.setVx(0);
                }
                if(Adin.intersects(ceiling) || Adin.intersects(floor)) {
                    Adin.setVy(0);
                }
                for (Enemy villain : enemies) {
                    int direction = (int)(Math.random() * 4) + 1;
                    if(direction == 1) { //Left
                        int dir2 = (int)(Math.random() * 3) + 1;
                        if(dir2 == 1) { //left only
                            villain.addVelocity(-10, 0);
                        }
                        else if(dir2 == 2) { //left and up
                            villain.addVelocity(-10,-10);
                        }
                        else { //left and down
                            villain.addVelocity(-10, 10);
                        }
                    }
                    else if(direction == 2) { //Right
                        int dir2 = (int)(Math.random() * 3) + 1;
                        if(dir2 == 1) { //right only
                            villain.addVelocity(10, 0);
                        }
                        else if(dir2 == 2) { //right and up
                            villain.addVelocity(10,-10);
                        }
                        else { //right and down
                            villain.addVelocity(10, 10);
                        }
                    }
                    else if(direction == 3) { //Up
                        int dir2 = (int)(Math.random() * 3) + 1;
                        if(dir2 == 1) { //up only
                            villain.addVelocity(0, -10);
                        }
                        else if(dir2 == 2) { //up and left
                            villain.addVelocity(-10,-10);
                        }
                        else { //up and right
                            villain.addVelocity(10, -10);
                        }
                    }
                    else { //Down
                        int dir2 = (int)(Math.random() * 3) + 1;
                        if(dir2 == 1) { //down only
                            villain.addVelocity(0, 10);
                        }
                        else if(dir2 == 2) { //down and left
                            villain.addVelocity(-10,10);
                        }
                        else { //down and right
                            villain.addVelocity(10, 10);
                        }
                    }
                    if(villain.intersects(leftWall) || villain.intersects(rightWall)) {
                        villain.setVx(0);
                    }
                    if(villain.intersects(ceiling) || villain.intersects(floor)) {
                        villain.setVy(0);
                    }
                    villain.update(elapsedTime);
                }
                Adin.update(elapsedTime);
                Iterator<Enemy> enemyIter = enemies.iterator();
                while (enemyIter.hasNext()) {
                    Enemy villain = enemyIter.next();
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
                    Adin.renderCollisionBounds(gc);
                    if(enemies.size() > 0) {
                        for (Enemy villain : enemies) {
                            villain.render(gc);
                        }
                    }
                    else {
                        //Boss render
                    }
                    String lives = "Lives: " + Adin.getLives();
                    gc.fillText(lives, 10, 30);
                    gc.strokeText(lives, 10, 30);
                }
                else {
                    String endofgame = "Game Over";
                    gc.fillText(endofgame, 440, 250);
                    gc.strokeText(endofgame, 440, 250);
                }
            }
        }.start();
    }
    //Needs to be modified, may not prevent an enemy from spawning
    //immediately next to these points and still intersect the hero.
    public double spawnCoord(double limit, String axis) {
        double ret = Math.random() * limit;
        if (axis.equals("X") && ret == initialAdinX) {
            spawnCoord(limit, axis);
        }
        else if(axis.equals("Y") && ret == initialAdinY) {
            spawnCoord(limit, axis);
        }
        return ret;
    }
}