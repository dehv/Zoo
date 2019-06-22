package zoomanager;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
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
public class GehegeInterfaceController implements Initializable {

        public ZooManager main;
    
    @FXML
    private TextField gehegeNameTextField;
    @FXML
    private TextField gehegeGroesseTextField;
    @FXML
    private Button gehegeFertigButton;
    @FXML
    private Button gehegeAbbrechenButton;
    
    void setMain(ZooManager zooManager) {
        this.main = zooManager;
    }
    
    @FXML
    private void gehegeFertigButtonAction(ActionEvent event) {
        if (checkInputs()) {
        String name = gehegeNameTextField.getText();
        String groesse = gehegeGroesseTextField.getText();
        main.addGehege(new Gehege(name, groesse));
        Stage stage = (Stage) gehegeAbbrechenButton.getScene().getWindow();
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
    private void gehegeAbbrechenButtonAction(ActionEvent event) {
        Stage stage = (Stage) gehegeAbbrechenButton.getScene().getWindow();
        stage.close();
    }
    
        private boolean checkInputs() {
        return 
    !gehegeNameTextField.getText().trim().isEmpty() &&
    !gehegeGroesseTextField.getText().trim().isEmpty();
        
    }
    
     //Initializes the controller class.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
