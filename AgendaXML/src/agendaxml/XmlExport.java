/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaxml;

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

public class XmlExport implements Export {

    public static final String xmlFilePath = "contatti.xml";

    @Override
    public void export(Agenda agenda) {

        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentFactory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XmlExport.class.getName()).log(Level.SEVERE, null, ex);
        }
        Document document = documentBuilder.newDocument();
        // root element
        Element root = document.createElement("contatti");
        document.appendChild(root);

        for (int i = 0; i < agenda.getListaContatti().size(); i++) {

            Element contatto = document.createElement("contatto");
            root.appendChild(contatto);

            //you can also use staff.setAttribute("id", "1") for this
            // firstname element
            Element nome = document.createElement("nome");
            nome.appendChild(document.createTextNode(agenda.getListaContatti().get(i).getNome()));
            contatto.appendChild(nome);

            // lastname element
            Element cognome = document.createElement("cognome");
            cognome.appendChild(document.createTextNode(agenda.getListaContatti().get(i).getCognome()));
            contatto.appendChild(cognome);

            // email element
            Element nTel = document.createElement("nTel");
            nTel.appendChild(document.createTextNode(agenda.getListaContatti().get(i).getnTel()));
            contatto.appendChild(nTel);

        }

        // create the xml file
        //transform the DOM Object to an XML File
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XmlExport.class.getName()).log(Level.SEVERE, null, ex);
        }
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(xmlFilePath));

        try {
            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging
            transformer.transform(domSource, streamResult);
        } catch (TransformerException ex) {
            Logger.getLogger(XmlExport.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Done creating XML File");

    }

}
