package data;

import java.util.Objects;

public class Address {
    private String houseNumber;
    private String suite;
    private String street;

    public Address(String houseNumber, String suite, String street) {
        this.houseNumber = houseNumber;
        this.suite = suite;
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }
    public String getSuite() {
        return suite;
    }
    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", suite, houseNumber, street);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber.equals(address.houseNumber) &&
                street.equals(address.street) &&
                suite.equals(address.suite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseNumber, street, suite);
    }
}
