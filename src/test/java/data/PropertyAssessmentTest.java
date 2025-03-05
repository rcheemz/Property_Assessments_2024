package data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PropertyAssessmentTest {

    @Test
    void testConstructorAndGetters() {
        Address address = new Address("123", "Apt 4", "Main St");
        Address address2 = new Address("456", "Apt 5", "Main St");
        Neighbourhood neighbourhood = new Neighbourhood("123", "Downtown", "4");
        Neighbourhood neighbourhood1 = new Neighbourhood("456", "Downtown", "5");
        AssessmentClass assessmentClass = new AssessmentClass("50", "40", "10", "Residential", "Commercial", "Farm");
        AssessmentClass assessmentClass1 = new AssessmentClass("50", "40", "20", "Residential", "Commercial", "Farm");
        PropertyAssessment propertyAssessment = new PropertyAssessment("1001", address, neighbourhood, 250000, assessmentClass);

        // Check equals and not equals for each property
        assertEquals("1001", propertyAssessment.getAccountNumber());
        assertNotEquals("1002", propertyAssessment.getAccountNumber());
        assertEquals(address, propertyAssessment.getAddress());
        assertNotEquals(address2, propertyAssessment.getAddress());
        assertEquals(neighbourhood, propertyAssessment.getNeighbourhood());
        assertNotEquals(neighbourhood1, propertyAssessment.getNeighbourhood());
        assertEquals(250000, propertyAssessment.getAssessedValue());
        assertNotEquals(3000, propertyAssessment.getAssessedValue());
        assertEquals(assessmentClass, propertyAssessment.getAssessmentClass());
        assertNotEquals(assessmentClass1, propertyAssessment.getAssessmentClass());
    }

    @Test
    void testToString() {

        Address address = new Address("123", "Apt 4", "Main St");
        Address address2 = new Address("456", "Apt 5", "Main St");
        Neighbourhood neighbourhood = new Neighbourhood("123", "Downtown", "1");
        AssessmentClass assessmentClass = new AssessmentClass("100", "0", "0", "Residential", "None", "None");

        PropertyAssessment propertyAssessment = new PropertyAssessment("1001", address, neighbourhood, 250000, assessmentClass);

        assertTrue(propertyAssessment.toString().contains("Account = 1001"));
        assertTrue(propertyAssessment.toString().contains("Assessment Class = " + assessmentClass));
        assertTrue(propertyAssessment.toString().contains("Neighbourhood = " + neighbourhood));
        assertFalse(propertyAssessment.toString().contains("Address = " + address2));
        assertTrue(propertyAssessment.toString().contains("Address = " + address));

    }

    @Test
    void testEqualsAndHashCode() {
        Address address = new Address("123", "4", "Main St");
        Neighbourhood neighbourhood = new Neighbourhood("123", "Downtown", "1");
        AssessmentClass assessmentClass = new AssessmentClass("100", "0", "0", "Residential", "None", "None");

        PropertyAssessment p1 = new PropertyAssessment("1001", address, neighbourhood, 250000, assessmentClass);
        PropertyAssessment p2 = new PropertyAssessment("1001", address, neighbourhood, 250000, assessmentClass);
        PropertyAssessment p3 = new PropertyAssessment("2002", address, neighbourhood, 300000, assessmentClass);

        assertEquals(p1, p2);
        assertNotEquals(p1, p3);
        assertEquals(p1.hashCode(), p2.hashCode());
        assertNotEquals(p1.hashCode(), p3.hashCode());
    }

    @Test
    void testCompareTo() {
        Address address = new Address("123", "4", "Main St");
        Neighbourhood neighbourhood = new Neighbourhood("123", "Downtown", "1");
        AssessmentClass assessmentClass = new AssessmentClass("100", "0", "0", "Residential", "None", "None");

        PropertyAssessment p1 = new PropertyAssessment("1001", address, neighbourhood, 250000, assessmentClass);
        PropertyAssessment p2 = new PropertyAssessment("1001", address, neighbourhood, 250000, assessmentClass);
        PropertyAssessment p3 = new PropertyAssessment("2002", address, neighbourhood, 300000, assessmentClass);
        PropertyAssessment p4 = new PropertyAssessment("2003", address, neighbourhood, 100000, assessmentClass);

        assertEquals(0,p1.compareTo(p2));
        assertEquals(-1,p1.compareTo(p3));
        assertEquals(1,p1.compareTo(p4));

    }
}

