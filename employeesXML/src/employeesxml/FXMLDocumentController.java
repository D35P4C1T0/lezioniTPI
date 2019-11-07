/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesxml;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author 71299951
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private ListView<String> listaPersone;
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoCognome;
    @FXML
    private TextField campoPaese;
    @FXML
    private TextField campoID;
    @FXML
    private Button buttonAggiungiDipendente;

    @FXML
    private void update(ActionEvent event) throws ParserConfigurationException, SAXException, IOException {
        XMLtoList listaNodiLavoratori = new XMLtoList();
        listaNodiLavoratori.getTree("employees.xml");
        //listaPersone.set;
        if (addPersonaDaCampi() != null) {
            listaNodiLavoratori.addLavoratore(addPersonaDaCampi());
        }

        listaPersone = new ListView<>();
        listaPersone.getItems().addAll((Collection) listaNodiLavoratori.getListaLavoratori()); //aggiorna listview

    }

    private Persona addPersonaDaCampi() {
        if (campoID.getText() == "" && campoNome.getText() == "" && campoCognome.getText() == "" && campoPaese.getText() == "") {
            return null;
        }
        return new Persona(campoID.getText(), campoNome.getText(), campoCognome.getText(), campoPaese.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //todo
    }

}
