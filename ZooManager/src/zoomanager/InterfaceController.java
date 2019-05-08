/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomanager;

import java.io.IOException;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author David Brunschier
 */
public class InterfaceController {
    
    public ZooManager main;
    @FXML
    TableView<Mitarbeiter> homeMitarbeiterTable;
    @FXML
    TableColumn<Mitarbeiter, String> homeMitarbeiterNameCol;
    @FXML
    TableColumn<Mitarbeiter, String> homeMitarbeiterVornameCol;
    @FXML
    TableColumn<Mitarbeiter, ?> homeMitarbeiterArbeitszeitCol;
    @FXML
    private TableView<?> homeTiereTable;
    @FXML
    private ListView<?> homeVeranstaltungList;
    @FXML
     TableView<Mitarbeiter> mitarbeiterTable;
    @FXML
    private Button mitarbeiterHinzufuegenButton;
    @FXML
    private TableView<?> tiereTable;
    @FXML
    private Button tierHinzufuegenButton;
    @FXML
    private TableView<?> gehegeTable;
    @FXML
    private Button gehegeHinzufuegenButton;
    @FXML
    private TableView<?> futterTable;
    @FXML
    private Button futterHinzufuegenButton;
    @FXML
    TableColumn<Mitarbeiter, String> mitarbeiterNameCol;
    @FXML
    TableColumn<Mitarbeiter, String> mitarbeiterVornameCol;
    @FXML
    TableColumn<Mitarbeiter, String> mitarbeiterPersonalnummerCol;
    @FXML
    TableColumn<Mitarbeiter, String> mitarbeiterArbeitszeitCol;
    @FXML
    TableColumn<Mitarbeiter, String> mitarbeiterTelefonCol;
    @FXML
    TableColumn<Mitarbeiter, LocalDate> mitarbeiterGeburtsdatumCol;
    @FXML
    TableColumn<Mitarbeiter, String> mitarbeiterBerufCol;
    
    void setMain(ZooManager zooManager) {
        this.main = zooManager;
    }

    @FXML
    private void openAddMitarbeiterWindow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddMitarbeiterWindow.fxml"));
        Parent root = (Parent) loader.load();
        MitarbeiterInterfaceController ctrl = loader.getController();
        ctrl.setMain(main);
        
       
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/style.css");
        
        Stage stage = new Stage();
        stage.setTitle("Neuen Mitarbeiter erstellen");
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    
    
}
