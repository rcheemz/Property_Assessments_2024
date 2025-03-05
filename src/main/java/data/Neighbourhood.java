package data;

import java.util.Objects;

public class Neighbourhood {
    private String neighbourhoodId;
    private String neighbourhoodName;
    private String ward;

    // Constructor to initialize a neighbourhood object
    public Neighbourhood(String neighbourhoodId, String neighbourhoodName, String ward) {
        this.neighbourhoodId = neighbourhoodId;
        this.neighbourhoodName = neighbourhoodName;
        this.ward = ward;
    }

    //Get & set methods
    public String getNeighbourhoodId() {
        return neighbourhoodId;
    }
    public void setNeighbourhoodId(String neighbourhoodId) {
        this.neighbourhoodId = neighbourhoodId;
    }

    public String getNeighbourhoodName() {
        return neighbourhoodName;
    }
    public void setNeighbourhoodName(String neighbourhoodName) {
        this.neighbourhoodName = neighbourhoodName;
    }

    public String getWard() {
        return ward;
    }
    public void setWard(String ward) {
        this.ward = ward;
    }

    // Converts neighbourhood object to string
    @Override
    public String toString() {
        return String.format("%s", neighbourhoodName);
    }

    // Compares two neighbourhood objects based off their properties
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbourhood neighbourhood = (Neighbourhood) o;
        return neighbourhoodId.equals(neighbourhood.neighbourhoodId);
    }

    // Generate a unique hash code for neighbourhood object based on ID
    @Override
    public int hashCode() {
        return Objects.hash(neighbourhoodId);
    }

}
