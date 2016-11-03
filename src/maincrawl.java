/**
 * Created by Eitan on 11/3/16.
 */
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.geometry.*;
public class maincrawl extends Application {
    static final Insets GLOBAL_INSETS = new Insets(10, 10, 10, 10);
    static Stage window; static Scene display;
    public static void main(String[]args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Ponoc");
        GridPane gridlock = new GridPane();
        gridlock.setPadding(GLOBAL_INSETS);
        gridlock.setVgap(30);
        gridlock.setHgap(110);
        Image welcome = new Image("title.jpg");
        Image settingsgear = new Image("gear.png");
        ImageView welcomemat = new ImageView(welcome);
        ImageView settingsmenu = new ImageView(settingsgear);
        Label welcomeLabel = new Label();
        welcomeLabel.setGraphic(welcomemat);
        Button settingsButton = new Button();
        Button startButton = new Button("Start Game");
        gridlock.setConstraints(welcomeLabel, 2, 1);
        gridlock.setConstraints(startButton, 2, 5);
        gridlock.setConstraints(settingsButton, 0, 0);
        gridlock.setHalignment(welcomeLabel, HPos.CENTER);
        gridlock.setHalignment(startButton, HPos.CENTER);
        gridlock.setHalignment(settingsButton, HPos.CENTER);
        gridlock.setGridLinesVisible(true); // Temporary
        startButton.setOnAction(e -> fight.fightscene("Ponoc", GLOBAL_INSETS, window));
        settingsButton.setOnAction(e -> System.out.println("Test settings"));
        settingsButton.setGraphic(settingsmenu);
        gridlock.getChildren().addAll(settingsButton, welcomeLabel, startButton);
        display = new Scene(gridlock, 1000, 500);
        window.setScene(display);
        window.setResizable(false);
        window.show();
    }
}
