import java.awt.event.*;
public class KeyboardInput extends Game implements KeyListener {
    static int keyCode;
    @Override
    public void keyTyped(KeyEvent e) {
        e.consume();
    }
    @Override
    public void keyPressed(KeyEvent e) {
        keyCode = e.getKeyCode();
        System.out.println("You pressed " + KeyEvent.getKeyText(keyCode) + "!");
        e.consume();
    }
    @Override
    public void keyReleased(KeyEvent e) {
        keyCode = e.getKeyCode();
        System.out.println("You released " + KeyEvent.getKeyText(keyCode) + "!");
        e.consume();
    }

    /*private static final int KEY_COUNT = 256;
    private enum KeyState {
        RELEASED,
        PRESSED,
        ONCE
    }
    private boolean[] currentKeys = null;
    private KeyState[] keys = null;
    public void KeyboardInput() {
        currentKeys = new boolean[KEY_COUNT];
        keys = new KeyState[KEY_COUNT];
        for (int i = 0; i < KEY_COUNT; ++i) {
            keys[i] = KeyState.RELEASED;
        }
    }
    public synchronized void poll() {
        for (int i = 0; i < KEY_COUNT; ++i) {
            if (currentKeys[i]) {
                if (keys[i] == KeyState.RELEASED)
                    keys[i] = KeyState.ONCE;
                else
                    keys[i] = KeyState.PRESSED;
            } else {
                keys[i] = KeyState.RELEASED;
            }
        }
    }
    public boolean keyDown(int keyCode) {
        return keys[keyCode] == KeyState.ONCE ||
                keys[keyCode] == KeyState.PRESSED;
    }
    public boolean keyDownOnce(int keyCode) {
        return keys[keyCode] == KeyState.ONCE;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode >= 0 && keyCode < KEY_COUNT) {
            currentKeys[keyCode] = true;
        }
    }
    public synchronized void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode >= 0 && keyCode < KEY_COUNT) {
            currentKeys[keyCode] = false;
        }

    }
    */
}
