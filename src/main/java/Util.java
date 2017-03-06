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

import com.oracle.tools.packager.Log;

/**
 * @author Iulian Aftene
 */
public class Util
{

    public static void exportToXML(Agenda agenda)
    {
        XMLEncoder encoder = null;
        try
        {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Agenda.xml")));
        }
        catch (FileNotFoundException fileNotFound)
        {
            Log.info("ERROR: While Creating or Opening the File Agenda.xml");
        }
        encoder.writeObject(agenda);
        encoder.close();
    }

    public static Agenda importFromXml() throws IOException
    {
        XMLDecoder decoder = new XMLDecoder(
            new BufferedInputStream(new FileInputStream("Agenda.xml")));

        Log.info("ERROR: File Agenda.xml not found");

        Agenda deserializedAgenda = (Agenda) decoder.readObject();

        return deserializedAgenda;
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
