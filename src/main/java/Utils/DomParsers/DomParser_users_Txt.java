package Utils.DomParsers;

import Utils.Objects.User;
import Utils.SaxParsers.SaxParser_Handler_Users_Txt;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lloydasamoah on 02/08/2017.
 */
public class DomParser_users_Txt {



    public static User parseDocument(int index, String uri, String pathInSource) throws ParserConfigurationException, SAXException, IOException {
        List<User> userList = new ArrayList<>();



        try {
            String current = new java.io.File(".").getCanonicalPath();
            File inputFile = new File(current + pathInSource);

            if(inputFile.exists()) {

                DocumentBuilderFactory dbFactory
                        = DocumentBuilderFactory.newInstance();
                dbFactory.setNamespaceAware(true);
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(inputFile);

                doc.getDocumentElement().normalize();
                NodeList nList = doc.getElementsByTagNameNS(uri, "user");
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        User user = new User();
                        Element eElement = (Element) nNode;
                        String userId = ((Element) nNode).getAttribute("id");
                        String firstName = eElement.getElementsByTagNameNS(uri, "firstname").item(0).getTextContent();
                        String lastName = eElement.getElementsByTagNameNS(uri, "lastname").item(0).getTextContent();
                        String email = eElement.getElementsByTagNameNS(uri, "email").item(0).getTextContent();
                        String password = eElement.getElementsByTagNameNS(uri, "password").item(0).getTextContent();
//                   System.out.println(userId);
//                   System.out.println(firstName);
//                   System.out.println(lastName);
//                   System.out.println(email);
//                   System.out.println(password);
                        user.setId(userId);
                        user.setFirstname(firstName);
                        user.setLastname(lastName);
                        user.setEmail(email);
                        user.setPassword(password);
                        userList.add(user);
                    }


                }
            }else{
                throw new IOException("No File exists:" + inputFile);
            }


        } catch (Exception e) {
              e.printStackTrace();
        }

        return userList.get(index);

    }
}
