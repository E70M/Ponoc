import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class introcrawl {
    public static void screen (final Insets param, Stage parentStage, Scene parentScene) {
        GridPane introGrid = new GridPane();
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
}
