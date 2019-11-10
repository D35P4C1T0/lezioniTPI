/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.AnchorPane;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

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

    XMLtoAgenda importer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: fetch dei contatti dall'xml
        this.listaContatti = null;
        try {
            XMLtoAgenda importer = new XMLtoAgenda("contatti.xml");
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.fieldNome.setDisable(true);
        this.fieldCognome.setDisable(true);
        this.fieldNTel.setDisable(true);
    }

    @FXML
    private void allowEdit(ActionEvent event) {
        this.fieldNome.setDisable(false);
        this.fieldCognome.setDisable(false);
        this.fieldNTel.setDisable(false);
    }

    @FXML
    private void addContattoToAgenda(ActionEvent event) {
        if (this.fieldNome.getText() == "" || this.fieldCognome.getText() == "" || this.fieldNTel.getText() == "") {
            return;
        }

        //Agenda temp = this.importer.getAgendaFromXML();
        Contatto tempCnt = new Contatto(this.fieldNome.getText(), this.fieldCognome.getText(), this.fieldNTel.getText());
        //temp.addContatto(tempCnt);

    }

    @FXML
    private void writeToXML(ActionEvent event) {
        //todo
    }

    @FXML
    private void fillFields(ContextMenuEvent event) {
        Contatto selezionato = (Contatto) this.listaContatti.getSelectionModel().getSelectedItems();
        this.fieldNome.setText(selezionato.getNome());
        this.fieldCognome.setText(selezionato.getCognome());
        this.fieldNTel.setText(selezionato.getnTel());
    }
}
