//package domecy3ri; VSCode-ot hasznalok Java-hoz, azon belul pedig 
//nehezkes package-ekkel szorakozni. Tfh. hogy itt tenyleg ezen a package-n belul
// van a file!

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class DomWrite {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException {
        
        File xmFile = new File("hallgatok.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmFile);
        doc.getDocumentElement().normalize();

        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transf = tFactory.newTransformer();

        transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transf.setOutputProperty(OutputKeys.INDENT, "yes");
        transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        DOMSource source = new DOMSource(doc);
        File ujFile = new File("hallgatok1.xml");
        StreamResult console = new StreamResult(System.out);
        StreamResult file = new StreamResult(ujFile);

        transf.transform(source, console);
        transf.transform(source, file);
    }
}

