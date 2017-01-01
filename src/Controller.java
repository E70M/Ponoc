import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends Game implements Initializable {
    static Game loop = new Game();
    static String FPS = "", ticks = "";
    @FXML Label FPStext;
    @FXML Label ticksText;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Game starting!");
    }
    public void looper() {
        loop.callLoop(true);
        FPStext.setText(loop.getFPS());
        ticksText.setText(loop.getTicks());
    }
}