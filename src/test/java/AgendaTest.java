import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * Created by daniel on 3/7/17.
 */
public class AgendaTest
{
    private static final String TEST_STRING = "Name1";
    private Agenda agenda;

    @Before
    public void init()
    {
        agenda = new Agenda();
        IntStream.range(0, 10).forEach(
                intNumber -> {
                    String name = "Name" + intNumber;
                    String surname = "Surname" + intNumber;
                    String phoneNumber = "Phone" + intNumber;
                    String email = String.format("Email%s@mail.com",  intNumber);

                    agenda.addContact(new Contact(name, surname, phoneNumber, email));
                }
        );
    }

    @Test
    public void testDeleteContact() throws Exception
    {
        agenda.deleteContact(TEST_STRING);

        List<Contact> contactList = agenda.searchContact(TEST_STRING);

        assertEquals(contactList.size(), 0);
    }

    @Test
    public void testDeleteContactStream() throws Exception
    {
        agenda.deleteContactStream(TEST_STRING);

        List<Contact> contactList = agenda.searchContact(TEST_STRING);

        assertEquals(contactList.size(), 0);
    }
}