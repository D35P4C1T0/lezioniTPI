/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubricaXML;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ExportXML implements Export {

    public static final String xmlFilePath = "contatti.xml";

    @Override
    public void export(Agenda agenda) {

        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentFactory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ExportXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        Document document = documentBuilder.newDocument();
        // root element
        Element root = document.createElement("contatti");
        document.appendChild(root);

        for (int i = 0; i < agenda.getListaContatti().size(); i++) {

            Element contatto = document.createElement("contatto");
            root.appendChild(contatto);

            Element nome = document.createElement("nome");
            nome.appendChild(document.createTextNode(agenda.getListaContatti().get(i).getNome()));
            contatto.appendChild(nome);

            Element cognome = document.createElement("cognome");
            cognome.appendChild(document.createTextNode(agenda.getListaContatti().get(i).getCognome()));
            contatto.appendChild(cognome);

            Element nTel = document.createElement("nTel");
            nTel.appendChild(document.createTextNode(agenda.getListaContatti().get(i).getnTel()));
            contatto.appendChild(nTel);

        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(ExportXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(xmlFilePath));

        try {
            transformer.transform(domSource, streamResult);
        } catch (TransformerException ex) {
            Logger.getLogger(ExportXML.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Done creating XML File");

    }

}
