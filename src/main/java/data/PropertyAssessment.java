package data;

import java.util.Objects;

public class PropertyAssessment implements Comparable<PropertyAssessment> {
    private String accountNumber;
    private Address address; // Address object
    private Neighbourhood neighbourhood; // NeighbourHood object
    private double assessedValue;
    private AssessmentClass assessmentClass; // AssessmentClass object

    // Default Constructor
    public PropertyAssessment() {
        this.accountNumber = "";
        this.address = new Address("", "", "");
        this.neighbourhood = new Neighbourhood("", "", "");
        this.assessedValue = 0.0;
        this.assessmentClass = new AssessmentClass(); // Initialize empty
    }

    // Constructor to initialize a property assessment object
    public PropertyAssessment(String accountNumber, Address address, Neighbourhood neighbourhood, String ward, double assessedValue, AssessmentClass assessmentClass) {
        this.accountNumber = accountNumber;
        this.address = address;
        this.neighbourhood = neighbourhood;
        this.assessedValue = assessedValue;
        this.assessmentClass = assessmentClass;
    }

    // Get & set methods
    public double getAssessedValue() {
        return assessedValue;
    }

    public void setAssessedValue(double assessedValue) {
        this.assessedValue = assessedValue;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Neighbourhood getNeighbourhood() {
        return neighbourhood;
    }
    public void setNeighbourhood(Neighbourhood neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public AssessmentClass getAssessmentClass() {
        return assessmentClass;
    }

    public void setAssessmentClass(AssessmentClass assessmentClass) {
        this.assessmentClass = assessmentClass;
    }

    // Convert property assessment object to string
    @Override // Override toString method
    public String toString() {

        // To make clean string make a newline variable that is a line separator
        String newline = System.lineSeparator();

        // The default toString will only display data in this format
        return String.format("Account = %s" + newline +
                        "Address = %s" + newline +
                        "Assessed Value = $%,.2f" + newline +
                        "Assessment Class = %s" + newline +
                        "Neighbourhood = %s" + newline,
                accountNumber, address, assessedValue, assessmentClass, neighbourhood);
    }

    // Override equals to use accountNumber
    @Override // Override equals method
    public boolean equals(Object obj) {
        // If the object is a PropertyAssessment
        if (obj instanceof PropertyAssessment) {
            // Return true if the account numbers are equal
            return this.accountNumber.equals(((PropertyAssessment) obj).accountNumber);
        }
        // else return false
        return false;
    }

    // Override hashCode based on equals
    @Override // Override hashcode
    public int hashCode() {
        // Override the hashcode so when using equals it stays consistent
        return Objects.hash(accountNumber);
    }

    // Compare two property assessment objects based on assessedValue
    @Override // Override compareTo
    public int compareTo(PropertyAssessment o) {
        // Compare the assessed value of the property assessment objects
        return Double.compare(this.assessedValue, o.assessedValue);
    }
}
