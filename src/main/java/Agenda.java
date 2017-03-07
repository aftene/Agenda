import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Iulian Aftene
 */

public class Agenda
{
    // Nu se mai foloseste ArrayList<Contact> din java 7, citeste diamond operator
    private List<Contact> contactList = new ArrayList<>();

    public Agenda()
    {
    }

    public Agenda(List contactList)
    {
        this.contactList = contactList;
    }

    public List<Contact> getContactList()
    {
        return contactList;
    }

    public void setContactList(List<Contact> contactList)
    {
        this.contactList = contactList;
    }

    public void addContact(Contact contact)
    {
        contactList.add(contact);
    }

    // Aici ai facut in sfarsit varianta corecta; nu poti opera la nivel de index sau iterator daca modifici dimensiunea listei
    public void deleteContact(String userInput)
    {
        List<Contact> temporaryContactList = new ArrayList<>();

        for (Contact contorContact : contactList)
        {
            if (contorContact.getName().equals(userInput) || contorContact.getSurname()
                .equals(userInput) || contorContact.getEmailAddress().equals(userInput)
                || contorContact.getPhoneNumber().equals(userInput))
            {
                temporaryContactList.add(contorContact);
            }
        }

        for (Contact contorContact : temporaryContactList)
        {
            contactList.remove(contorContact);
        }
    }

    // Asta e metoda cu stream-uri
    public void deleteContactStream(String userInput)
    {
        contactList = contactList.stream()
                .filter(contact -> !contact.isContactFromInput(userInput))
                .collect(Collectors.toList());
    }

    public List<Contact> searchContact(String userInput)
    {
        List<Contact> foundContactsList = new ArrayList<Contact>();
        for (Contact contact : contactList)
        {
            if (contact.getName().equals(userInput) || contact.getSurname().equals(userInput)
                || contact.getEmailAddress().equals(userInput) || contact.getPhoneNumber()
                .equals(userInput))
            {
                foundContactsList.add(contact);
            }
        }
        return foundContactsList;
    }

}
