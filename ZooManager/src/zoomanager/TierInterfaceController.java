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
 * @author Jonas Todt
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
    private TextField tierGroesseTextField;
    @FXML
    private TextField tierGewichtTextField;
    @FXML
    private DatePicker tierGeburtsdatumDatePicker;
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


  

    @FXML
    private void tierFertigButtonAction(ActionEvent event) {
               if (checkInputs()) {
        String name = tierNameTextField.getText();
        String art = tierArtTextField.getText();
        String idnummer = tierIdNummerTextField.getText();
        String groesse = tierGroesseTextField.getText();
        String gewicht = tierGewichtTextField.getText();
        LocalDate geburtsdatum = tierGeburtsdatumDatePicker.getValue();
        Geschlecht geschlecht = (Geschlecht) tierGeschlechtChoiceBox.getValue();
        main.addTier(new Tier(name, art, idnummer, groesse,gewicht, geburtsdatum, geschlecht));
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
    private void tierAbbrechenButtonAction(ActionEvent event) {
        Stage stage = (Stage) tierAbbrechenButton.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tierGeschlechtChoiceBox.getItems().addAll(Geschlecht.values());
    }

        private boolean checkInputs() {
            return 
    !tierArtTextField.getText().trim().isEmpty() &&
    !tierNameTextField.getText().trim().isEmpty() &&
    !tierIdNummerTextField.getText().trim().isEmpty() &&
    !tierGroesseTextField.getText().trim().isEmpty() &&
    !tierGewichtTextField.getText().trim().isEmpty() &&
    tierGeburtsdatumDatePicker.getValue() != null &&
    tierGeschlechtChoiceBox.getValue() != null;
    
    }
}
