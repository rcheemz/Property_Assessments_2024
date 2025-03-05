package logic;

import data.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

class PropertyAssessmentsTest {

    private PropertyAssessments propertyAssessments;

    @BeforeEach
    void setUp() {
        // Set up sample data
        Address address1 = new Address("101", "1", "Main St");
        Neighbourhood neighbourhood1 = new Neighbourhood("1001", "Downtown", "1");
        AssessmentClass assessmentClass1 = new AssessmentClass("100", "0", "0", "Residential", "None", "None");

        Address address2 = new Address("202", "2", "2nd Ave");
        Neighbourhood neighbourhood2 = new Neighbourhood("1002", "Oliver", "2");
        AssessmentClass assessmentClass2 = new AssessmentClass("50", "50", "0", "Commercial", "Residential", "None");

        Address address3 = new Address("202", "3", "3 Ave");
        Neighbourhood neighbourhood3 = new Neighbourhood("1003", "University", "3");
        AssessmentClass assessmentClass3 = new AssessmentClass("40", "60", "0", "Commercial", "Farmland", "None");

        PropertyAssessment property1 = new PropertyAssessment("12345", address1, neighbourhood1, 500000, assessmentClass1);
        PropertyAssessment property2 = new PropertyAssessment("67890", address2, neighbourhood2, 300000, assessmentClass2);
        PropertyAssessment property3 = new PropertyAssessment("909090", address3, neighbourhood1, 400000, assessmentClass1);
        PropertyAssessment property4 = new PropertyAssessment("060606", address3, neighbourhood3, 400000, assessmentClass3);
        List<PropertyAssessment> properties = Arrays.asList(property1, property2, property3, property4);
        propertyAssessments = new PropertyAssessments(properties);
    }

    @Test
    void testGetSize() {
        assertEquals(4, propertyAssessments.getSize());
        assertNotEquals(0, propertyAssessments.getSize());
    }

    @Test
    void testFindByAccountNumber_Found() {
        PropertyAssessment found1 = propertyAssessments.findByAccountNumber("12345");
        assertNotNull(found1);
        assertEquals("12345", found1.getAccountNumber());
        PropertyAssessment found2 = propertyAssessments.findByAccountNumber("67890");
        assertNotNull(found2);
        assertEquals("67890", found2.getAccountNumber());
        PropertyAssessment found3 = propertyAssessments.findByAccountNumber("909090");
        assertNotNull(found3);
        assertEquals("909090", found3.getAccountNumber());
    }

    @Test
    void testFindByAccountNumber_NotFound() {
        PropertyAssessment found = propertyAssessments.findByAccountNumber("99999"); // no property with this account number
        assertNull(found);
    }

    @Test
    void testFindByNeighbourhood_Found() {
        PropertyAssessments found = propertyAssessments.findByNeighbourhood("Downtown");
        assertNotNull(found);
        assertEquals(2, found.getSize()); // There are 2 properties in downtown
        PropertyAssessments found2 = propertyAssessments.findByNeighbourhood("Oliver");
        assertNotNull(found2);
        assertEquals(1, found2.getSize()); // There is 1 property in oliver
        PropertyAssessments found3 = propertyAssessments.findByNeighbourhood("University");
        assertNotNull(found3);
        assertEquals(1, found3.getSize()); // There is 1 property in University
    }

    @Test
    void testFindByNeighbourhood_NotFound() {
        PropertyAssessments found = propertyAssessments.findByNeighbourhood("None");
        assertNull(found);
    }

    @Test
    void testFindByAssessmentClass_Found() {
        PropertyAssessments found = propertyAssessments.findByAssessmentClass("Residential");
        assertNotNull(found);
        assertEquals(3, found.getSize()); // 3 properties have Residential as part of assessment
        PropertyAssessments found2 = propertyAssessments.findByAssessmentClass("Commercial");
        assertNotNull(found2);
        assertEquals(2, found2.getSize());
        PropertyAssessments found3 = propertyAssessments.findByAssessmentClass("Farmland");
        assertNotNull(found3);
        assertEquals(1, found3.getSize());
    }

    @Test
    void testFindByAssessmentClass_NotFound() {
        PropertyAssessments found = propertyAssessments.findByAssessmentClass("Industrial");
        assertNotNull(found);
        assertEquals(0, found.getSize());
    }

    @Test
    void testGetMinValue() {
        assertEquals(300000, propertyAssessments.getMinValue());
    }

    @Test
    void testGetMaxValue() {
        assertEquals(500000, propertyAssessments.getMaxValue());
    }

    @Test
    void testGetMeanAssessedValue() {
        assertEquals(400000, propertyAssessments.getMeanAssessedValue());
    }

    @Test
    void testGetMedianAssessedValue() {
        assertEquals(400000, propertyAssessments.getMedianAssessedValue());
    }
}
