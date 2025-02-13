package data;

import java.util.Objects;

public class PropertyAssessment implements Comparable<PropertyAssessment> {
    private String accountNumber;
    private Address address;
    private Neighbourhood neighbourhood;
    private double assessedValue;
    private AssessmentClass assessmentClass; // Updated to use AssessmentClass object

    // Default Constructor
    public PropertyAssessment() {
        this.accountNumber = "";
        this.address = new Address("", "", "");
        this.neighbourhood = new Neighbourhood("", "", "");
        this.assessedValue = 0.0;
        this.assessmentClass = new AssessmentClass(); // Initialize empty
    }

    public PropertyAssessment(String accountNumber, Address address, Neighbourhood neighbourhood, String ward, double assessedValue, AssessmentClass assessmentClass) {
        this.accountNumber = accountNumber;
        this.address = address;
        this.neighbourhood = neighbourhood;
        this.assessedValue = assessedValue;
        this.assessmentClass = assessmentClass;
    }

    // Getters
    public double getAssessedValue() {
        return assessedValue;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Address getAddress() {
        return address;
    }

    public Neighbourhood getNeighbourhood() {
        return neighbourhood;
    }

    public AssessmentClass getAssessmentClass() {
        return assessmentClass;
    }

    // Convert object data to string
    @Override
    public String toString() {
        String newline = System.lineSeparator();
        return String.format("Account = %s" + newline +
                        "Address = %s" + newline +
                        "Assessed Value = $%,.2f" + newline +
                        "Assessment Class = %s" + newline +
                        "Neighbourhood = %s" + newline,
                accountNumber, address, assessedValue, assessmentClass, neighbourhood);
    }

    // Override equals to use accountNumber
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PropertyAssessment) {
            return this.accountNumber.equals(((PropertyAssessment) obj).accountNumber);
        }
        return false;
    }

    // Override hashCode based on equals
    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    // Compare two property assessment objects based on assessedValue
    @Override
    public int compareTo(PropertyAssessment o) {
        return Double.compare(this.assessedValue, o.assessedValue);
    }
}
