/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author matteo
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane rmvContattoButton;
    @FXML
    private TextField fieldNome;
    @FXML
    private TextField fieldCognome;
    @FXML
    private TextField fieldNTel;
    @FXML
    private Button editButton;
    @FXML
    private Button removeContattoButton;
    @FXML
    private Button addContattoButton;
    @FXML
    private Button saveButton;
    @FXML
    private ListView<Contatto> listaContatti;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: fetch dei contatti dall'xml
        this.listaContatti = null;
    }

    @FXML
    private void allowEdit(ActionEvent event) {
    }

    @FXML
    private void addContattoToAgenda(ActionEvent event) {
    }

    @FXML
    private void writeToXML(ActionEvent event) {
    }

    @FXML
    private void fillFields(ContextMenuEvent event) {
        Contatto selezionato = (Contatto) this.listaContatti.getSelectionModel().getSelectedItems();
        this.fieldNome.setText(selezionato.getNome());
        this.fieldCognome.setText(selezionato.getCognome());
        this.fieldNTel.setText(selezionato.getnTel());
    }
}
