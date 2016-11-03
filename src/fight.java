/**
 * Created by Eitan on 11/3/16.
 */
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.geometry.*;
public class fight {
    public static void fightscene(String title, Insets param, Stage parentStage) {
        Stage window = parentStage;
        GridPane battleGrid = new GridPane();
        battleGrid.setPadding(param);
        Scene layout = new Scene(battleGrid, 1000, 500);
        window.setScene(layout);
        window.setResizable(false);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setX(parentStage.getX());
        window.setY(parentStage.getY());
        window.showAndWait();
    }
}
