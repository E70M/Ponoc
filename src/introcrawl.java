import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by Eitan on 11/7/16.
 */
public class introcrawl {
    public static void screen (final Insets param, Stage parentStage, Scene parentScene) {
        GridPane introGrid = new GridPane();
        introGrid.setPadding(param);
        introGrid.setVgap(420);
        introGrid.setHgap(460);
        Button continueButton = new Button("Continue");
        continueButton.setOnAction(e -> fight.fightscene(param, parentStage, parentScene));
        introGrid.setConstraints(continueButton, 1, 1);
        introGrid.setHalignment(continueButton, HPos.CENTER);
        introGrid.setStyle("-fx-background-image: url('intro.png'); -fx-background-color: #062f5a;");
        introGrid.getChildren().addAll(continueButton);
        introGrid.setGridLinesVisible(false);
        Scene display = new Scene(introGrid, 1000, 500);
        parentStage.setScene(display);
    }
}
