import javafx.concurrent.Task;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.media.AudioClip;
import javafx.stage.*;
import java.net.URL;
import java.util.*;
public class Controller implements Initializable {
    ElementLoader loader = new ElementLoader();
    static Stage parentStage, window;
    static Parent root;
    @FXML CheckBox musicbox;
    @Override
    public void initialize(URL location, ResourceBundle resources) {}
    public void backToMain() {
        this.setGridPane("mainscene.fxml");
        playFX("staplerclick.wav",1);
    }
    public void gotoIntro() {
        this.setGridPane("intro.fxml");
        playFX("staplerclick.wav",1);
    }
    public void startGame() {
        Game Ponoc = new Game(parentStage);
        playFX("staplerclick.wav",1);
        Ponoc.mainAction();
    }
    public void gotoSettings() {
        this.setGridPane("settings.fxml");
        playFX("staplerclick.wav",1);
    }
    public void exitApp() {
        this.setGridPane("exit.fxml");
        playFX("staplerclick.wav",1);
    }
    public void setStage(Stage primaryStage) {
        parentStage = primaryStage;
    }
    void setGridPane(String FXML_file) {
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
    public void exitProtocol(Parent root) {
        window = new Stage();
        window.setTitle("Wait!");
        window.initModality(Modality.APPLICATION_MODAL);
        window.getIcons().add(loader.getAppIcon());
        window.setScene(new Scene(root, 500, 250));
        window.setX(parentStage.getX() + 250);
        window.setY(parentStage.getY() + 125);
        window.show();
        playFX("staplerclick.wav",1);
    }
    public void closeAll() {
        playFX("staplerclick.wav",1);
        window.close();
        parentStage.close();
    }
    public void closeExit() {
        playFX("staplerclick.wav",1);
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
    public void playFX(String soundfile, int cycleCount) {
        final Task task = new Task() {
            protected Object call() throws Exception {
                AudioClip audio = new AudioClip(Controller.class.getResource(soundfile).toExternalForm());
                audio.setVolume(0.5f);
                audio.setCycleCount(cycleCount);
                audio.play();
                return null;
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }
}