import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.geometry.*;
import javafx.scene.media.*;

public class maincrawl extends Application {
    static final Insets GLOBAL_INSETS = new Insets(10, 10, 10, 10);
    Stage window;
    GridLoader loadGrid = new GridLoader();
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
            exitProg.exitProtocal(GLOBAL_INSETS, window);
        });
        window.getIcons().add(new Image("Ponoc_Icon.png"));
        window.show();
    }
    public static void screen(final Insets param, Stage parentStage, Scene parentScene) {
        /*
        Button continueButton = new Button("Continue");
        Button settingsButton = new Button();
        continueButton.setOnAction(e -> battleground.setupfight(param, parentStage, parentScene));
        settingsButton.setOnAction(e -> settings.setup(param, parentStage, parentScene));
        settingsButton.setGraphic(new ImageView(new Image("gear.png")));
        */
    }
    public static void playSound() {/*
        try {
           MediaPlayer mediaPlayer = new MediaPlayer(new Media("Ponoc_Themesong.wav"));
           mediaPlayer.play();
       } catch(Exception ex) {
        System.out.println("Error with playing sound.");
        ex.printStackTrace();
       }
    */}
}