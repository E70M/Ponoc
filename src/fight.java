/**
 * Created by Eitan on 11/3/16.
 */
import javafx.scene.shape.Rectangle;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.geometry.*;
public class fight {
    public static void fightscene(final Insets param, Stage parentStage, Scene parentScene) {
        GridPane battleGrid = new GridPane();
        battleGrid.setPadding(param);
        battleGrid.setGridLinesVisible(true);
        Button goBack = new Button("Main menu");
        goBack.setOnAction(e -> {
            parentStage.setScene(parentScene);
            // parentStage.setFullScreen(false);
        });
        battleGrid.setConstraints(goBack, 1, 1);
        battleGrid.setHalignment(goBack, HPos.CENTER);
        battleGrid.setStyle("-fx-background-color: #062f5a;");
        battleGrid.getChildren().addAll(goBack);
        Scene layout = new Scene(battleGrid, 1000, 500);
        parentStage.setOnCloseRequest(e -> {
            e.consume();
            exitProg.exitProtocal(param, parentStage);
        });
        parentStage.setScene(layout);
    }
}