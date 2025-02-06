package data;

import java.util.Objects;

public class PropertyAssessment implements Comparable<PropertyAssessment> {
    private String accountNumber;
    private Address address;
    private Neighbourhood neighbourhood;
    private double assessedValue;
    private String assessmentClass1;


    // Default
    public PropertyAssessment() {
        this.accountNumber = "";
        this.address = new Address("", "", "");
        this.neighbourhood = new Neighbourhood("","","");
        this.assessedValue = 0.0;
        this.assessmentClass1 = "";
    }

    public PropertyAssessment(String accountNumber, Address address, Neighbourhood neighbourhood, String ward, double assessedValue) {
        this.accountNumber = accountNumber;
        this.address = address;
        this.neighbourhood = neighbourhood;
        this.assessedValue = assessedValue;
    }


    // Get methods
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



    public String getAssessmentClass1() {
        return assessmentClass1;
    }

    // Convert object data to string
    @Override
    public String toString() {
        return String.format("Account: %s, data.Address: %s,%s, Assessed Value: $%,.2f, Class: %s",
                accountNumber, address, neighbourhood, assessedValue, assessmentClass1);
    }

    // Override equals to use accountNumber
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PropertyAssessment) {
            return this.accountNumber.equals(((PropertyAssessment) obj).accountNumber);
        }
        return false;
    }

    //Override hash based on equals to also have same hash code
    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    //Compare two property assessment objects based on assessedValue
    @Override
    public int compareTo(PropertyAssessment o) {
        return Double.compare(this.assessedValue, o.assessedValue);
        // if equal this is return 0, if higher return 1, if lower return -1
    }
}
