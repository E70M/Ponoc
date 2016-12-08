import java.awt.event.*;
public class KeyboardInput extends Game implements KeyListener {
    static int keyCode;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyCode = e.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    public static String returnKey() {
        String keyValue = "";
        if (keyCode == KeyEvent.VK_LEFT) {
            keyValue = "LEFT";
        }
        else if (keyCode == KeyEvent.VK_RIGHT) {
            keyValue = "RIGHT";
        }
        else if (keyCode == KeyEvent.VK_UP) {
            keyValue = "UP";
        }
        else if (keyCode == KeyEvent.VK_DOWN) {
            keyValue = "DOWN";
        }
        else if (keyCode == KeyEvent.VK_Z) {
            keyValue = "Z";
        }
        else if (keyCode == KeyEvent.VK_X) {
            keyValue = "X";
        }
        else if (keyCode == KeyEvent.VK_C) {
            keyValue = "C";
        }
        else if (keyCode == KeyEvent.VK_SPACE) {
            keyValue = "SPACE";
        }
        return keyValue;
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
