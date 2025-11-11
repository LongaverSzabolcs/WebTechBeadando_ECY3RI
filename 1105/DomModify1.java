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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomModify1 {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException {
        File xmFile = new File("orarend.xml");

        //gyarigazgatas
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
        File ujFile = new File("orarend1.xml");
        StreamResult console = new StreamResult(System.out);
        StreamResult file = new StreamResult(ujFile);

        //hozzaadunk minden orahoz egy oraado elemet
        NodeList oralista = doc.getElementsByTagName("ora");
        for (int i = 0; i < oralista.getLength(); i++) {
            oralista.item(i).appendChild(doc.createElement("oraado").appendChild(doc.createTextNode("Placeholder Istvan")));
        }

        //output konzolra
        transf.transform(source, console);
        //output fajlba (ITT NEM KELL)
        //transf.transform(source, file);

        //kovektezonek pedig minden ora tipusat modositjuk eloadas-ra
        for (int i = 0; i < oralista.getLength(); i++) {
            oralista.item(i).getAttributes().getNamedItem("tipus").setNodeValue("elm");
        }

        //output konzolra
        transf.transform(source, console);
        //output fajlba
        transf.transform(source, file);
    }       
}