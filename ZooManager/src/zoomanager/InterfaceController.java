/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomanager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author David Brunschier
 */
public class InterfaceController {
    
    public ZooManager main;
    @FXML
    private TableView<Mitarbeiter> homeMitarbeiterTable;
    @FXML
    private TableView<Tier> homeTiereTable;
    @FXML
    private TableView<Mitarbeiter> mitarbeiterTable;
    @FXML
    private Button mitarbeiterHinzufuegenButton;
    @FXML
    private TableView<Tier> tiereTable;
    @FXML
    private Button tierHinzufuegenButton;
    @FXML
    private TableView<Gehege> gehegeTable;
    @FXML
    private Button gehegeHinzufuegenButton;
    @FXML
    private TableView<Futter> futterTable;
    @FXML
    private Button futterHinzufuegenButton;
    @FXML
    private ListView<Veranstlatung> homeVeranstaltungList;
    
    void setMain(ZooManager zooManager) {
        this.main = zooManager;
    }
    
}
