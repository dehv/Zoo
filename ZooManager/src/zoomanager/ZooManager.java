/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomanager;

import java.io.IOException;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author David Brunschier
 */
public class ZooManager extends Application {
    
    private Stage primaryStage;
    private final ObservableList<Mitarbeiter> mitarbeiter =
            FXCollections.observableArrayList(    
            );
    
    public void addMitarbeiter(Mitarbeiter arbeiter) {
        mitarbeiter.add(arbeiter);
    }
    
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
            
            //Setting up Tablecolumns
            interfaceController.homeMitarbeiterNameCol.setCellValueFactory(
                    new PropertyValueFactory<Mitarbeiter, String>("name")
            );
            interfaceController.homeMitarbeiterVornameCol.setCellValueFactory(
                    new PropertyValueFactory<Mitarbeiter, String>("vorname")
            );
//            interfaceController.homeMitarbeiterArbeitszeitCol.setCellValueFactory(
//                    new PropertyValueFactory<Mitarbeiter, String>("name")
//            );
            
            interfaceController.mitarbeiterNameCol.setCellValueFactory(
                    new PropertyValueFactory<Mitarbeiter, String>("name")
            );
            interfaceController.mitarbeiterVornameCol.setCellValueFactory(
                    new PropertyValueFactory<Mitarbeiter, String>("vorname")
            );
            interfaceController.mitarbeiterArbeitszeitCol.setCellValueFactory(
                    new PropertyValueFactory<Mitarbeiter, String>("arbeitszeit")
            );
            interfaceController.mitarbeiterPersonalnummerCol.setCellValueFactory(
                    new PropertyValueFactory<Mitarbeiter, String>("personalnummer")
            );
            interfaceController.mitarbeiterTelefonCol.setCellValueFactory(
                    new PropertyValueFactory<Mitarbeiter, String>("telefonnummer")
            );
            interfaceController.mitarbeiterGeburtsdatumCol.setCellValueFactory(
                    new PropertyValueFactory<Mitarbeiter, LocalDate>("geburtstag")
            );
            interfaceController.mitarbeiterBerufCol.setCellValueFactory(
                    new PropertyValueFactory<Mitarbeiter, String>("beruf")
            );
            
               
            //Setting Items in Tables
            interfaceController.homeMitarbeiterTable.setEditable(false);
            interfaceController.homeMitarbeiterTable.setItems(mitarbeiter);
            interfaceController.mitarbeiterTable.setItems(mitarbeiter);
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
