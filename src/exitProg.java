import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class exitProg {
    public static void exitProtocal(final Insets param, Stage parentStage) {
        Stage window = new Stage();
        window.setTitle("Wait!");
        GridPane exitGrid = new GridPane();
        exitGrid.setPadding(param);
        exitGrid.setVgap(10);
        exitGrid.setHgap(80);
        Label askLabel = new Label("Are you sure you want to exit?");
        Button yes = new Button("Yes");
        yes.setOnAction(e -> {
            window.close();
            parentStage.close();
        });
        Button no = new Button("No");
        no.setOnAction(e -> {
            window.close();
        });
        exitGrid.setConstraints(askLabel, 1, 0);
        exitGrid.setConstraints(yes, 1, 3);
        exitGrid.setConstraints(no, 2, 3);
        exitGrid.setHalignment(askLabel, HPos.CENTER);
        exitGrid.setHalignment(yes, HPos.CENTER);
        exitGrid.setHalignment(no, HPos.CENTER);
        exitGrid.setGridLinesVisible(false); //Temporary
        exitGrid.getChildren().addAll(askLabel, yes, no);
        Scene display = new Scene(exitGrid, 500, 250);
        window.setScene(display);
        window.setOnCloseRequest(e -> window.close());
        window.setX(parentStage.getX() + 250);
        window.setY(parentStage.getY() + 125);
        window.show();
    }
}
