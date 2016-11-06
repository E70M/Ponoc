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
    public static void setup (final Insets param, Stage parentStage, Scene parentScene) {
        GridPane settingsGrid = new GridPane();
        settingsGrid.setPadding(param);
        settingsGrid.setVgap(30);
        settingsGrid.setHgap(50);
        Label tempLabel = new Label("Test");
        Button goBack = new Button("Main menu");
        goBack.setOnAction(e -> parentStage.setScene(parentScene));
        settingsGrid.setConstraints(tempLabel, 0, 0);
        settingsGrid.setConstraints(goBack, 1, 1);
        settingsGrid.setHalignment(tempLabel, HPos.CENTER);
        settingsGrid.setHalignment(goBack, HPos.CENTER);
        settingsGrid.setStyle("-fx-background-color: #062f5a;");
        settingsGrid.getChildren().addAll(tempLabel, goBack);
        settingsGrid.setGridLinesVisible(true);
        Scene layout = new Scene(settingsGrid, 1000, 500);
        parentStage.setScene(layout);
    }
}