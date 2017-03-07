import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

// de unde e libraria asta???? Daca folosesti o librarie adauga-o in gradle
//import com.oracle.tools.packager.Log;

/**
 * @author Iulian Aftene
 */
public class Util
{

    public static void exportToXML(Agenda agenda)
    {
        // citeste despre AutoClosable
        try(XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Agenda.xml"))))
        {
            encoder.writeObject(agenda);
        }
        catch (FileNotFoundException fileNotFound)
        {
            Logger.getGlobal().info("ERROR: While Creating or Opening the File Agenda.xml");
        }
    }

    public static Agenda importFromXml() throws IOException
    {
        XMLDecoder decoder = new XMLDecoder(
            new BufferedInputStream(new FileInputStream("Agenda.xml")));

        Logger.getGlobal().info("ERROR: File Agenda.xml not found");

        return (Agenda) decoder.readObject();
    }

    public static String getUserInput() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        return br.readLine();
    }

    public static Contact createContact() throws IOException
    {
        Logger logger = Logger.getLogger(Main.class.getName());

        logger.info("name: ");
        String name = Util.getUserInput();

        logger.info("surname: ");
        String surname = Util.getUserInput();

        logger.info("phoneNumber: ");
        String phoneNumber = Util.getUserInput();

        logger.info("emailAddress: ");
        String emailAddress = Util.getUserInput();

        return (new Contact(name, surname, phoneNumber, emailAddress));
    }
}
