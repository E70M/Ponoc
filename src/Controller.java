import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends Game implements Initializable {
    static Game loop = new Game();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Game starting!");
    }
    public void looper() {
        loop.callLoop(true);
    }
}