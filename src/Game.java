import java.awt.*;
import java.awt.image.BufferStrategy;
public class Game extends Canvas implements Runnable {
    Controller control = new Controller();
    private static boolean running = false;
    static BufferStrategy bs;
    static boolean status = false;
    static int framerate = 0, updates = 0;
    public synchronized void start(){
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
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                framerate = frames / 1000000;
                System.out.printf("FPS: %4d\tTicks: %3d\n", framerate, updates);
                control.textSetters(framerate, updates);
                frames = 0;
                updates = 0;
            }
        }
    }
    private void tick(){

    }
    private void render(){
        bs = this.getBufferStrategy();
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
}
