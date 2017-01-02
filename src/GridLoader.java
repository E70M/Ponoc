import javafx.scene.*;
import javafx.stage.*;
public class GridLoader {
    Stage parentStage;
    public void setStage(Stage primaryStage) {
        parentStage = primaryStage;
    }
    public void setGridPane(Parent root) throws Exception {
        parentStage.setScene(new Scene(root, 1000, 500));
    }
}