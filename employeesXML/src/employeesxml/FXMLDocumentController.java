/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    private void handleButtonAction(ActionEvent event) throws ParserConfigurationException, SAXException, IOException {
        XMLtoList listaNodi = new XMLtoList();
        listaNodi.getTree("employees.xml");
        //listaPersone.set;
        listaPersone.getItems().add(listaNodi.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //todo
    }

}
