import javafx.scene.*;
import javafx.stage.*;
import javafx.fxml.*;
public class GridLoader {
    Parent root;
    Stage parentStage;
    public void setStage(Stage primaryStage) {
        parentStage = primaryStage;
    }
    public void setGridPane(String FXML_filename) {
        try {
            root = FXMLLoader.load(getClass().getResource(FXML_filename));
            parentStage.setScene(new Scene(root, 1000, 500));
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}