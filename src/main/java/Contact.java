import java.io.Serializable;

/**
 * @author Iulian Aftene
 */

public class Contact
{
    private String name;
    private String surname;
    private String phoneNumber;
    private String emailAddress;

    public Contact()
    {
    }

    public Contact(String name, String surname, String phoneNumber, String emailAddress)
    {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void editContact()
    {

    }

    @Override
    public int hashCode()
    {
        int result = getName().hashCode();
        result = 31 * result + getSurname().hashCode();
        result = 31 * result + getPhoneNumber().hashCode();
        result = 31 * result + getEmailAddress().hashCode();
        return result;
    }

}
