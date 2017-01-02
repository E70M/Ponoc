import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
public class Controller extends Game implements Initializable {
    Stage parentStage;
    Game loop = new Game();
    Parent root;
    @FXML Label FPStext; @FXML Label ticksText;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Game starting!");
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
    public void setStage(Stage primaryStage) {
        parentStage = primaryStage;
    }
    public void setGridPane(int choice) throws Exception {
        try {
            if(choice == 0) {
                this.root = FXMLLoader.load(getClass().getResource("mainscene.fxml"));
            }
            else if(choice == 1) {
                this.root = FXMLLoader.load(getClass().getResource("intro.fxml"));
            }
            else if(choice == 2) {
                this.root = FXMLLoader.load(getClass().getResource("fightloader.fxml"));
            }
            else if(choice == 3) {
                this.root = FXMLLoader.load(getClass().getResource("settings.fxml"));
            }
            else {
                this.root = FXMLLoader.load(getClass().getResource("mainscene.fxml"));
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

}