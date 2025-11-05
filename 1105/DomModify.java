import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class DomModify {
    public static void main(String[] args) {
        int id = Integer.parseInt(args[0]);
        String newKeresztnev = args[1];
        String newVezeteknev = args[2];

        File xmFile = new File("hallgatok.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmFile);
            doc.getDocumentElement().normalize();

            NodeList hallgatolista = doc.getElementsByTagName("hallgato");
            for (int i = 0; i < hallgatolista.getLength(); i++) {
                Node jelenlegi = hallgatolista.item(i);

                if (jelenlegi.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) jelenlegi;

                    int currentId = Integer.parseInt(e.getAttribute("id"));
                    if (currentId == id) {
                        e.getElementsByTagName("keresztnev").item(0).setTextContent(newKeresztnev);
                        e.getElementsByTagName("vezeteknev").item(0).setTextContent(newVezeteknev);
                        break;
                    }
                }
            }

            //convert the dom object back to xml and write it to console
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);



        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
