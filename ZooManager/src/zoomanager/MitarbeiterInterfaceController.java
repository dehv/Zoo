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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author David Brunschier
 */
public class MitarbeiterInterfaceController implements Initializable {

    public ZooManager main;
    
    @FXML
    private TextField mitarbeiterVornameTextField;
    @FXML
    private TextField mitarbeiterNameTextField;
    @FXML
    private TextField mitarbeiterPersonalnummerTextField;
    @FXML
    private DatePicker mitarbeiterGeburtsdatumDatePicker;
    @FXML
    private TextField mitarbeiterAdresseTextField;
    @FXML
    private TextField mitarbeiterTelefonTextField;
    @FXML
    private ChoiceBox<Geschlecht> mitarbeiterGeschlechtChoiceBox;
    @FXML
    private TableView<Gehege> mitarbeiterGehegeTable;
    @FXML
    private Button mitarbeiterFertigButton;
    @FXML
    private Button mitarbeiterAbbrechenButton;
    @FXML
    private MenuButton mitarbeiterGehegeMenuButton;

    void setMain(ZooManager zooManager) {
        this.main = zooManager;
    }
    
    @FXML
    private void mitarbeiterFertigButtonAction(ActionEvent event) {
        if (!checkInputs()) {
        String vorname = mitarbeiterVornameTextField.getText();
        String name = mitarbeiterNameTextField.getText();
        String addresse = mitarbeiterAdresseTextField.getText();
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
        //TODO Warnung einblenden
        }
    }

    @FXML
    private void mitarbeiterAbbrechenButtonAction(ActionEvent event) {
        Stage stage = (Stage) mitarbeiterAbbrechenButton.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mitarbeiterGeschlechtChoiceBox.getItems().addAll(Geschlecht.values());
    }

    private boolean checkInputs() {
        return 
    mitarbeiterVornameTextField.getText().trim().isEmpty() &&
    mitarbeiterNameTextField.getText().trim().isEmpty() &&
    mitarbeiterAdresseTextField.getText().trim().isEmpty() &&
    mitarbeiterTelefonTextField.getText().trim().isEmpty() &&
    mitarbeiterGeburtsdatumDatePicker.getValue() == null &&
    mitarbeiterGeschlechtChoiceBox.getValue() == null;
        
    }
    
    
}
