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
import java.util.List;
import java.util.Scanner;

/**
 * @author Iulian Aftene
 */
public class Util
{

public static void exportToXML(Agenda agenda)
{
    XMLEncoder encoder=null;
    try{
        encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Agenda.xml")));
    }catch(FileNotFoundException fileNotFound){
        System.out.println("ERROR: While Creating or Opening the File Agenda.xml");
    }
    encoder.writeObject(agenda);
    encoder.close();
}

public static Agenda importFromXml()
{
    XMLDecoder decoder=null;

    try {
        decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream("Agenda.xml")));
    } catch (FileNotFoundException e) {
        System.out.println("ERROR: File Agenda.xml not found");
    }

    Agenda deserializedAgenda = (Agenda) decoder.readObject();

    return deserializedAgenda;
}

public static String getUserInput()
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try
    {
        String s;
        s = br.readLine();
        return s;
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }

    return null;
}

}
