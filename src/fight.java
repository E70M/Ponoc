import javax.swing.*;
import java.awt.*;
public class fight extends JFrame {
    public fight() {
        initUI();
    }
    private void initUI() {
        //add(new Game());
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }
    public static void runGame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                fight ex = new fight();
                ex.setVisible(true);
            }
        });
    }
}