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

}
