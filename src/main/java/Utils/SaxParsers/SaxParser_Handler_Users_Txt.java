package Utils.SaxParsers;

import Utils.Objects.User;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lloydasamoah on 01/08/2017.
 */
public class SaxParser_Handler_Users_Txt extends DefaultHandler {


    private String parameterUri;
    private List<User> userList = null;
    private User user = null;

    boolean bfname = false;
    boolean blname = false;
    boolean bemail = false;
    boolean bpassword = false;


        public List<User> getUserList() {
            return userList;
        }



            public SaxParser_Handler_Users_Txt(String uri) {
            this.parameterUri = uri;
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {


        if (uri.equals(parameterUri) && localName.equalsIgnoreCase("USER")) {
            String id = attributes.getValue("id");
            user = new User();
            user.setId(id);
            System.out.println("the start element is: User with the following id: "+ id);

            if (userList == null) {
                userList = new ArrayList<User>();
            }


        } else if (uri.equals(parameterUri) && localName.equalsIgnoreCase("FIRSTNAME")) {
            bfname = true;
        } else if (uri.equals(parameterUri) && localName.equalsIgnoreCase("LASTNAME")) {
            blname = true;
        } else if (uri.equals(parameterUri) && localName.equalsIgnoreCase("EMAIL")) {
            bemail = true;
        } else if (uri.equals(parameterUri) && localName.equalsIgnoreCase("PASSWORD")) {
            bpassword = true;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (uri.equals(parameterUri) && localName.equalsIgnoreCase("user")) {
            //add Employee object to list
            userList.add(user);
            System.out.println("it got here");
            }
        }

        @Override
        public void characters ( char ch[], int start, int length) throws SAXException {

            if (bfname) {
                String firstName = new String(ch, start, length);
                user.setFirstname(firstName);
                bfname = false;
            } else if (blname) {
                String lastName = new String(ch, start, length);
                user.setLastname(lastName);
                blname = false;
            } else if (bemail) {
                String Email = new String(ch, start, length);
                user.setEmail(Email);
                bemail = false;
            } else if (bpassword) {
                String password = new String(ch, start, length);
                user.setPassword(password);
                bpassword = false;
            }

        }


    }