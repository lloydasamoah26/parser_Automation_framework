package Test;

import Utils.Objects.User;
import Utils.SaxParsers.SaxParser_Handler_Users_Txt;
import Utils.SaxParsers.SaxParser_Users_Txt;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by lloydasamoah on 01/08/2017.
 */
public class SaxParserTest {



    @Test
    public static void test_to_return_things_from_sax_parser() throws IOException, SAXException, ParserConfigurationException {

        User user1 = SaxParser_Users_Txt.parseDocument(0,"https://preprod.yopa.co.uk","/XMLFiles/users.txt");
        System.out.print("User 1's name is: "+ user1.getFirstname());


    }
}
