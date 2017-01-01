import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    public void looper() {
        loop.callLoop(true);
        FPStext.setText(loop.getFPS());
        ticksText.setText(loop.getTicks());
    }
    public void gotoIntro() {
        loadGrid.setGridPane("intro.fxml");
    }
    public void gotoFight() {
        loadGrid.setGridPane("fightloader.fxml");
    }
}