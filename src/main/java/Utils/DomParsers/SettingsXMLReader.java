package Utils.DomParsers;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by lloydasamoah on 02/08/2017.
 */
public class SettingsXMLReader {
    //This checks if an xml file exists in the given location and if it does returns the xml file as a document type
    public static Document readXMLFile(String filePath) throws ParserConfigurationException, SAXException, IOException {
        File fXmlFile = new File(filePath);

        if (fXmlFile.exists()) {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            return doc;
        } else {
            throw new IOException("No File exists:" + filePath);
        }

    }
    //This grabs the value required from the xml document which relates to the tag name
    public static String get(String tagname, Document document){
        NodeList nodes = document.getElementsByTagName(tagname);
        return nodes.item(0).getTextContent();
    }
}
