import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomRead {
    public static void main(String[] args) {

        File xmFile = new File("hallgatok.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            //factory setup
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmFile);
            doc.getDocumentElement().normalize();

            //mi a gyokerelem?
            System.out.println("gyokerelem: " + doc.getDocumentElement().getNodeName());

            //nodelist
            NodeList hallgatolista = doc.getElementsByTagName("hallgato");
            
            for (int i = 0; i < hallgatolista.getLength(); i++) {
                //i-edik node a nodelistben
                Node jelenlegi = hallgatolista.item(i);
                System.out.println("----------------\njelenlegi elem: " + jelenlegi.getNodeName());

                if (jelenlegi.getNodeType() == Node.ELEMENT_NODE) {

                    Element e = (Element) jelenlegi;
                    
                    String veznev = e.getElementsByTagName("vezeteknev")
                        .item(0).getTextContent();
                    String kernev = e.getElementsByTagName("keresztnev")
                        .item(0).getTextContent();
                    String fogl = e.getElementsByTagName("foglalkozas")
                        .item(0).getTextContent();

                    System.out.println("ID: " + e.getAttribute("id"));
                    System.out.println("Vezeteknev: " + veznev);
                    System.out.println("Keresztnev: " + kernev);
                    System.out.println("Foglalkozas:" + fogl);

                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }
}