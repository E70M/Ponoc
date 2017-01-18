import javafx.animation.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;
import java.util.*;
import static javafx.scene.media.AudioClip.INDEFINITE;
public class Game extends maincrawl {
    private Stage window;
    private double initialAdinX = 500, initialAdinY = 425;
    static int remainingWaves = 4;
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
        gc.setStroke(Color.WHITE);
        gc.setLineWidth(1);
        Image leveldesign = new Image(Game.class.getResourceAsStream("fightbackground.png"));
        Hero Adin = new Hero(initialAdinX, initialAdinY);
        Adin.setImage("adinright.png");
        Adin.setPosition(initialAdinX, initialAdinY);
        ArrayList<Enemy> enemies = new ArrayList<>();
        Rectangle floor = new Rectangle(0,500,1000, 0);
        Rectangle ceiling = new Rectangle(0,0,1000,0);
        Rectangle leftWall = new Rectangle(0,0.1,0,499.9);
        Rectangle rightWall = new Rectangle(1000,0.1,0,499.9);
        Rectangle[] platforms = new Rectangle[5];
        platforms[0] = new Rectangle();
        platforms[1] = new Rectangle();
        platforms[2] = new Rectangle();
        platforms[3] = new Rectangle();
        platforms[4] = new Rectangle();
        for (int i = 0; i < 30; i++) {
            double px = spawnCoord(1000, "X", Adin);
            double py = spawnCoord(425,"Y", Adin);
            Enemy villain = new Enemy(px, py);
            villain.setImage("enemyleft.png");
            villain.setPosition(px, py);
            enemies.add(villain);
        } //Wave 1
        remainingWaves--;
        LongValue lastNanoTime = new LongValue(System.nanoTime());
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                lastNanoTime.value = currentNanoTime;
                Adin.setVelocity(0,0);
                if(input.contains("LEFT") || input.contains("A")) {
                    Adin.addVelocity(-100, 0);
                    Adin.setImage("adinleft.png");
                }
                if(input.contains("RIGHT") || input.contains("D")) {
                    Adin.addVelocity(100, 0);
                    Adin.setImage("adinright.png");
                }
                if(input.contains("UP") || input.contains("W")) {
                    Adin.setJumping(true);
                    Adin.addVelocity(0, -100);
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
                if(ceiling.intersects(Adin.getX()+(Adin.getWidth()/2)-((Adin.getWidth()/2)/2), Adin.getY(),
                        Adin.getWidth()/2,Adin.getHeight()/2)) {
                    Adin.setVy(0);
                    if(input.contains("DOWN") || input.contains("S")) {
                        Adin.addVelocity(0, 100);
                    }
                }
                if(floor.intersects(Adin.getX()+(Adin.getWidth()/2)-((Adin.getWidth()/2)/2),
                        Adin.getY()+(Adin.getHeight()/2), Adin.getWidth()/2, Adin.getHeight()/2)) {
                    Adin.setVy(0);
                    if(input.contains("UP") || input.contains("W")) {
                        Adin.addVelocity(0, -100);
                    }
                }
                if(leftWall.intersects(Adin.getX(), Adin.getY()+5, 5, Adin.getHeight()-10)) {
                    Adin.setVx(0);
                    if(input.contains("RIGHT") || input.contains("D")) {
                        Adin.addVelocity(100, 0);
                    }
                }
                if(rightWall.intersects(Adin.getX()+(Adin.getWidth()-5), Adin.getY()+5,
                        5, Adin.getHeight()-10)) {
                    Adin.setVx(0);
                    if(input.contains("LEFT") || input.contains("A")) {
                        Adin.addVelocity(-100, 0);
                    }
                }
                //Temporary until enemy movement paths are established
                for (Enemy villain : enemies) {
                    int direction = (int)(Math.random() * 4) + 1;
                    if(direction == 1) { //Left
                        villain.setImage("enemyleft.png");
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
                        villain.setImage("enemyright.png");
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
                    if(ceiling.intersects(villain.getX(), villain.getY(), villain.getWidth(), villain.getHeight())) {
                        villain.setVy(0);
                        int moveOff = (int)(Math.random() * 2);
                        if(moveOff == 1) {
                            villain.addVelocity(0,10);
                        }
                    }
                    if(floor.intersects(villain.getX(), villain.getY(), villain.getWidth(), villain.getHeight())) {
                        villain.setVy(0);
                        int moveOff = (int)(Math.random() * 2);
                        if(moveOff == 1) {
                            villain.addVelocity(0,-10);
                        }
                    }
                    if(leftWall.intersects(villain.getX(), villain.getY(), villain.getWidth(), villain.getHeight())) {
                        villain.setVx(0);
                        int moveOff = (int)(Math.random() * 2);
                        if(moveOff == 1) {
                            villain.addVelocity(10,0);
                        }
                    }
                    if(rightWall.intersects(villain.getX(), villain.getY(), villain.getWidth(), villain.getHeight())) {
                        villain.setVx(0);
                        int moveOff = (int)(Math.random() * 2);
                        if(moveOff == 1) {
                            villain.addVelocity(-10,0);
                        }
                    }
                    villain.update(elapsedTime);
                }
                Adin.update(elapsedTime);
                Iterator<Enemy> enemyIter = enemies.iterator();
                while(enemyIter.hasNext()) {
                    Enemy villain = enemyIter.next();
                    if(Adin.intersects(villain)) {
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
                if(enemies.size() == 0) {
                    if(remainingWaves > 0) {
                        for (int i = 0; i < 30; i++) {
                            double px = spawnCoord(1000, "X", Adin);
                            double py = spawnCoord(425,"Y", Adin);
                            Enemy villain = new Enemy(px, py);
                            villain.setImage("enemyleft.png");
                            villain.setPosition(px, py);
                            enemies.add(villain);
                        } //Waves 2,3,4
                        remainingWaves--;
                    }
                    else {
                        Adin.setVisible(false);
                    }
                }
                gc.clearRect(0, 0, 1000, 500);
                if(Adin.isVisible()) {
                    gc.drawImage(leveldesign, 0, 0);
                    Adin.render(gc);
                    if(enemies.size() > 0) {
                        for(Enemy villain : enemies) {
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
                    gc.setFill(Color.web("0x000033"));
                    gc.fillRect(0,0,1000,500);
                    gc.setFill(Color.YELLOW);
                    if(Adin.getLives() == 0) {
                        for(int i=0; i<enemies.size(); i++) {
                            enemies.remove(i);
                        }
                        String endofgame = "Game Over";
                        gc.fillText(endofgame, 435, 250);
                        gc.strokeText(endofgame, 435, 250);
                    }
                    else {
                        String youWin = "You Win!";
                        gc.fillText(youWin, 440, 250);
                        gc.strokeText(youWin, 440, 250);
                    }
                }
            }
        }.start();
    }
    // Fix?
    public double spawnCoord(double limit, String axis, Hero hero) {
        double ret = Math.random() * limit;
        if (axis.equals("X") && (ret >= (initialAdinX-(hero.getWidth()/2)) && ret <= initialAdinX + (hero.getWidth()/2))) {
            spawnCoord(limit, axis, hero);
        }
        else if(axis.equals("Y") && (ret >= (initialAdinY-(hero.getHeight()/2)) && ret <= initialAdinY + (hero.getHeight()/2))) {
            spawnCoord(limit, axis, hero);
        }
        return ret;
    }
}