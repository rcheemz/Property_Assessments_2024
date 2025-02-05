import java.util.Objects;

public class PropertyAssessment implements Comparable<PropertyAssessment> {
    private String accountNumber;
    private String houseNumber;
    private String street;
    private String neighbourhood;
    private String ward;
    private double assessedValue;
    private String assessmentClass1;


    // Default
    public PropertyAssessment() {
        this.accountNumber = "";
        this.houseNumber = "";
        this.street = "";
        this.neighbourhood = "";
        this.ward = "";
        this.assessedValue = 0.0;
        this.assessmentClass1 = "";
    }

    public PropertyAssessment(String accountNumber, String houseNumber, String street, String neighbourhood, String ward, double assessedValue) {
        this.accountNumber = accountNumber;
        this.houseNumber = houseNumber;
        this.street = street;
        this.neighbourhood = neighbourhood;
        this.ward = ward;
        this.assessedValue = assessedValue;
    }


    // Get methods
    public double getAssessedValue() {
        return assessedValue;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    public String getHouseNumber() {
        return houseNumber;
    }

    public String getStreet() {
        return street;
    }




    public String getNeighbourhood() {
        return neighbourhood;
    }

    public String getWard() {
        return ward;
    }


    public String getAssessmentClass1() {
        return assessmentClass1;
    }

    // Convert object data to string
    @Override
    public String toString() {
        return String.format("Account: %s, Address: %s %s, %s (Ward %s), Assessed Value: $%,.2f, Class: %s",
                accountNumber, houseNumber, street, neighbourhood, ward, assessedValue, assessmentClass1);
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
