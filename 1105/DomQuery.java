import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomQuery  {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException {
        File xmFile = new File("hallgatok.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmFile);
        doc.getDocumentElement().normalize();

        NodeList hallgatolista = doc.getElementsByTagName("hallgato");
        
        //vezeteknevek kiirasa
        System.out.println("gyoker elem: " + doc.getDocumentElement().getNodeName() + "\n-------------\n");
        for (int i = 0; i < hallgatolista.getLength(); i++) {
            System.out.println("aktualis elem:\n" + hallgatolista.item(i).getNodeType());
            System.out.println("vezeteknev: " + hallgatolista.item(i).getChildNodes().item(0).getTextContent());
        }


    }


}
