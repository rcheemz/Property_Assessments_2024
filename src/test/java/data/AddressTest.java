package data;
import data.*;
import logic.PropertyAssessments;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


public class AddressTest {
    private Address address;

    @BeforeEach
    public void setUp() {
        address = new Address("123", "34", "Main St");
    }

    @Test
    public void testToString() {
        assertEquals("34 123 Main St", address.toString());
    }

    @Test
    public void testEquals() {
        Address address2 = new Address("123", "34", "Main St");
        Address address3 = new Address("123", "32", "Main St");
        assertEquals(address2, address); // Return True
        assertNotEquals(address3, address); // Return True
        assertEquals(address.hashCode(), address2.hashCode()); // Return True
    }

}

