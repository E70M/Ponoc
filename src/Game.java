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
    ElementLoader loader = new ElementLoader();
    private Stage window;
    private double initialAdinX = 500, initialAdinY = 425;
    static int remainingWaves = 4; //jumpTimer = 0;
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
        level.setOnKeyPressed( e -> {
            String code = e.getCode().toString();
            if (!loader.isContaining(code)) {
                loader.addToInput(code);
            }
        });
        level.setOnKeyReleased( e -> {
            String code = e.getCode().toString();
            loader.removeInput(code);
        });
        level.setOnMousePressed(e -> loader.addToInput("CLICK"));
        level.setOnMouseReleased(e -> loader.removeInput("CLICK"));
        GraphicsContext gc = layout.getGraphicsContext2D();
        Font theFont = Font.font("Helvetica", FontWeight.BOLD, 24);
        gc.setFont(theFont);
        gc.setFill(Color.YELLOW);
        gc.setStroke(Color.WHITE);
        gc.setLineWidth(1);
        Image leveldesign = loader.getFightBackground();
        Hero Adin = new Hero(initialAdinX, initialAdinY);
        Boss smrt = new Boss(500, 398);
        smrt.setImage(loader.getBoss(), "Boss.png");
        smrt.setVisible(false);
        Adin.setImage(loader.getAdinRight(), "adinright.png");
        Adin.setPosition(initialAdinX, initialAdinY);
        ArrayList<Enemy> enemies = new ArrayList<>();
        ArrayList<Boss> bosses = new ArrayList<>();
        bosses.add(smrt);
        Rectangle floor = new Rectangle(0,500,1000, 0);
        Rectangle ceiling = new Rectangle(0,0,1000,0);
        Rectangle leftWall = new Rectangle(0,0.1,0,499.9);
        Rectangle rightWall = new Rectangle(1000,0.1,0,499.9);
        Rectangle[] platforms = new Rectangle[5];
        platforms[0] = new Rectangle(693,398,307,5);
        platforms[1] = new Rectangle(822,295,178,5);
        platforms[2] = new Rectangle(0,271,250,5);
        platforms[3] = new Rectangle(309,188,377,5);
        platforms[4] = new Rectangle(786,111,214,5);
        LongValue lastNanoTime = new LongValue(System.nanoTime());
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                lastNanoTime.value = currentNanoTime;
                if(enemies.size() == 0) {
                    if(remainingWaves > 0) {
                        for (int i = 0; i < 30; i++) {
                            double px = spawnCoord(1000, "X", Adin);
                            double py = spawnCoord(425,"Y", Adin);
                            Enemy villain = new Enemy(px, py);
                            villain.setImage(loader.getEnemyLeft(), "enemyleft.png");
                            villain.setPosition(px, py);
                            enemies.add(villain);
                        } //Waves 2,3,4
                        remainingWaves--;
                    }
                }
                Adin.setVelocity(0,0);
                if(loader.isContaining("LEFT") || loader.isContaining("A")) {
                    Adin.addVelocity(-100, 0);
                    Adin.setImage(loader.getAdinLeft(), "adinleft.png");
                }
                if(loader.isContaining("RIGHT") || loader.isContaining("D")) {
                    Adin.addVelocity(100, 0);
                    Adin.setImage(loader.getAdinRight(), "adinright.png");
                }
                if(loader.isContaining("UP") || loader.isContaining("W")) {
                    /*if(Adin.getFalling()) {
                        Adin.addVelocity(0,0);
                    }
                    else {*/
                        Adin.setJumping(true);
                        Adin.setFalling(false); 
                        if (ceiling.intersects(Adin.getX() + (Adin.getWidth() / 2) - ((Adin.getWidth() / 2) / 2),
                                Adin.getY(), Adin.getWidth() / 2, Adin.getHeight() / 2)
                                || Adin.getVy() == Adin.getMaxSpeedUp()) {
                            Adin.setFalling(true);
                            Adin.setJumping(false);
                            Adin.addVelocity(0, 0);
                        } else {
                            Adin.addVelocity(0, -300);
                        }
                    //}
                }
                if(!loader.isContaining("UP") || !loader.isContaining("W")) {
                    Adin.setJumping(false);
                    Adin.setFalling(true);
                    Adin.addVelocity(0,0);
                    if(floor.intersects(Adin.getX() + (Adin.getWidth() / 2) - ((Adin.getWidth() / 2) / 2),
                            Adin.getY(), Adin.getWidth() / 2, Adin.getHeight() / 2)) {
                        Adin.setFalling(false);
                    }
                }
                if(loader.isContaining("CLICK")) {
                    if(loader.isContaining("RIGHT") || loader.isContaining("D")) {
                        Adin.swingSword(true, true);
                    }
                    else if(loader.isContaining("LEFT") || loader.isContaining("A")){
                        Adin.swingSword(true, false);
                    }
                    else {
                        if(Adin.getImageName().equals("adin_swordleft.png") || Adin.getImageName().equals("adinleft.png")) {
                            Adin.setImage(loader.getAdinSwordLeft(), "adin_swordleft.png");
                        }
                        else {
                            Adin.setImage(loader.getAdinSwordRight(), "adin_swordright.png");
                        }
                    }
                }
                if(!loader.isContaining("CLICK")) {
                    if(loader.isContaining("RIGHT") || loader.isContaining("D")) {
                        Adin.swingSword(false, true);
                    }
                    else if(loader.isContaining("LEFT") || loader.isContaining("A")) {
                        Adin.swingSword(false, false);
                    }
                    else {
                        if(Adin.getImageName().equals("adin_swordleft.png") || Adin.getImageName().equals("adinleft.png")) {
                            Adin.setImage(loader.getAdinLeft(), "adinleft.png");
                        }
                        else {
                            Adin.setImage(loader.getAdinRight(), "adinright.png");
                        }
                    }
                }
                if(ceiling.intersects(Adin.getX()+(Adin.getWidth()/2)-((Adin.getWidth()/2)/2), Adin.getY(),
                        Adin.getWidth()/2,Adin.getHeight()/2)) {
                    Adin.setVy(0);
                    if(Adin.getFalling()) {
                        Adin.addVelocity(0, 0);
                    }
                }
                if(floor.intersects(Adin.getX()+(Adin.getWidth()/2)-((Adin.getWidth()/2)/2),
                        Adin.getY()+(Adin.getHeight()/2), Adin.getWidth()/2, Adin.getHeight()/2)) {
                    Adin.setVy(0);
                    if(loader.isContaining("UP") || loader.isContaining("W")) {
                        Adin.addVelocity(0, -100);
                    }
                }
                if(leftWall.intersects(Adin.getX(), Adin.getY()+5, 5, Adin.getHeight()-10)) {
                    Adin.setVx(0);
                    if(loader.isContaining("RIGHT") || loader.isContaining("D")) {
                        Adin.addVelocity(100, 0);
                    }
                }
                if(rightWall.intersects(Adin.getX()+(Adin.getWidth()-5), Adin.getY()+5,
                        5, Adin.getHeight()-10)) {
                    Adin.setVx(0);
                    if(loader.isContaining("LEFT") || loader.isContaining("A")) {
                        Adin.addVelocity(-100, 0);
                    }
                }
                if(platforms[0].intersects(Adin.getX()+(Adin.getWidth()-5), Adin.getY()+5,
                        5, Adin.getHeight()-10)) {
                    Adin.setVy(0);
                    if(loader.isContaining("UP") && Adin.getY() <= 398) { //Find height
                        Adin.addVelocity(0, -100);
                    }
                }
                if(platforms[1].intersects(Adin.getX()+(Adin.getWidth()-5), Adin.getY()+5,
                        5, Adin.getHeight()-10)) {
                    Adin.setVy(0);
                    if(loader.isContaining("UP") && Adin.getY() <= 295) {
                        Adin.addVelocity(0, -100);
                    }
                }
                if(platforms[2].intersects(Adin.getX()+(Adin.getWidth()-5), Adin.getY()+5,
                        5, Adin.getHeight()-10)) {
                    Adin.setVy(0);
                    if(loader.isContaining("UP") && Adin.getY() <= 271) { //Find height
                        Adin.addVelocity(0, -100);
                    }
                }
                if(platforms[3].intersects(Adin.getX()+(Adin.getWidth()-5), Adin.getY()+5,
                        5, Adin.getHeight()-10)) {
                    Adin.setVy(0);
                    if(loader.isContaining("UP") && Adin.getY() <= 188) { //Find height
                        Adin.addVelocity(0, -100);
                    }
                }
                if(platforms[4].intersects(Adin.getX()+(Adin.getWidth()-5), Adin.getY()+5,
                        5, Adin.getHeight()-10)) {
                    Adin.setVy(0);
                    if(loader.isContaining("UP") && Adin.getY() <= 111) { //Find height
                        Adin.addVelocity(0, -100);
                    }
                }
                //Temporary until enemy movement paths are established
                for (Enemy villain : enemies) {
                    int direction = (int)(Math.random() * 4) + 1;
                    if(direction == 1) { //Left
                        villain.setImage(loader.getEnemyLeft(), "enemyleft.png");
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
                        villain.setImage(loader.getEnemyRight(), "enemyright.png");
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
                for (Boss smrt : bosses) {
                    int direction = (int)(Math.random() * 4) + 1;
                    if(direction == 1) { //Left
                        smrt.setImage(loader.getBoss(), "Boss.png");
                        int dir2 = (int)(Math.random() * 3) + 1;
                        if(dir2 == 1) { //left only
                            smrt.addVelocity(-10, 0);
                        }
                        else if(dir2 == 2) { //left and up
                            smrt.addVelocity(-10,-10);
                        }
                        else { //left and down
                            smrt.addVelocity(-10, 10);
                        }
                    }
                    else if(direction == 2) { //Right
                        smrt.setImage(loader.getBoss(), "Boss.png");
                        int dir2 = (int)(Math.random() * 3) + 1;
                        if(dir2 == 1) { //right only
                            smrt.addVelocity(10, 0);
                        }
                        else if(dir2 == 2) { //right and up
                            smrt.addVelocity(10,-10);
                        }
                        else { //right and down
                            smrt.addVelocity(10, 10);
                        }
                    }
                    else if(direction == 3) { //Up
                        int dir2 = (int)(Math.random() * 3) + 1;
                        if(dir2 == 1) { //up only
                            smrt.addVelocity(0, -10);
                        }
                        else if(dir2 == 2) { //up and left
                            smrt.addVelocity(-10,-10);
                        }
                        else { //up and right
                            smrt.addVelocity(10, -10);
                        }
                    }
                    else { //Down
                        int dir2 = (int)(Math.random() * 3) + 1;
                        if(dir2 == 1) { //down only
                            smrt.addVelocity(0, 10);
                        }
                        else if(dir2 == 2) { //down and left
                            smrt.addVelocity(-10,10);
                        }
                        else { //down and right
                            smrt.addVelocity(10, 10);
                        }
                    }
                    if(ceiling.intersects(smrt.getX(), smrt.getY(), smrt.getWidth(), smrt.getHeight())) {
                        smrt.setVy(0);
                        int moveOff = (int)(Math.random() * 2);
                        if(moveOff == 1) {
                            smrt.addVelocity(0,10);
                        }
                    }
                    if(floor.intersects(smrt.getX(), smrt.getY(), smrt.getWidth(), smrt.getHeight())) {
                        smrt.setVy(0);
                        int moveOff = (int)(Math.random() * 2);
                        if(moveOff == 1) {
                            smrt.addVelocity(0,-10);
                        }
                    }
                    if(leftWall.intersects(smrt.getX(), smrt.getY(), smrt.getWidth(), smrt.getHeight())) {
                        smrt.setVx(0);
                        int moveOff = (int)(Math.random() * 2);
                        if(moveOff == 1) {
                            smrt.addVelocity(10,0);
                        }
                    }
                    if(rightWall.intersects(smrt.getX(), smrt.getY(), smrt.getWidth(), smrt.getHeight())) {
                        smrt.setVx(0);
                        int moveOff = (int)(Math.random() * 2);
                        if(moveOff == 1) {
                            smrt.addVelocity(-10,0);
                        }
                    }
                    smrt.update(elapsedTime);
                }
                if(Adin.intersects(smrt)) {
                    if(Adin.intersects(smrt) && smrt.isVisible()) {
                        smrt.removeLife(1);
                        smrt.setPosition(spawnCoord(850, "X", Adin), spawnCoord(360, "Y", Adin));
                        if (!Adin.checkSwordPos()) {
                            Adin.removeLife(1);
                            if (Adin.getLives() == 0) {
                                playSound("herodeath.wav", 1);
                                Adin.setVisible(false);
                                smrt.setVisible(false);
                                bosses.remove(smrt);
                            }
                        }
                    }
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
                if(enemies.size() == 0 && remainingWaves == 0) {
                    smrt.setVisible(true);
                    if(smrt.isDead()) {
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
                        smrt.render(gc);
                    }
                    String heroLives = "Hero Lives: " + Adin.getLives();
                    String bossLives = "Boss Lives: " + smrt.getLives();
                    String enemiesRemaining = "Enemies Remaining: " + enemies.size();
                    String wavecount = "Waves Left: " + remainingWaves;
                    gc.setFill(Color.YELLOW);
                    gc.fillText(heroLives, 10, 30);
                    gc.strokeText(heroLives, 10, 30);
                    gc.fillText(enemiesRemaining, 10, 60);
                    gc.strokeText(enemiesRemaining, 10, 60);
                    gc.fillText(wavecount, 10, 90);
                    gc.strokeText(wavecount, 10, 90);
                    if(smrt.isVisible() && !smrt.isDead()) {
                        gc.fillText(bossLives, 10, 120);
                        gc.strokeText(bossLives, 10, 120);
                    }
                }
                else {
                    gc.setFill(Color.web("0x000033"));
                    gc.fillRect(0,0,1000,500);
                    gc.setFill(Color.YELLOW);
                    String endText;
                    for(int i=0; i<enemies.size(); i++) {
                        enemies.remove(i);
                    }
                    smrt.setVisible(false);
                    bosses.remove(smrt);
                    if(Adin.getLives() < 1) {
                        endText = "Game Over";
                    }
                    else {
                        endText = "You Win!";
                    }
                    gc.fillText(endText, 440, 250);
                    gc.strokeText(endText, 440, 250);
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