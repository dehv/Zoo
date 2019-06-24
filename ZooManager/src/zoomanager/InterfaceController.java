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
    TableView<Mitarbeiter>                   homeMitarbeiterTable;
    @FXML
    TableColumn<Mitarbeiter, String>         homeMitarbeiterNameCol;
    @FXML
    TableColumn<Mitarbeiter, String>         homeMitarbeiterVornameCol;
    @FXML
    TableColumn<Mitarbeiter, ?>              homeMitarbeiterArbeitszeitCol; 
    @FXML
    private TableView<?>                     homeTiereTable;
    @FXML
    TableColumn<Tier, String>                homeTierArtCol;
    @FXML
    TableColumn<Tier, String>                homeTierNameCol;
    @FXML
    TableColumn<Tier, ?>                     homeTierGehegeCol;
    @FXML
    ListView<Veranstaltung>                  homeVeranstaltungList;
    
    //Mitarbeiter-Reiter
    @FXML
    TableView<Mitarbeiter>                   mitarbeiterTable;
    @FXML
    TableColumn<Mitarbeiter, String>         mitarbeiterNameCol;
    @FXML
    TableColumn<Mitarbeiter, String>         mitarbeiterVornameCol;
    @FXML  
    TableColumn<Mitarbeiter, String>         mitarbeiterPersonalnummerCol;
    @FXML
    TableColumn<Mitarbeiter, String>         mitarbeiterArbeitszeitCol;
    @FXML
    TableColumn<Mitarbeiter, String>         mitarbeiterTelefonCol;
    @FXML
    TableColumn<Mitarbeiter, LocalDate>      mitarbeiterGeburtsdatumCol;
    @FXML
    private Button                           mitarbeiterHinzufuegenButton;
    
    //Tier-Reiter
    @FXML
    private TableView<Tier>                  tiereTable;
    @FXML
    TableColumn<Tier, String>                tierArtCol;
    @FXML
    TableColumn<Tier, String>                tierNameCol;
    @FXML
    TableColumn<Tier, String>                tierIdnummerCol;
    @FXML
    TableColumn<Tier, String>                tierGroesseCol;
    @FXML
    TableColumn<Tier, String>                tierGewichtCol;
    @FXML
    TableColumn<Tier, LocalDate>             tierGeburtsdatumCol;
    @FXML
    TableColumn<Tier, Geschlecht>            tierGeschlechtCol;
    @FXML
    private Button                           tierHinzufuegenButton;
    
    //Gehege-Reiter
    @FXML
    private TableView<?>                     gehegeTable;
    @FXML
    TableColumn<Gehege, String>              gehegeNameCol;
    @FXML
    TableColumn<Gehege, String>              gehegeGroesseCol;
    @FXML
    TableColumn<Gehege, Integer >            gehegeAnzahlTiereCol;   
    @FXML
    private Button                           gehegeHinzufuegenButton;
    
    @FXML
    private TableView<?>                     futterTable;
    @FXML
    TableColumn<Futter, String>              futterFuttersorteCol;
    @FXML
    TableColumn<Futter, String>              futterFuttermengeCol;
    @FXML
    TableColumn<Futter, Lagerungsart>        futterLagerungsartCol;
    @FXML
    private Button                           futterHinzufuegenButton;

    @FXML
    TableView<TimeTable>                     veranstaltungTable;
    @FXML
    TableColumn<TimeTable, Integer>          veranstaltungTableZeitCol;
    @FXML
     TableColumn<TimeTable, Veranstaltung[]> veranstaltungTableMontag;
    @FXML
     TableColumn<TimeTable, Veranstaltung>   veranstaltungTableDienstag;
    @FXML
     TableColumn<TimeTable, Veranstaltung>   veranstaltungTableMittwoch;
    @FXML
     TableColumn<TimeTable, Veranstaltung>   veranstaltungTableDonnerstag;
    @FXML
     TableColumn<TimeTable, Veranstaltung>   veranstaltungTableFreitag;
    @FXML
     TableColumn<TimeTable, Veranstaltung>   veranstaltungTableSamstag;
    @FXML
     TableColumn<TimeTable, Veranstaltung>   veranstaltungTableSonntag;
    @FXML
    private Button                           veranstaltungHinzufuegenButton;
    
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
        zoomanager.TierInterfaceController ctrl = loader.getController();
        ctrl.setMain(main);
        
       
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/style.css");
        
        Stage stage = new Stage();
        stage.setTitle("Neues Tier erstellen");
        stage.setScene(scene);
        stage.show();
    }
    
            @FXML
    private void openAddFutterWindow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddFutterWindow.fxml"));
        Parent root = (Parent) loader.load();
        zoomanager.FutterInterfaceController ctrl = loader.getController();
        ctrl.setMain(main);
        
       
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/style.css");
        
        Stage stage = new Stage();
        stage.setTitle("Neues Futter erstellen");
        stage.setScene(scene);
        stage.show();
    }
    
                @FXML
    private void openAddGehegeWindow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddGehegeWindow.fxml"));
        Parent root = (Parent) loader.load();
        zoomanager.GehegeInterfaceController ctrl = loader.getController();
        ctrl.setMain(main);
        
       
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/style.css");
        
        Stage stage = new Stage();
        stage.setTitle("Neues Futter erstellen");
        stage.setScene(scene);
        stage.show();
    }
    
    
 
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
