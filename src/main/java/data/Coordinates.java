package data;

import java.util.Objects;

public class Coordinates {
    private String latitude;
    private String longitude;
    private String coordinates;

    // Constructor to initialize a coordinates object
    public Coordinates(String latitude, String longitude, String coordinates) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.coordinates = coordinates;
    }


    // Get & set methods
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


    // Converts coordinates object to string
    @Override
    public String toString() {
        return String.format("%s", coordinates);
    }

    // Compares two coordinates objects based off their properties
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return longitude.equals(that.longitude) &&
                latitude.equals(that.latitude);
    }

    // Generate a unique hash code for the coordinates object based off their equal properties
    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }

}
