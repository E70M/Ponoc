import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.geometry.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class maincrawl extends Application {
    static final Insets GLOBAL_INSETS = new Insets(10, 10, 10, 10);
    static Stage window; static Scene display;
    static GridPane gridlock, introGrid, battleGrid;
    public static void main(String[]args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Ponoc");
        // Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        gridlock = new GridPane();
        gridlock.setPadding(GLOBAL_INSETS);
        gridlock.setVgap(60);
        gridlock.setHgap(128);
        Label welcomeLabel = new Label();
        welcomeLabel.setGraphic(new ImageView(new Image("title.png")));
        Button startButton = new Button("Start Game");
        gridlock.setConstraints(welcomeLabel, 2, 1);
        gridlock.setConstraints(startButton, 2, 5);
        gridlock.setHalignment(welcomeLabel, HPos.CENTER);
        gridlock.setHalignment(startButton, HPos.CENTER);
        gridlock.setStyle("-fx-background-image: url('backdrop.jpg')");
        window.getIcons().add(new Image("Ponoc_Icon.png"));
        startButton.setOnAction(e -> screen(GLOBAL_INSETS, window, display));
        playSound();
        startButton.setStyle("-fx-base: #ffffff; -fx-focus-color: transparent");
        gridlock.getChildren().addAll( welcomeLabel, startButton);
        display = new Scene(gridlock, 1000, 500);
        window.setScene(display);
        window.setResizable(false);
        window.setOnCloseRequest(e -> {
            e.consume();
            exitProg.exitProtocal(GLOBAL_INSETS, window);
        });
        window.show();
    }
    public static void screen (final Insets param, Stage parentStage, Scene parentScene) {
        introGrid = new GridPane();
        introGrid.setPadding(param);
        introGrid.setVgap(380);
        introGrid.setHgap(415);
        Button continueButton = new Button("Continue");
        Button settingsButton = new Button();
        continueButton.setOnAction(e -> fight.fightscene(param, parentStage, parentScene));
        settingsButton.setOnAction(e -> settings.setup(param, parentStage, parentScene));
        settingsButton.setGraphic(new ImageView(new Image("gear.png")));
        introGrid.setConstraints(continueButton, 1, 1);
        introGrid.setConstraints(settingsButton, 0, 0);
        introGrid.setHalignment(continueButton, HPos.CENTER);
        introGrid.setHalignment(settingsButton, HPos.CENTER);
        introGrid.setStyle("-fx-background-image: url('intro.png'); -fx-background-color: #000033;");
        introGrid.getChildren().addAll(continueButton, settingsButton);
        introGrid.setGridLinesVisible(false);
        Scene display = new Scene(introGrid, 1000, 500);
        parentStage.setScene(display);
    }
    public static void playSound() {/*
        try {
           String bip = "Ponoc_Themesong.wav";
           Media hit = new Media(bip);
           MediaPlayer mediaPlayer = new MediaPlayer(hit);
           mediaPlayer.play();
       } catch(Exception ex) {
        System.out.println("Error with playing sound.");
        ex.printStackTrace();
       }
    */}
}