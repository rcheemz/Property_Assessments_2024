package data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class NeighbourhoodTest {
    private Neighbourhood neighbourhood;

    @BeforeEach
    void setUp() {
        neighbourhood = new Neighbourhood("12345", "Downtown", "4");
    }

    @Test
    public void testToString() {
        assertEquals("Downtown", neighbourhood.toString());
    }

    @Test
    public void testGetMethods() {
        assertEquals("4", neighbourhood.getWard());
        assertEquals("12345", neighbourhood.getNeighbourhoodId());
        assertEquals("Downtown", neighbourhood.getNeighbourhoodName());
    }

    @Test
    public void testSetMethods() {
        neighbourhood.setWard("4");
        assertEquals("4", neighbourhood.getWard());
        neighbourhood.setNeighbourhoodId("123");
        assertEquals("123", neighbourhood.getNeighbourhoodId());
        neighbourhood.setNeighbourhoodName("Down");
        assertEquals("Down", neighbourhood.getNeighbourhoodName());
    }

}
