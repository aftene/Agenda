import java.util.ArrayList;
import java.util.Iterator;
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
        synchronized(contactList)
        {
            for (int i=0; i<contactList.size();i++)

            {
                if (contactList.get(i).getName().equals(userInput) || contactList.get(i).getSurname().equals(userInput) || contactList.get(i).getEmailAddress().equals(userInput) || contactList.get(i).getPhoneNumber()
                    .equals(userInput))
                {
                    contactList.remove(contactList.get(i));
                }
            }
        }
    }

    public List<Contact> searchContact(String userInput)
    {
        List<Contact> foundContactsList = new ArrayList<Contact>();
        for (Contact contact : contactList)
        {
            if (contact.getName().equals(userInput) || contact.getSurname().equals(userInput) || contact.getEmailAddress().equals(userInput) || contact.getPhoneNumber().equals(userInput))
            {
                foundContactsList.add(contact);
            }
        }
        return foundContactsList;
    }


}
