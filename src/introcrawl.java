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
        introGrid.setVgap(20);
        introGrid.setHgap(30);
        Button continueButton = new Button("Continue");
        continueButton.setOnAction(e -> fight.fightscene(param, parentStage, parentScene));
        introGrid.getChildren().addAll(continueButton);
        Scene display = new Scene(introGrid, 1000, 500);
        parentStage.setScene(display);
    }
}
