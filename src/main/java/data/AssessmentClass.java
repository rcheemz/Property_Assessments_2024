package data;

import java.util.Objects;

public class AssessmentClass {
    private String assessmentPrecent1;
    private String assessmentPrecent2;
    private String assessmentPrecent3;
    private String assessmentClass1;
    private String assessmentClass2;
    private String assessmentClass3;

    // Empty Constructor
    public AssessmentClass() {
        this.assessmentPrecent1 = "";
        this.assessmentPrecent2 = "";
        this.assessmentPrecent3 = "";
        this.assessmentClass1 = "";
        this.assessmentClass2 = "";
        this.assessmentClass3 = "";
    }

    // Constructor to initialize an assessment class object
    public AssessmentClass(String assessmentPrecent1, String assessmentPrecent2, String assessmentPrecent3,
                           String assessmentClass1, String assessmentClass2, String assessmentClass3) {
        this.assessmentPrecent1 = assessmentPrecent1;
        this.assessmentPrecent2 = assessmentPrecent2;
        this.assessmentPrecent3 = assessmentPrecent3;
        this.assessmentClass1 = assessmentClass1;
        this.assessmentClass2 = assessmentClass2;
        this.assessmentClass3 = assessmentClass3;
    }

    // Get & set methods
    public String getAssessmentPrecent1() {
        return assessmentPrecent1;
    }
    public String getAssessmentPrecent2() {
        return assessmentPrecent2;
    }
    public String getAssessmentPrecent3() {
        return assessmentPrecent3;
    }
    public void setAssessmentPrecent1(String assessmentPrecent1) {
        this.assessmentPrecent1 = assessmentPrecent1;
    }
    public void setAssessmentPrecent2(String assessmentPrecent2) {
        this.assessmentPrecent2 = assessmentPrecent2;
    }
    public void setAssessmentPrecent3(String assessmentPrecent3) {
        this.assessmentPrecent3 = assessmentPrecent3;
    }

    public String getAssessmentClass1() {
        return assessmentClass1;
    }
    public String getAssessmentClass2() {
        return assessmentClass2;
    }
    public String getAssessmentClass3() {
        return assessmentClass3;
    }
    public void setAssessmentClass1(String assessmentClass1) {
        this.assessmentClass1 = assessmentClass1;
    }
    public void setAssessmentClass2(String assessmentClass2) {
        this.assessmentClass2 = assessmentClass2;
    }

    public void setAssessmentClass3(String assessmentClass3) {
        this.assessmentClass3 = assessmentClass3;
    }

    // Converts assessment class object to string
    @Override
    public String toString() {
        if (assessmentPrecent1.equals("100")) {
            return String.format("%s",assessmentClass1);
        }
        else {
            return String.format("%s%%, %s%%, %s%%, %s, %s, %s",assessmentPrecent1,assessmentPrecent2,assessmentPrecent3,assessmentClass1,assessmentClass2,assessmentClass3);
        }
    }

    // Compares two assessment class objects based off their properties
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssessmentClass that = (AssessmentClass) o;
        return assessmentPrecent1.equals(that.assessmentPrecent1) &&
                assessmentPrecent2.equals(that.assessmentPrecent2) &&
                assessmentPrecent3.equals(that.assessmentPrecent3) &&
                assessmentClass1.equals(that.assessmentClass1) &&
                assessmentClass2.equals(that.assessmentClass2)&&
                assessmentClass3.equals(that.assessmentClass3);

    }

    // Generate a unique hash code for the assessment object based on equal properties
    @Override
    public int hashCode() {
        return Objects.hash(assessmentPrecent1,assessmentPrecent2,assessmentPrecent3,assessmentClass1,assessmentClass2,assessmentClass3);
    }

}
