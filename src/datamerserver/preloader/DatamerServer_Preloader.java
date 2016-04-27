/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamerserver.preloader;

import java.io.IOException;
import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author agari
 */
public class DatamerServer_Preloader extends Preloader {
    
    PreloaderC preloaderControl;
    ProgressBar bar;
    Stage stage;

    private Scene createPreloaderScene() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Pane mainPane = (Pane) loader.load(getClass().getResourceAsStream("/datamerserver/preloader/Preloader.fxml"));
        PreloaderC control = loader.getController();
        preloaderControl = control;

        return new Scene(mainPane);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.initStyle(StageStyle.UNDECORATED);
        
        Image icon = new Image(getClass().getResourceAsStream("DeathStar.png"));
        this.stage.getIcons().add(icon);
        this.stage.setTitle("Server 1.0");
        
        stage.setScene(createPreloaderScene());
        stage.show();
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification scn) {
        if (scn.getType() == StateChangeNotification.Type.BEFORE_START) {
            stage.hide();
        }
    }

    @Override
    public void handleProgressNotification(ProgressNotification pn) {
        preloaderControl.bar.setProgress(-1.0);
    }

    
}
