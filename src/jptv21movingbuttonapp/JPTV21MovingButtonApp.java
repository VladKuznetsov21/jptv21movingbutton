/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptv21movingbuttonapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author pupil
 */
public class JPTV21MovingButtonApp extends Application {
    private final double sceneWidth = 500;
    private final double sceneHeight = 500;
    private Scene scene;
    private FXMLDocumentController fxmlDocumentController;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        fxmlDocumentController = loader.getController();
        fxmlDocumentController.moveButtonRandomly(sceneWidth, sceneHeight);
        scene = new Scene(root, sceneWidth, sceneHeight);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
