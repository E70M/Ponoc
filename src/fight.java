import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.fxml.*;
import java.awt.event.KeyListener;

public class fight extends Game {
    /*
    public void setupfight(final Insets param, Stage parentStage, Scene parentScene) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("fightloader.fxml"));
            KeyboardInput keyType = new KeyboardInput();
        /*
        GridPane battleGrid = new GridPane();
        battleGrid.setPadding(param);
        battleGrid.setGridLinesVisible(true);
        Button startGame = new Button("Start");
        Button goBack = new Button("Main menu");
        battleGrid.getChildren().addAll(startGame, goBack);
        startGame.setOnAction(e -> {
            Game.callLoop(true);
            battleGrid.getChildren().removeAll(startGame, goBack);
            if (keyType.returnKey().equals("ESCAPE")) {
                Game.callLoop(false);
            }
        });
        goBack.setOnAction(e -> parentStage.setScene(parentScene));
        battleGrid.setStyle("-fx-background-color: #000033;");
        Scene layout = new Scene(battleGrid, 1000, 500);
        parentStage.setOnCloseRequest(e -> {
            e.consume();
            exitProg.exitProtocal(param, parentStage);
        });
            parentStage.setScene(new Scene(root, 1000, 500));
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    } */
    public static void fightscene() {
        // Insert fxml
    }
}