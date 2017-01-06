import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.stage.*;
import javafx.scene.image.*;
import javafx.scene.media.*;
import static javafx.scene.media.AudioClip.INDEFINITE;
public class maincrawl extends Application {
    Stage window;
    // Static Thread thread;
    Controller loadGrid = new Controller();
    public static void main(String[]args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Ponoc");
        loadGrid.setStage(window);
        loadGrid.setGridPane("mainscene.fxml");
        window.setResizable(false);
        window.setOnCloseRequest(e -> {
            e.consume();
            try {
                loadGrid.exitApp();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        window.getIcons().add(new Image("Ponoc_Icon.png"));
        playSound();
        /*boolean temp = loadGrid.handleMusic();
        if (temp == false) {
            thread.start();
        }
        else {
            thread.interrupt();
        }*/
        window.show();
    }
    public static void playSound() {
        final Task task = new Task() {
            protected Object call() throws Exception {
                AudioClip audio = new AudioClip(getClass().getResource("Ponoc-Themesong.wav").toExternalForm());
                audio.setVolume(0.5f);
                audio.setCycleCount(INDEFINITE);
                audio.play();
                return null;
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }
}