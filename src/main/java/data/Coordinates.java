package data;

import java.util.Objects;

public class Coordinates {
    private double latitude;
    private double longitude;
    private String coordinates;

    public Coordinates(double latitude, double longitude, String coordinates) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.coordinates = coordinates;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public String getCoordinates() {
        return coordinates;
    }
    @Override
    public String toString() {
        return String.format("%s", coordinates);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return coordinates.equals(that.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }


}
