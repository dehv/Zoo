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
    
    //Erstellen der Listen für die Daten
    
    private final ObservableList<Mitarbeiter> mitarbeiter =
            FXCollections.observableArrayList(
            );
    
    private final ObservableList<Gehege> gehege =
            FXCollections.observableArrayList(
            );
    
    private final ObservableList<Tier> tiere =
            FXCollections.observableArrayList(
            );
    
    private final ObservableList<Veranstaltung> veranstaltungen =
            FXCollections.observableArrayList(
            );
    
    private final ObservableList<Futter> futter =
            FXCollections.observableArrayList(
            );
    
    public final ObservableList<TimeTable> timeTable = 
            FXCollections.observableArrayList(new TimeTable(8),
                                             new TimeTable(9),
                                             new TimeTable(10),
                                             new TimeTable(11),
                                             new TimeTable(12),
                                             new TimeTable(13),
                                             new TimeTable(14),
                                             new TimeTable(15),
                                             new TimeTable(16),
                                             new TimeTable(17),
                                             new TimeTable(18)
            );
    
    
    //Hinzufügen und entfernen von Daten zu den Listen
    public void addMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter.add(mitarbeiter);
    }
    
    public void removeMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter.remove(mitarbeiter);
    }
    
    public void addVeranstaltung(Veranstaltung veranstaltung) {
        this.veranstaltungen.add(veranstaltung);
    }
    
    public void removeVeranstaltung(Veranstaltung veranstaltung) {
        this.veranstaltungen.remove(veranstaltung);
    }
    
    public void addTier(Tier tier) {
        this.tiere.add(tier);
    }
    
    public void removeTier(Tier tier) {
        this.tiere.remove(tier);
    }
    
    public void addGehege(Gehege gehege) {
        this.gehege.add(gehege);
    }
    
    public void removeGehege(Gehege gehege) {
        this.gehege.remove(gehege);
    }
    
    public void addFutter(Futter futter) {
        this.futter.add(futter);
    }
    
    public void removeFutter(Futter futter) {
        this.futter.remove(futter);
    }
    
    public ObservableList<Mitarbeiter> getMitarbeiterListe() {
        return mitarbeiter;
    }
    
    public ObservableList<Gehege> getGehegeListe() {
        return gehege;
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
            // Tabelle auf der Mitarbeiterseite
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
            
            interfaceController.veranstaltungTableZeitCol.setCellValueFactory(
                    new PropertyValueFactory<TimeTable, Integer>("uhrzeit")
            );
            
            interfaceController.veranstaltungTableMontag.setCellValueFactory(
                    new PropertyValueFactory<TimeTable, Veranstaltung[]>("veranstaltung[0]")
            );
            
            
            
               
            //Setting Items in Tables
            interfaceController.homeMitarbeiterTable.setEditable(false);
            interfaceController.homeMitarbeiterTable.setItems(mitarbeiter);
            interfaceController.homeVeranstaltungList.setItems(veranstaltungen);
            
            
            
            interfaceController.mitarbeiterTable.setItems(mitarbeiter);
            interfaceController.veranstaltungTable.setItems(timeTable);
            
            
            
            
            Scene scene = new Scene(pane);
            
            primaryStage.setScene(scene);
            primaryStage.show();
            
            insertTestData();
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

    private void insertTestData() {
        mitarbeiter.add(new Mitarbeiter("David","Brunschier","An der Stadtlandwehr 33", "012345","help", LocalDate.of(1999,11,27), Geschlecht.MÄNNLICH, "420"));
        mitarbeiter.add(new Mitarbeiter("Test","Testie","An der Stadtlandwehr 33", "012345","help", LocalDate.now(), Geschlecht.WEIBLICH, "69"));
        gehege.add(new Gehege("Testgehege", 20.0f, tiere));
    }
    
    
}
