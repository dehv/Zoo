/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomanager;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
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
 * @author $TH5J00-I3TNS7R3KADS
 */
public class TierInterfaceController implements Initializable {

    public ZooManager main;
    
    @FXML
    private TextField tierNameTextField;
    @FXML
    private TextField tierArtTextField;
    @FXML
    private TextField tierIdNummerTextField;
    @FXML
    private DatePicker tierGeburtsdatumDatePicker;
    @FXML
    private TextField tierGroesseTextField;
    @FXML
    private ChoiceBox<?> tierGeschlechtChoiceBox;
    @FXML
    private TableView<?> tierFutterTable;
    @FXML
    private Button tierFertigButton;
    @FXML
    private Button tierAbbrechenButton;
    
    void setMain(ZooManager zooManager) {
        this.main = zooManager;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       if (checkInputs()) {
        String art = tierArtTextField.getText();
        String name = tierNameTextField.getText();
        String idnummer = tierIdNummerTextField.getText();
        String telefonnummer = mitarbeiterTelefonTextField.getText();
        String personalnummer = mitarbeiterPersonalnummerTextField.getText();
        //TODO beruf enum??
        String beruf = "Noch nicht implementiert!";
        LocalDate geburtstag = mitarbeiterGeburtsdatumDatePicker.getValue();
        Geschlecht geschlecht = (Geschlecht) mitarbeiterGeschlechtChoiceBox.getValue();
        main.addMitarbeiter(new Mitarbeiter(vorname, name, addresse, telefonnummer, beruf, geburtstag, geschlecht, personalnummer));
        Stage stage = (Stage) mitarbeiterAbbrechenButton.getScene().getWindow();
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
    private void tierFertigButtonAction(ActionEvent event) {
    }

    @FXML
    private void tierAbbrechenButtonAction(ActionEvent event) {
    }
    
}
