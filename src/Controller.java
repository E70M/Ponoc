import javafx.concurrent.*;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.media.*;
import javafx.stage.*;
import java.net.URL;
import java.util.*;
public class Controller implements Initializable {
    static Stage parentStage, window;
    static Parent root;
    @FXML CheckBox musicbox;
    @Override
    public void initialize(URL location, ResourceBundle resources) {}
    public static void playSoundFX(String soundfile, int cycleCount) {
        final Task task = new Task() {
            protected Object call() throws Exception {
                AudioClip audio = new AudioClip(getClass().getResource(soundfile).toExternalForm());
                audio.setVolume(0.5f);
                audio.setCycleCount(cycleCount);
                audio.play();
                return null;
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }
    public void backToMain() {
        this.setGridPane("mainscene.fxml");
        playSoundFX("staplerclick.wav",1);
    }
    public void gotoIntro() {
        this.setGridPane("intro.fxml");
        playSoundFX("staplerclick.wav",1);
    }
    public void startGame() {
        Game Ponoc = new Game(parentStage);
        playSoundFX("staplerclick.wav",1);
        Ponoc.mainAction();
    }
    public void gotoSettings() {
        this.setGridPane("settings.fxml");
        playSoundFX("staplerclick.wav",1);
    }
    public void exitApp() {
        this.setGridPane("exit.fxml");
        playSoundFX("staplerclick.wav",1);
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
        playSoundFX("staplerclick.wav",1);
    }
    public void closeAll() {
        playSoundFX("staplerclick.wav",1);
        window.close();
        parentStage.close();
    }
    public void closeExit() {
        playSoundFX("staplerclick.wav",1);
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