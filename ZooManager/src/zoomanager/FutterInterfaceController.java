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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 *
 * @author Philipp Uesbeck
 */
public class FutterInterfaceController implements Initializable {
    
    public ZooManager main;
    
    @FXML
    private Button futterFertigButton;
    @FXML
    private Button futterAbbrechenButton;
    @FXML
    private TextField futterFuttersorteTextField;
    @FXML
    private TextField futterFuttermengeTextField;
    @FXML 
    private ChoiceBox<Lagerungsart> futterLagerungsartCoiceBox;
    
    void setMain (ZooManager zooManager){
        this.main = zooManager;
    }



@FXML
    private void futterFertigButtonAction(ActionEvent event) {
        if (checkInputs()) {
        String futtersorte = futterFuttersorteTextField.getText();
        String futtermenge = futterFuttermengeTextField.getText();
        Lagerungsart lagerungsart = (Lagerungsart) futterLagerungsartChoiceBox.getValue();
        main.addFutter(new Futter(futtersorte, futtermenge, lagerungsart));
        Stage stage = (Stage) futterAbbrechenButton.getScene().getWindow();
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
    private void futterAbbrechenButtonAction(ActionEvent event) {
        Stage stage = (Stage) futterAbbrechenButton.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        futterLagerungsartChoiceBox.getItems().addAll(Lagerungsart.values());
    }

    private boolean checkInputs() {
        return 
    !futterFuttersorteTextField.getText().trim().isEmpty() &&
    !futterFuttermengeTextField.getText().trim().isEmpty() &&
     futterLagerungsartChoiceBox.getValue() != null;
        
    }
    
    
}