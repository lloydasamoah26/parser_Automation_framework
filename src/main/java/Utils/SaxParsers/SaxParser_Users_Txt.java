package Utils.SaxParsers;

import Utils.Objects.User;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lloydasamoah on 01/08/2017.
 */
public class SaxParser_Users_Txt {

    public static User parseDocument( int index, String uri, String pathInSource) throws ParserConfigurationException, SAXException, IOException {
        List<User> userList = null;


        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setNamespaceAware(true);
        try {
            String current = new java.io.File(".").getCanonicalPath();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SaxParser_Handler_Users_Txt saxHandler = new SaxParser_Handler_Users_Txt(uri);
            saxParser.parse(new File(current + pathInSource), saxHandler);

             userList = saxHandler.getUserList();
        }catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return userList.get(index);
    }




}
