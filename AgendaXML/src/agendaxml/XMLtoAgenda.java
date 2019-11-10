/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaxml;

/**
 *
 * @author matteo
 */
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLtoAgenda {

    private NodeList nList;

    public XMLtoAgenda(String XMLfilename) throws ParserConfigurationException, SAXException, IOException {
        this.makeTree(XMLfilename);
    }

    private void makeTree(String filename) throws ParserConfigurationException, SAXException, IOException {
        // TODO code application logic here
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(filename));
        document.getDocumentElement().normalize();
        Element root = document.getDocumentElement();
        //System.out.println(root.getNodeName());
        this.nList = document.getElementsByTagName("contatti");
    }

    public List<Contatto> getListaContatti() {
        List<Contatto> out = null;
        for (int temp = 0; temp < this.nList.getLength(); temp++) {
            Node node = this.nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;

                String nome = eElement.getElementsByTagName("nome").item(0).getTextContent();
                String cognome = eElement.getElementsByTagName("cognome").item(0).getTextContent();
                String telefono = eElement.getElementsByTagName("nTel").item(0).getTextContent();
                Contatto cnt = new Contatto(nome, cognome, telefono);
                out.add(cnt);
            }
        }
        return out;
    }

    public Agenda getAgendaFromXML() {
        return new Agenda(this.getListaContatti());
    }
}
