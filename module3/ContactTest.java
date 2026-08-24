import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;


public class ContactTest {

    private Contact c;

    @BeforeEach
    void setupTests() {

        c = new Contact("Ada Lovelace", "+1 617 555 0101");

    }


    @Test
    void constructor_setsNameCorrectly() {


        assertEquals("Ada Lovelace", c.getName());


    }

    @Test
    void constructor_setsPhoneCorrectly() {


        assertEquals("+1 617 555 0101", c.getPhone());

    }

    @Test
    void getName_containsExactString_notTransformed() {


        assertEquals("Ada Lovelace", c.getName());
    }

    @Test
    void toString_containsName() {


        assertTrue(c.toString().contains("Ada Lovelace"));

    }

    @Test
    void toString_containsPhone() {

        assertTrue(c.toString().contains("+1 617 555 0101"));
    }


    @Test
    void Contact_testObjectIndependence() {

        // @BeforeEach already generates contact c with name "Ada Lovelace"

        Contact c2 = new Contact("Ada Lovelace", "+1 617 555 0101");

        // change name for the second contact so it no longer matches the first
        c2.setName("Grace Hopper");

        assertEquals("Grace Hopper", c2.getName());
        assertEquals("Ada Lovelace", c.getName());




    }


}
