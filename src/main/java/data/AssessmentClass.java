package data;

import java.util.Objects;

public class AssessmentClass {
    private String assessmentPrecent1;
    private String assessmentPrecent2;
    private String assessmentPrecent3;
    private String assessmentClass1;
    private String assessmentClass2;
    private String assessmentClass3;

    public AssessmentClass() {
        this.assessmentPrecent1 = "";
        this.assessmentPrecent2 = "";
        this.assessmentPrecent3 = "";
        this.assessmentClass1 = "";
        this.assessmentClass2 = "";
        this.assessmentClass3 = "";
    }
    public AssessmentClass(String assessmentPrecent1, String assessmentPrecent2, String assessmentPrecent3,
                           String assessmentClass1, String assessmentClass2, String assessmentClass3) {
        this.assessmentPrecent1 = assessmentPrecent1;
        this.assessmentPrecent2 = assessmentPrecent2;
        this.assessmentPrecent3 = assessmentPrecent3;
        this.assessmentClass1 = assessmentClass1;
        this.assessmentClass2 = assessmentClass2;
        this.assessmentClass3 = assessmentClass3;
    }


    public String getAssessmentPrecent1() {
        return assessmentPrecent1;
    }

    public String getAssessmentPrecent2() {
        return assessmentPrecent2;
    }
    public String getAssessmentPrecent3() {
        return assessmentPrecent3;
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

    @Override
    public String toString() {
        if (assessmentPrecent1.equals("100")) {
            return String.format("%s",assessmentClass1);
        }
        else {
            return String.format("%s,%s,%s,%s,%s,%s",assessmentPrecent1,assessmentPrecent2,assessmentPrecent3,assessmentClass1,assessmentClass2,assessmentClass3);
        }
    }

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
    @Override
    public int hashCode() {
        return Objects.hash(assessmentPrecent1,assessmentPrecent2,assessmentPrecent3,assessmentClass1,assessmentClass2,assessmentClass3);
    }

}
