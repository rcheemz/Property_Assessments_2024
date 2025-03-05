package main;

import logic.PropertyAssessments;
import java.util.Scanner;

public class Infograph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String csvFileName = "Property_Assessment_Data_2024.csv";

        try {
            PropertyAssessments propertyAssessments = new PropertyAssessments(csvFileName);

            checkAssessmentClass(propertyAssessments, "Residential");
            checkAssessmentClass(propertyAssessments, "Commercial");
            checkAssessmentClass(propertyAssessments, "Farmland");
            checkAssessmentClass(propertyAssessments, "Other Residential");
            checkAssessmentClass(propertyAssessments, "MA Derelict Residential");
            checkAssessmentClass(propertyAssessments, "Nonres Municipal/Res Education");

            System.out.println();
            checkNeighbourhood(propertyAssessments, "Windermere");
            System.out.println();
            checkNeighbourhood(propertyAssessments, "Heritage Valley Town Centre");
            System.out.println();
            checkNeighbourhood(propertyAssessments, "Walker");
            System.out.println();
            checkNeighbourhood(propertyAssessments, "Webber Greens");
            System.out.println();

            System.out.println();


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void checkAssessmentClass(PropertyAssessments assessments, String className) {
        PropertyAssessments result = assessments.findByAssessmentClass(className);
        if (result.getSize() == 0) {
            System.out.println("No properties found for assessment class: " + className);
        } else {
            System.out.println("Found " + result.getSize() + " properties in " + className);
            System.out.println("Max: " + String.format("%,.0f",result.getMaxValue()));
            System.out.println("Mean: " + String.format("%,.0f",result.getMeanAssessedValue()));
        }
    }

    private static void checkNeighbourhood(PropertyAssessments assessments, String neighbourhoodName) {
        PropertyAssessments result = assessments.findByNeighbourhood(neighbourhoodName);
        if (result == null) {
            System.out.println("Sorry, can't find data in " + neighbourhoodName);
        } else {
            PropertyAssessments resOnly = result.findByAssessmentClass("Residential");
            System.out.println("There are " + String.format("%,d", resOnly.getSize()) + " properties in " + neighbourhoodName);
            System.out.println("The mean value is CAD " + String.format("%,.0f", resOnly.getMeanAssessedValue()));
            System.out.println("The median value is CAD " + String.format("%,.0f", resOnly.getMedianAssessedValue()));

        }

    }
}
