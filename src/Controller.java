import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
public class Controller extends Game implements Initializable {
    Game loop = new Game();
    GridLoader loadGrid = new GridLoader();
    @FXML Label FPStext; @FXML Label ticksText;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Game starting!");
    }
    public void gotoIntro() throws Exception {
        loadGrid.setGridPane(FXMLLoader.load(getClass().getResource("intro.fxml")));
    }
    public void looper() {
        loop.callLoop(true);
        FPStext.setText(loop.getFPS());
        ticksText.setText(loop.getTicks());
    }
    public void gotoFight() throws Exception {
        loadGrid.setGridPane(FXMLLoader.load(getClass().getResource("fightloader.fxml")));
    }
    public void gotoSettings() {}
}