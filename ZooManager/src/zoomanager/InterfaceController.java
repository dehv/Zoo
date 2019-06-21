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
import zoomanager.Mitarbeiter;
import zoomanager.ZooManager;

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
    ListView<Veranstaltung> homeVeranstaltungList;
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
    @FXML
    private Button veranstaltungHinzufuegenButton;
    @FXML
    TableView<TimeTable> veranstaltungTable;
    @FXML
    TableColumn<TimeTable, Integer> veranstaltungTableZeitCol;
    @FXML
     TableColumn<TimeTable, Veranstaltung[]> veranstaltungTableMontag;
    @FXML
     TableColumn<TimeTable, Veranstaltung> veranstaltungTableDienstag;
    @FXML
     TableColumn<TimeTable, Veranstaltung> veranstaltungTableMittwoch;
    @FXML
     TableColumn<TimeTable, Veranstaltung> veranstaltungTableDonnerstag;
    @FXML
     TableColumn<TimeTable, Veranstaltung> veranstaltungTableFreitag;
    @FXML
     TableColumn<TimeTable, Veranstaltung> veranstaltungTableSamstag;
    @FXML
     TableColumn<TimeTable, Veranstaltung> veranstaltungTableSonntag;
    
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
    
        @FXML
    private void openAddTierWindow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddTierWindow.fxml"));
        Parent root = (Parent) loader.load();
        TierInterfaceController ctrl = loader.getController();
        ctrl.setMain(main);
        
       
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/style.css");
        
        Stage stage = new Stage();
        stage.setTitle("Neues Tier erstellen");
        stage.setScene(scene);
        stage.show();
    }
    
 
    /*
    
    VERSUCH TIERWINDOW ZU ÖFFNEN 
    
     @FXML
    private void openAddTierWindow(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddTierWindow.fxml"));
            Parent root1 = (Parent) loader.load();
            TierInterfaceController ctrl = loader.getController();
            Stage stage = new Stage ();
            stage.setTitle("Neues Tier hinzufügen");
            stage.setScene(new Scene (root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Fenster kann nicht geladen werden");
        }
    }
   */ 
    @FXML
    private void openAddVeranstaltungWindow(ActionEvent event) throws IOException {
        
        /*
        Das hier ermöglicht den fx:controller beizubehalten aber gleichzeitig auch
        ZooManager zu übergeben, bevor der Controller initialisiert wird, sodass die Mitarbeiter und Gehege in den Auswahlen zur Verfügung stehen.
        */
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddVeranstaltungWindow.fxml"));
        loader.setControllerFactory(clazz -> {
            Object controller;
            try {
                controller = clazz.getConstructor().newInstance();
            } catch (ReflectiveOperationException ex) {
                throw new RuntimeException(ex);
            }
            if (controller instanceof VeranstaltungInterfaceController){
                ((VeranstaltungInterfaceController) controller).setMain(main);
            }
             return controller;
        });
        // Danke StackOverflow! https://stackoverflow.com/questions/50812115/how-to-give-the-controller-access-to-the-main-app-before-the-initialize-method#
        Parent root = (Parent) loader.load();
        
        
       
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/style.css");
        
        Stage stage = new Stage();
        stage.setTitle("Neue Veranstaltung erstellen");
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    
    
}
