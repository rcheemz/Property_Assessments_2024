package data;

import java.util.Objects;

public class Neighbourhood {
    private String neighbourhoodId;
    private String neighbourhoodName;
    private String ward;

    public Neighbourhood(String neighbourhoodId, String neighbourhoodName, String ward) {
        this.neighbourhoodId = neighbourhoodId;
        this.neighbourhoodName = neighbourhoodName;
        this.ward = ward;
    }
    public String getNeighbourhoodId() {
        return neighbourhoodId;
    }
    public String getNeighbourhoodName() {
        return neighbourhoodName;
    }
    public String getWard() {
        return ward;
    }
    @Override
    public String toString() {
        return String.format("%s", neighbourhoodName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbourhood neighbourhood = (Neighbourhood) o;
        return neighbourhoodId.equals(neighbourhood.neighbourhoodId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(neighbourhoodId);
    }
}
