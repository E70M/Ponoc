import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.geometry.*;
import javafx.scene.media.*;

import java.io.IOException;

public class maincrawl extends Application {
    static final Insets GLOBAL_INSETS = new Insets(10, 10, 10, 10);
    Stage window;
    GridLoader loadGrid = new GridLoader();
    public static void main(String[]args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Ponoc");
        loadGrid.setStage(window);
        loadGrid.setGridPane(FXMLLoader.load(getClass().getResource("mainscene.fxml")));
        window.setResizable(false);
        window.setOnCloseRequest(e -> {
            e.consume();
            exitProg.exitProtocal(GLOBAL_INSETS, window);
        });
        window.getIcons().add(new Image("Ponoc_Icon.png"));
        window.show();
    }
    public static void playSound() {/*
        try {
           MediaPlayer mediaPlayer = new MediaPlayer(new Media("Ponoc_Themesong.wav"));
           mediaPlayer.play();
       } catch(Exception ex) {
        System.out.println("Error with playing sound.");
        ex.printStackTrace();
       }
    */}
}