//package domecy3ri; VSCode-ot hasznalok Java-hoz, azon belul pedig 
//nehezkes package-ekkel szorakozni. Tfh. hogy itt tenyleg ezen a package-n belul
// van a file!

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

public class DomRead {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

        File xmFile = new File("hallgatok.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmFile);
        doc.getDocumentElement().normalize();

        //mi a gyokerelem?
        System.out.println("gyokerelem: " + doc.getDocumentElement().getNodeName());

        //nodelist
        NodeList hallgatoLista = doc.getElementsByTagName("hallgato");
            
        for (int i = 0; i < hallgatoLista.getLength(); i++) {
            //i-edik node a nodelistben
            Node jelenlegi = hallgatoLista.item(i);
            System.out.println("\njelenlegi elem: " + jelenlegi.getNodeName());

            if (jelenlegi.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) jelenlegi;
                
                String id = e.getAttribute("id");
                String veznev = e.getElementsByTagName("vezeteknev")
                    .item(0).getTextContent();
                String kernev = e.getElementsByTagName("keresztnev")
                    .item(0).getTextContent();
                String fogl = e.getElementsByTagName("foglalkozas")
                    .item(0).getTextContent();

                System.out.println("ID: " + id);
                System.out.println("Vezeteknev: " + veznev);
                System.out.println("Keresztnev: " + kernev);
                System.out.println("Foglalkozas:" + fogl);

            }
        }

    }
}