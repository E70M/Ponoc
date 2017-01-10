import javafx.fxml.*;
import javafx.scene.control.Label;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.*;
import javax.swing.Timer;
public class Game extends JPanel implements ActionListener {
    private static boolean running = false;
    private Timer timer;
    private Hero Adin;
    private ArrayList<Enemy> enemies;
    private boolean ingame;
    private static int heroLives = 3;
    private final int IHERO_X = 40, IHERO_Y = 60, B_WIDTH = 1000, B_HEIGHT = 500, DELAY = 15;
    private final int[][] pos = {
            {2380, 29}, {2500, 59}, {1380, 89},
            {780, 109}, {580, 139}, {680, 239},
            {790, 259}, {760, 50}, {790, 150},
            {980, 209}, {560, 45}, {510, 70},
            {930, 159}, {590, 80}, {530, 60},
            {940, 59}, {990, 30}, {920, 200},
            {900, 259}, {660, 50}, {540, 90},
            {810, 220}, {860, 20}, {740, 180},
            {820, 128}, {490, 170}, {700, 30}
    };
    static BufferStrategy bs;
    static boolean status = false;
    static int framerate = 0, updates = 0;
    @FXML Label FPStext; @FXML Label ticksText;
    public Game() {
        initGame();
    }
    private void initGame() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        ingame = true;
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        Adin = new Hero(IHERO_X, IHERO_Y);
        initEnemy();
        timer = new Timer(DELAY, this);
        timer.start();
    }
    public void initEnemy() {
        enemies = new ArrayList<>();
        for (int[] p : pos) {
            enemies.add(new Enemy(p[0], p[1]));
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (ingame) {
            drawObjects(g);
        } else {
            drawGameOver(g);
        }
        Toolkit.getDefaultToolkit().sync();
    }
    private void drawObjects(Graphics g) {
        if (Adin.isVisible()) {
            g.drawImage(Adin.getImage(), Adin.getX(), Adin.getY(), this);
        }
        for (Enemy en : enemies) {
            if (en.isVisible()) {
                g.drawImage(en.getImage(), en.getX(), en.getY(), this);
            }
        }
        g.setColor(Color.WHITE);
        g.drawString("Enemies left: " + enemies.size(), 5, 15);
    }
    private void drawGameOver(Graphics g) {
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);
        g.setColor(Color.WHITE);
        g.setFont(small);
        g.drawString(msg,(B_WIDTH - fm.stringWidth(msg)) / 2,B_HEIGHT / 2);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        inGame();
        updateAdin();
        updateEnemies();
        checkCollisions();
        repaint();
    }
    private void inGame() {

        if (!ingame) {
            timer.stop();
        }
    }
    private void updateAdin() {

        if (Adin.isVisible()) {
            Adin.move();
        }
    }
    private void updateEnemies() {

        if (enemies.isEmpty()) {
            ingame = false;
            return;
        }
        for (int i = 0; i < enemies.size(); i++) {

            Enemy en = enemies.get(i);
            if (en.isVisible()) {
                en.move();
            } else {
                en.remove(i);
            }
        }
    }
    public void checkCollisions() {
        Rectangle r3 = Adin.getBounds();
        for(Enemy enemy : enemies) {
            Rectangle r2 = enemy.getBounds();
            if(r3.intersects(r2)) {
                enemy.setVisible(false);
                if(Adin.checkSwordPos() == false) {
                    heroLives--;
                    if(heroLives == 0) {
                        Adin.setVisible(false);
                        ingame = false;
                    }
                }
            }
        }
    }
    /*public void run() {
        long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();
        while (true) {
            cycle();
            repaint();
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;
            if (sleep < 0) {
                sleep = 2;
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }
            beforeTime = System.currentTimeMillis();
        }
    }*/
    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            Adin.keyReleased(e);
        }
        @Override
        public void keyPressed(KeyEvent e) {
            Adin.keyPressed(e);
        }
    }
    /*public synchronized void start(){
        if(running)
            return;
        running = true;
    }
    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running && status == true){
            if (status == false) {
                break;
            }
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                updates++;
                delta--;
            }
            frames++;
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                framerate = frames / 1000000;
                System.out.printf("FPS: %4d\tTicks: %3d\n", framerate, updates);
                // textSetters(framerate, updates);
                frames = 0;
                updates = 0;
            }
        }
    }
    public static void callLoop(boolean check) {
        Game loop = new Game();
        if (check == true) {
            status = true;
            loop.start();
            loop.run();
        }
        else {
            status = false;
            loop.run();
        }
    }
    public void textSetters(int FPS, int ticks) {
        FPStext.setText(String.valueOf(FPS));
        ticksText.setText(String.valueOf(ticks));
    }*/
}