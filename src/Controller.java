import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
public class Controller extends Game implements Initializable {
    static Stage parentStage, window;
    Game loop = new Game();
    static Parent root;
    @FXML Label FPStext; @FXML Label ticksText;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Add something?
    }
    public void backToMain() throws Exception {
        setGridPane("mainscene.fxml");
    }
    public void gotoIntro() throws Exception {
        this.setGridPane("intro.fxml");
    }
    public void gotoFight() throws Exception {
        this.setGridPane("fightloader.fxml");
    }
    public void gotoSettings() throws Exception {
        this.setGridPane("settings.fxml");
    }
    public void exitApp() throws Exception {
        this.setGridPane("exit.fxml");
    }
    public void setStage(Stage primaryStage) {
        parentStage = primaryStage;
    }
    public static void setGridPane(String FXML_file) throws Exception {
        try {
            root = FXMLLoader.load(Controller.class.getResource(FXML_file));
            if(FXML_file.equals("exit.fxml")) {
                exitProtocol(root);
            }
            parentStage.setScene(new Scene(root, 1000, 500));
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public void looper() {
        loop.callLoop(true);
    }
    public void textSetters(int FPS, int ticks) {
        FPStext.setText(Integer.toString(FPS));
        ticksText.setText(Integer.toString(ticks));
    }
    public static void exitProtocol(Parent root) {
        window = new Stage();
        window.setTitle("Wait!");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(new Scene(root, 500, 250));
        window.setX(parentStage.getX() + 250);
        window.setY(parentStage.getY() + 125);
        window.show();
    }
    public void closeAll() {
        window.close();
        parentStage.close();
    }
    public void closeExit() {
        window.close();
    }
}