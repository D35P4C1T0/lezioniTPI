/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesxml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author matteo
 */
public class XMLtoList {

    /**
     * @param args the command line arguments
     */
    
    private NodeList nList;

    public NodeList getTree(String filename) throws ParserConfigurationException, SAXException, IOException {
        // TODO code application logic here
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(filename));
        document.getDocumentElement().normalize();
        Element root = document.getDocumentElement();
        //System.out.println(root.getNodeName());
        this.nList = document.getElementsByTagName("employee");
        return this.nList;
    }

    
    @Override
    public String toString() {
        String out = "";
        for (int temp = 0; temp < this.nList.getLength(); temp++) {
            Node node = this.nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                out += ("ID impiegato: " + eElement.getAttribute("id"))
                        + ("Nome: " + eElement.getElementsByTagName("firstName").item(0).getTextContent()) + "\n"
                        + ("Cognome: " + eElement.getElementsByTagName("lastName").item(0).getTextContent()) + "\n"
                        + ("Luogo: " + eElement.getElementsByTagName("location").item(0).getTextContent()) + "\n";
                /*System.out.println("ID impiegato: " + eElement.getAttribute("id"));
                System.out.println("Nome: " + eElement.getElementsByTagName("firstName").item(0).getTextContent());
                System.out.println("Cognome: " + eElement.getElementsByTagName("lastName").item(0).getTextContent());
                System.out.println("Luogo: " + eElement.getElementsByTagName("location").item(0).getTextContent());*/
            }
        }
        return out;
    }
}
