/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomanager;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import zoomanager.Gehege;
import zoomanager.Geschlecht;
import zoomanager.Mitarbeiter;
import zoomanager.ZooManager;

/**
 * FXML Controller class
 *
 * @author Jonas Todt
 */
public class TierInterfaceController implements Initializable {

    public ZooManager main;
    
    private final ObservableList<Futter> tierFutter = FXCollections.observableArrayList();
    @FXML
    private TextField tierNameTextField;
    @FXML
    private TextField tierArtTextField;
    @FXML
    private TextField tierIdNummerTextField;
    @FXML
    private TextField tierGroesseTextField;
    @FXML
    private TextField tierGewichtTextField;
    @FXML
    private DatePicker tierGeburtsdatumDatePicker;
    @FXML
    private ChoiceBox<Geschlecht> tierGeschlechtChoiceBox;
    @FXML
    private ChoiceBox<String> tierFutterzeitChoiceBox;
    @FXML
    private ChoiceBox<Futter> tierFutterChoiceBox;
    @FXML
    private ChoiceBox<Gehege> tierGehegeChoiceBox;
    @FXML
    private Button tierFertigButton;
    @FXML
    private Button tierAbbrechenButton;
    @FXML
    private ListView<Futter> tierFutterListView;
    @FXML
    private Button tierDelFutterButton;
    @FXML
    private Button tierAddFutterButton;
    
    void setMain(ZooManager zooManager) {
        this.main = zooManager;
    }


  

    @FXML
    private void tierFertigButtonAction(ActionEvent event) {
               if (checkInputs()) {
        String name = tierNameTextField.getText();
        String art = tierArtTextField.getText();
        String futterzeit = tierFutterzeitChoiceBox.getValue().toString();
        int zeit = Integer.parseInt(futterzeit.substring(0, futterzeit.indexOf(":")));
        String idnummer = tierIdNummerTextField.getText();
        String groesse = tierGroesseTextField.getText();
        String gewicht = tierGewichtTextField.getText();
        LocalDate geburtsdatum = tierGeburtsdatumDatePicker.getValue();
        Geschlecht geschlecht = (Geschlecht) tierGeschlechtChoiceBox.getValue();
        main.addTier(new Tier(name,art,idnummer,groesse,gewicht,geburtsdatum,geschlecht));
        Stage stage = (Stage) tierAbbrechenButton.getScene().getWindow();
        stage.close();
        }
        else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fehlende Werte");
            alert.setHeaderText(null);
            alert.setContentText("Bitte geben Sie für alle Felder einen Wert ein und versuchen Sie es nochmal!");
            
            alert.showAndWait();
        }
    }  

    @FXML
    private void addFutterTierButtonAction(ActionEvent event) {
        Futter uebergabe = tierFutterChoiceBox.getValue();
        tierFutter.add(uebergabe);
        
    }

    @FXML
    private void delFutterTierButtonAction(ActionEvent event) {
        tierFutter.remove(tierFutterListView.getSelectionModel().getSelectedItem());
    }


    @FXML
    private void tierAbbrechenButtonAction(ActionEvent event) {
        Stage stage = (Stage) tierAbbrechenButton.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tierGeschlechtChoiceBox.getItems().addAll(Geschlecht.values());
        tierFutterzeitChoiceBox.getItems().addAll(
                "8:00",
                "9:00",
                "10:00",
                "11:00",
                "12:00",
                "13:00",
                "14:00",
                "15:00",
                "16:00",
                "17:00",
                "18:00");
        if (!main.getFutterListe().isEmpty()) {
            tierFutterChoiceBox.getItems().setAll(main.getFutterListe());
        } else {
            tierFutterChoiceBox.setDisable(true);
            System.out.print("Keine Mitarbeiter in der Liste!");
        }
        
        if (!main.getGehegeListe().isEmpty()) {
            tierGehegeChoiceBox.getItems().addAll(main.getGehegeListe());
        } else {
            tierGehegeChoiceBox.setDisable(true);
            System.out.print("Keine Gehege in der Liste!");
        }
        
        tierFutterListView.setItems(tierFutter);
    }

        private boolean checkInputs() {
            return 
    !tierArtTextField.getText().trim().isEmpty() &&
    !tierNameTextField.getText().trim().isEmpty() &&
    !tierIdNummerTextField.getText().trim().isEmpty() &&
    !tierGroesseTextField.getText().trim().isEmpty() &&
    !tierGewichtTextField.getText().trim().isEmpty() &&
    tierFutterzeitChoiceBox.getValue() != null &&
    tierGeburtsdatumDatePicker.getValue() != null &&
    tierGeschlechtChoiceBox.getValue() != null;
    
    }
}
