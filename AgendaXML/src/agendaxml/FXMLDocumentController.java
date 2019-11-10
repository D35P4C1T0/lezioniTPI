/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaxml;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ListView<String> listaContatti;
    @FXML
    private Button importaButton;

    public XMLtoAgenda importer;
    public AgendaManager agenda;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        this.agenda.addContatto(tempCnt);

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

    @FXML
    private void importXML(ActionEvent event) throws ParserConfigurationException, SAXException, IOException {
        // TODO: fetch dei contatti dall'xml
        this.importer = new XMLtoAgenda("contatti.xml");
        this.agenda = new AgendaManager(new Agenda(this.importer.getListaContatti()));
        this.listaContatti = new ListView<>();

        ArrayList<Contatto> tempLista = this.importer.getListaContatti();
        ArrayList<String> listaContattiString = new ArrayList<>();
        for (int i = 0; i < tempLista.size(); i++) {
            listaContattiString.add(tempLista.get(i).toString());
            System.out.println(tempLista.get(i));
        }

        this.listaContatti.getItems().add("galapagos");

        //this.listaContatti.setItems((ObservableList<String>) listaContattiString);
        //this.listaContatti.getItems().add("diocane");
        //this.listaContatti.getItems().addAll(listaContattiString);
    }
}
