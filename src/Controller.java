import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
public class Controller implements Initializable {
    static Stage parentStage, window;
    static Parent root;
    @FXML CheckBox musicbox;
    @Override
    public void initialize(URL location, ResourceBundle resources) {}
    public void backToMain() {
        this.setGridPane("mainscene.fxml");
    }
    public void gotoIntro() {
        this.setGridPane("intro.fxml");
    }
    public void gotoFight() {
        this.setGridPane("fightloader.fxml");
    }
    public void startGame() {
        Game Ponoc = new Game(parentStage);
    }
    public void gotoSettings() {
        this.setGridPane("settings.fxml");
    }
    public void exitApp() {
        this.setGridPane("exit.fxml");
    }
    public void setStage(Stage primaryStage) {
        parentStage = primaryStage;
    }
    public static void setGridPane(String FXML_file) {
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
    public boolean handleMusic() {
        if(musicbox.isSelected()) {
            return true;
        }
        else {
            return false;
        }
    }
}