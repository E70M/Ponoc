import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by Eitan on 11/3/16.
 */
public class settings {
    public static void setup (String title, final Insets param, Stage parentStage, Scene parentScene) {
        Stage window = parentStage;
        GridPane settingsGrid = new GridPane();
        settingsGrid.setPadding(param);
        settingsGrid.setVgap(30);
        settingsGrid.setHgap(50);
        Label tempLabel = new Label("Test");
        Button goBack = new Button("Main menu");
        goBack.setOnAction(e -> window.setScene(parentScene));
        settingsGrid.setConstraints(tempLabel, 0, 0);
        settingsGrid.setConstraints(goBack, 1, 1);
        settingsGrid.setHalignment(tempLabel, HPos.CENTER);
        settingsGrid.setHalignment(goBack, HPos.CENTER);
        settingsGrid.getChildren().addAll(tempLabel, goBack);
        settingsGrid.setGridLinesVisible(true);
        Scene layout = new Scene(settingsGrid, 1000, 500);
        window.setTitle(title);
        window.setScene(layout);
        window.setX(parentStage.getX());
        window.setY(parentStage.getY());
        window.setResizable(false);
        window.showAndWait();
    }
}