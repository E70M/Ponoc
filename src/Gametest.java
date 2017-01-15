import javafx.fxml.*;
import javafx.scene.control.Label;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.*;
import javax.swing.Timer;
public class Gametest extends JPanel /*implements ActionListener*/ {
    private static boolean running = false;
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