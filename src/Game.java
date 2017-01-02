import java.awt.*;
import java.awt.image.BufferStrategy;
public class Game extends Canvas implements Runnable {
    private static boolean running = false;
    static BufferStrategy bs;
    static boolean status = false;
    static int framerate = 0, updates = 0;
    static int FPS = 0, ticks = 0;
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
                setFPS(framerate);
                setTicks(updates);
                frames = 0;
                updates = 0;
            }
        }
    }
    private void tick(){

    }
    public void setFPS(int framerate) {
        this.FPS = framerate;
    }
    public void setTicks(int updates) {
        this.ticks = updates;
    }
    public String getFPS() {
        return Integer.toString(FPS);
    }
    public String getTicks() {
        return Integer.toString(ticks);
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
