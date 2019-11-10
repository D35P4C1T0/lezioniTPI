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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
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
    public Agenda agenda;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void addContattoToAgenda(ActionEvent event) {
        if (this.fieldNome.getText() == "" || this.fieldCognome.getText() == "" || this.fieldNTel.getText() == "") {
            return;
        }

        int indiceLista = this.listaContatti.getSelectionModel().getSelectedIndex();
        //this.agenda.rmvContattoIndex(indiceLista);
        //System.out.println(indiceLista);

        //Agenda temp = this.importer.getAgendaFromXML();
        Contatto tempCnt = new Contatto(this.fieldNome.getText(), this.fieldCognome.getText(), this.fieldNTel.getText());
        //temp.addContatto(tempCnt);
        if (indiceLista != -1) {
            this.agenda.rmvContattoIndex(indiceLista);
            this.agenda.addContattoIndex(tempCnt, indiceLista);
        } else {
            this.agenda.addContatto(tempCnt);
        }
        update();

    }

    @FXML
    private void writeToXML(ActionEvent event) {
        //todo
        XmlExport exporter = new XmlExport();
        exporter.export(agenda);
    }

    @FXML
    private void importXML(ActionEvent event) throws ParserConfigurationException, SAXException, IOException {
        // TODO: fetch dei contatti dall'xml
        this.importer = new XMLtoAgenda("contatti.xml");
        this.agenda = new Agenda(this.importer.getListaContatti());
        update();

    }

    private void update() {
        this.listaContatti.getItems().clear();
        ArrayList<Contatto> tempLista = this.agenda.getListaContatti();
        ArrayList<String> listaContattiString = new ArrayList<>();
        for (int i = 0; i < tempLista.size(); i++) {
            listaContattiString.add(tempLista.get(i).toString());
            ///System.out.println(tempLista.get(i));
        }

        //this.listaContatti.getItems().add("galapagos");
        //this.listaContatti.setItems((ObservableList<String>) listaContattiString);
        //this.listaContatti.getItems().add("diocane");
        this.listaContatti.getItems().addAll(listaContattiString);

    }

    @FXML
    private void fillFields(MouseEvent event) {
        //this.listaContatti.getSelectionModel().getSelectedItem();
        int indiceLista = this.listaContatti.getSelectionModel().getSelectedIndex();
        Contatto tempContatto = this.agenda.getListaContatti().get(indiceLista);

        this.fieldNome.setText(tempContatto.getNome());
        this.fieldCognome.setText(tempContatto.getCognome());
        this.fieldNTel.setText(tempContatto.getnTel());
        //System.out.println(tempContatto);

    }

    @FXML
    private void deleteContatto(ActionEvent event) {
        int indiceLista = this.listaContatti.getSelectionModel().getSelectedIndex();
        this.agenda.rmvContattoIndex(indiceLista);
        update();
    }
}
