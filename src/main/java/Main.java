/**
 * @author Iulian Aftene
 */
public class Main
{
    public static void main(String [ ] args)
    {

        Agenda agenda = Util.importFromXml();

        while (true)
        {
            System.out.println("Agenda options : \n 1-Add contact \n 2-Delete contact \n 3-Edit contact \n 4-None");
            String userOption = Util.getUserInput();
            switch (userOption)
            {
            case "1":
            {
                System.out.println("Enter contact details mother fucker");
                agenda.createContact();
                break;
            }
            case "2":
            {
                System.out.println("Enter contact to be deleted");
                String userInput = Util.getUserInput();
                agenda.deleteContact(userInput);
                break;
            }
            case "4":
            {
                System.out.println(agenda.getContactList().size());
                System.exit(-1);
            }
            }
            Util.exportToXML(agenda);
        }
    }
}
