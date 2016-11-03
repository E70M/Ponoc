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
        gridlock.setVgap(20);
        gridlock.setHgap(10);
        Image welcome = new Image("title.jpg");
        ImageView welcomemat = new ImageView(welcome);
        Label welcomeLabel = new Label();
        welcomeLabel.setGraphic(welcomemat);
        Button startButton = new Button("Start Game");
        gridlock.setConstraints(welcomeLabel, 2, 1);
        gridlock.setConstraints(startButton, 2, 3);
        gridlock.setHalignment(welcomeLabel, HPos.CENTER);
        gridlock.setHalignment(startButton, HPos.CENTER);
        gridlock.setGridLinesVisible(true); // Temporary
        startButton.setOnAction(e -> fight.fightscene("Ponoc", GLOBAL_INSETS, window));
        gridlock.getChildren().addAll(welcomeLabel, startButton);
        display = new Scene(gridlock, 1000, 500);
        window.setScene(display);
        window.setResizable(false);
        window.show();
    }
}
