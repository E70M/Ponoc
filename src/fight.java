import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.fxml.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class fight implements KeyListener {
    public boolean over = false, paused;
    public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    public int direction = DOWN;
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
    public void startGame() {
        over = false;
        paused = false;
        direction = DOWN;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int i = e.getKeyCode();
        if ((i == KeyEvent.VK_A || i == KeyEvent.VK_LEFT) && direction != RIGHT) {
            direction = LEFT;
        }
        if ((i == KeyEvent.VK_D || i == KeyEvent.VK_RIGHT) && direction != LEFT) {
            direction = RIGHT;
        }
        if ((i == KeyEvent.VK_W || i == KeyEvent.VK_UP) && direction != DOWN) {
            direction = UP;
        }
        if ((i == KeyEvent.VK_S || i == KeyEvent.VK_DOWN) && direction != UP) {
            direction = DOWN;
        }
        if (i == KeyEvent.VK_SPACE) {
            if (over) {
                startGame();
            }
            else {
                paused = !paused;
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
}
