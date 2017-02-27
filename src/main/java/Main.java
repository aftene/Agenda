import java.util.List;
import java.util.logging.Logger;
import com.sun.javafx.tools.packager.Log;


/**
 * @author Iulian Aftene
 */
public class Main
{
    public static void main(String [ ] args) throws Exception
    {
        Agenda agenda = Util.importFromXml();
        Logger logger = Logger.getLogger(Main.class.getName());

        while (true)
        {
            logger.info(
                "\nAgenda options : \n 1-Add contact \n 2-Search for contact \n 3-Delete contact \n 4-List all contacts \n 5-Exit");

            String userOption = Util.getUserInput();

            switch (userOption)
            {
            case "1":
            {
                logger.info("Enter contact details mother fucker");
                agenda.addContact(Util.createContact());
                break;
            }

            case "2":
            {
                logger.info("Enter any contact detail: ");
                List<Contact> contactsFound = agenda.searchContact(Util.getUserInput());

                if (contactsFound.size() == 0)
                {
                    logger.info("No contacts maching the search ware found");
                    break;
                }
                for (Contact contact : contactsFound)
                    logger.info(
                        "\nName: " + contact.getName() + "\nSurname: " + contact.getSurname()
                            + "\nemail: " + contact.getEmailAddress() + "\nPhone No.: "
                            + contact.getPhoneNumber() + "\n");
                break;
            }

            case "3":
            {
                logger.info("Enter contact to be deleted");
                agenda.deleteContact(Util.getUserInput());
                break;
            }

            case "4":
            {
                if (agenda.getContactList().size() != 0)
                {
                    Integer index = 0;
                    for (Contact contact : agenda.getContactList())
                    {
                        logger.info((++index).toString());
                        logger.info(
                            "Name: " + contact.getName() + "\nSurname: " + contact.getSurname()
                                + "\nemail: " + contact.getEmailAddress() + "\nPhone No.: "
                                + contact.getPhoneNumber());
                    }
                }
                else
                {
                    logger.info("Agenda is empty");
                }
                break;
            }

            case "5":
            {
                System.out.println(agenda.getContactList().size());
                System.exit(-1);
            }

            default:
            {
                logger.info("Chose one of the above options");
            }
            }

            Util.exportToXML(agenda);
        }
    }
}
