import java.util.ArrayList;
import java.util.List;

/**
 * @author Iulian Aftene
 */
public class Agenda
{
    private List<Contact> contactList = new ArrayList<Contact>();

    public Agenda(){}
    public Agenda(List contactList)
    {
        this.contactList = contactList;
    }

    public List<Contact> getContactList()    { return contactList; }
    public void setContactList(List<Contact> contactList)  {  this.contactList = contactList;  }


    public void addContact(Contact contact)
    {
        contactList.add(contact);
    }

    public void deleteContact(String userInput)
    {
        for (Contact contact : contactList)
        {
            if (contact.getName().equals(userInput) || contact.getSurname().equals(userInput) || contact.getEmailAddress().equals(userInput) || contact.getPhoneNumber().equals(userInput))
            {
                contactList.remove(contact);
            }
        }
    }

    public void editContact()
    {

    }

    public  void createContact()
    {
        System.out.println("name: ");
        String name = Util.getUserInput();

        System.out.println("surname: ");
        String surname = Util.getUserInput();

        System.out.println("phoneNumber: ");
        String phoneNumber = Util.getUserInput();

        System.out.println("emailAddress: ");
        String emailAddress = Util.getUserInput();

        addContact(new Contact(name, surname, phoneNumber, emailAddress));
    }
}
