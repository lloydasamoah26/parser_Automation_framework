package Test;

import Utils.DomParsers.DomParser_users_Txt;
import Utils.Objects.User;
import Utils.SaxParsers.SaxParser_Users_Txt;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by lloydasamoah on 02/08/2017.
 */
public class DomParserTest {
    @Test
    public static void test_to_return_things_from_dom_parser() throws IOException, SAXException, ParserConfigurationException {

         User user1 = DomParser_users_Txt.parseDocument(0,"https://preprod.yopa.co.uk","/XMLFiles/users.txt");
         System.out.print("User 1's name is: "+ user1.getFirstname());



    }
}
