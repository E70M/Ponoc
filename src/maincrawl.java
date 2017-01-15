import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.stage.*;
import javafx.scene.image.*;
import javafx.scene.media.*;
public class maincrawl extends Application {
    Stage window;
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
        window.show();
    }
    public static void playSound(String soundfile, int cycleCount) {
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
}