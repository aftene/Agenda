import java.io.Serializable;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class Contact implements Serializable
{
    private String name;
    private String surname;
    private String phoneNumber;
    private String emailAddress;


    public Contact(){ }
    public Contact(String name, String surname, String phoneNumber, String emailAddress)
    {
        this.name=name;
        this.surname=surname;
        this.phoneNumber=phoneNumber;
        this.emailAddress =emailAddress;
    }

    public String getName()    {  return name;  }
    public String getSurname()    {  return surname;    }
    public String getPhoneNumber()    {  return phoneNumber;  }
    public String getEmailAddress()   {   return emailAddress;   }

    public void setName(String name)  {  this.name = name; }
    public void setSurname(String surname)    {   this.surname = surname;  }
    public void setPhoneNumber(String phoneNumber)  {   this.phoneNumber = phoneNumber;   }
    public void setEmailAddress(String emailAddress)   {   this.emailAddress = emailAddress;  }

    public void editContact()
    {

    }

    @Override
    public int hashCode()
    {
        int hash=1;
        hash = hash + 10 + name.hashCode();
        hash = hash + 15 + surname.hashCode();
        hash = hash + 20 + phoneNumber.hashCode();
        hash = hash + 10 + (emailAddress.endsWith(".com") ? 10 : emailAddress.hashCode());

        return hash;
    }

}
