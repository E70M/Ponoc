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
    public void gotoIntro() throws Exception {
        this.setGridPane(1);
    }
    public void gotoFight() throws Exception {
        this.setGridPane(2);
    }
    public void gotoSettings() throws Exception {
        this.setGridPane(3);
    }
    public void exitApp() throws Exception {
        this.setGridPane(4);
    }
    public void setStage(Stage primaryStage) {
        parentStage = primaryStage;
    }
    public static void setGridPane(int choice) throws Exception {
        try {
            if(choice == 1) {
                root = FXMLLoader.load(Controller.class.getResource("intro.fxml"));
            }
            else if(choice == 2) {
                root = FXMLLoader.load(Controller.class.getResource("fightloader.fxml"));
            }
            else if(choice == 3) {
                root = FXMLLoader.load(Controller.class.getResource("settings.fxml"));
            }
            else if(choice == 4) {
                root = FXMLLoader.load(Controller.class.getResource("exit.fxml"));
                exitProtocol(root);
            }
            else {
                root = FXMLLoader.load(Controller.class.getResource("mainscene.fxml"));
            }
            parentStage.setScene(new Scene(root, 1000, 500));
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public void looper() {
        loop.callLoop(true);
        FPStext.setText(loop.getFPS());
        ticksText.setText(loop.getTicks());
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