package data;
import data.*;
import logic.PropertyAssessments;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;


public class AssessmentClassTest {
    @Test
    public void testToString100Percent() {
        AssessmentClass ac = new AssessmentClass("100", "0", "0", "Residential", "", "");
        assertEquals("Residential", ac.toString());
    }

    @Test
    public void testToStringOtherPercents() {
        AssessmentClass ac = new AssessmentClass("90", "5", "4", "Residential", "Commercial", "Farm");
        assertEquals("90%, 5%, 4%, Residential, Commercial, Farm", ac.toString());
    }
    @Test
    public void testToStringTwoPercents() {
        AssessmentClass ac = new AssessmentClass("90", "10", "", "Residential", "Commercial", "");
        assertEquals("90%, 10%, %, Residential, Commercial, ", ac.toString());
    }

}
