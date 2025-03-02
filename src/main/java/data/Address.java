package data;

import java.util.Objects;

public class Address {
    private String houseNumber;
    private String suite;
    private String street;

    // Constructor to initialize an address object
    public Address(String houseNumber, String suite, String street) {
        this.houseNumber = houseNumber;
        this.suite = suite;
        this.street = street;
    }


    // Get & set methods
    public String getHouseNumber() {
        return houseNumber;
    }
    public String getSuite() {
        return suite;
    }
    public String getStreet() {
        return street;
    }

    // Converts address object to string
    @Override
    public String toString() {
        return String.format("%s %s %s", suite, houseNumber, street);
    }

    // Compares two address objects based off their properties
    @Override // Override equals method
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber.equals(address.houseNumber) &&
                street.equals(address.street) &&
                suite.equals(address.suite);
    }

    // Generate a unique hash code for the address object based on equal properties
    @Override // Override randomly generated hash code
    public int hashCode() {
        return Objects.hash(houseNumber, street, suite);
    }
}
