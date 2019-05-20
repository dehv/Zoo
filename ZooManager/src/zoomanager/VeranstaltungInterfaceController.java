/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomanager;

import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author David Brunschier
 */
public class VeranstaltungInterfaceController implements Initializable {

    public ZooManager main;
    private final ObservableList<Mitarbeiter> veranstaltungsMitarbeiter = FXCollections.observableArrayList();
    @FXML
    private Button veranstlatungFertigButton;
    @FXML
    private Button veranstaltungAbbrechenButton;
    @FXML
    private TextField veranstaltungNameTextField;
    @FXML
    private ChoiceBox<Tag> veranstaltungTagChoiceBox;
    @FXML
    private ChoiceBox<String> veranstaltungZeitChoiceBox;
    @FXML
    private ListView<Mitarbeiter> veranstaltungMitarbeiterListView;
    @FXML
    private ChoiceBox<Gehege> veranstaltungGehegeChoiceBox;
    @FXML
    private ChoiceBox<Mitarbeiter> veranstaltungMitarbeiterChoiceBox;
    @FXML
    private Button veranstaltungAddMitarbeiterButton;
    @FXML
    private Button veranstaltungDelMitarbeiterButton;

    void setMain(ZooManager zooManager) {
        this.main = zooManager;
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        veranstaltungTagChoiceBox.getItems().addAll(Tag.values());
        veranstaltungZeitChoiceBox.getItems().addAll(
               "8:00-9:00",
               "9:00-10:00",
               "10:00-11:00",
               "11:00-12:00",
               "13:00-14:00",
               "14:00-15:00",
               "15:00-16:00",
               "16:00-17:00",
               "17:00-18:00",
               "18:00-19:00");
        if (!main.getMitarbeiterListe().isEmpty()) {
            veranstaltungMitarbeiterChoiceBox.getItems().setAll(main.getMitarbeiterListe());
        } else {
            veranstaltungMitarbeiterChoiceBox.setDisable(true);
            System.out.print("Keine Mitarbeiter in der Liste!");
        }
        
        if (!main.getGehegeListe().isEmpty()) {
            veranstaltungGehegeChoiceBox.getItems().addAll(main.getGehegeListe());
        } else {
            veranstaltungGehegeChoiceBox.setDisable(true);
            System.out.print("Keine Gehege in der Liste!");
        }
        veranstaltungMitarbeiterListView.setItems(veranstaltungsMitarbeiter);
    }

    

    @FXML
    private void VeranstaltungFertigButtonAction(ActionEvent event) {
        if (checkInputs()){
            String name = veranstaltungNameTextField.getText();
            Tag tag = veranstaltungTagChoiceBox.getValue();
            String zeitStr = veranstaltungZeitChoiceBox.getValue().toString();
            int zeit = Integer.parseInt(zeitStr.substring(0, zeitStr.indexOf(":")));
            ObservableList<Mitarbeiter> mitarbeiter = veranstaltungsMitarbeiter;
            Gehege gehege = veranstaltungGehegeChoiceBox.getValue();
            int index = Tag.valueOf(tag.toString()).ordinal();
            Veranstaltung uebergabe = new Veranstaltung(name, zeit, tag, gehege, mitarbeiter);
            main.addVeranstaltung(uebergabe);
            main.timeTable.get(zeit-8).veranstaltung[index] = uebergabe;
            Stage stage = (Stage) veranstaltungAbbrechenButton.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Fehlende Werte");
            alert.setHeaderText(null);
            alert.setContentText("Bitte geben Sie für alle Felder einen Wert ein und versuchen Sie es nochmal!");
            
            alert.showAndWait();
        }
        
    }

    @FXML
    private void VeranstaltungAbbrechenButtonAction(ActionEvent event) {
        Stage stage = (Stage) veranstaltungAbbrechenButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void addMitarbeiterVeranstaltungButtonAction(ActionEvent event) {
        Mitarbeiter uebergabe = veranstaltungMitarbeiterChoiceBox.getValue();
        veranstaltungsMitarbeiter.add(uebergabe);
        
    }

    @FXML
    private void delMitarbeiterVeranstaltungButtonAction(ActionEvent event) {
        veranstaltungsMitarbeiter.remove(veranstaltungMitarbeiterListView.getSelectionModel().getSelectedItem());
    }
    
    private boolean checkInputs() {
        return !veranstaltungNameTextField.getText().trim().isEmpty() &&
            veranstaltungTagChoiceBox.getValue() != null &&
            veranstaltungZeitChoiceBox.getValue() != null &&
            !veranstaltungsMitarbeiter.isEmpty() &&
            veranstaltungGehegeChoiceBox.getValue() != null;
    }
    
}
