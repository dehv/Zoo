/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomanager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author $TH5J00-I3TNS7R3KADS
 */
public class TierInterfaceController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void tierFertigButtonAction(ActionEvent event) {
    }

    @FXML
    private void tierAbbrechenButtonAction(ActionEvent event) {
    }
    
}
