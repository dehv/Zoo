/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomanager;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author David Brunschier
 */
public class ZooManager extends Application {
    
    private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        mainWindow();
    }
    
    public void mainWindow(){
        try {
            FXMLLoader loader = new FXMLLoader(ZooManager.class.getResource("MainWindow.fxml"));
            AnchorPane pane = loader.load();
            
            primaryStage.setMinHeight(400.00);
            primaryStage.setMinWidth(600.00);
            
            InterfaceController interfaceController = loader.getController();
            interfaceController.setMain(this);
            
            Scene scene = new Scene(pane);
            
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
