package main;

import data.PropertyAssessment;
import logic.PropertyAssessments;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Lab3Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get file from client

        System.out.print("Please enter the CSV filename: ");
        String csvFileName = scanner.nextLine();

        try{
            PropertyAssessments propertyAssessments = new PropertyAssessments(csvFileName); // pass file name

            System.out.println();
            // Get account number from client
            System.out.print("Please enter a neighbourhood name: ");
            String neighbourhood = scanner.nextLine();

            // Get PropertyAssessments Object using the find by neighbourhood method
            PropertyAssessments neighbourHoods = propertyAssessments.findByNeighbourhood(neighbourhood);

            // Check if any neighbourhood was found
            if (neighbourHoods == null) {
                System.out.println("Sorry, can't find data in" + neighbourhood);
            }

            else {
                // Use get.size, get mean, get median methods to get data for neighbourhood
                System.out.println("There are "+ String.format("%,d",neighbourHoods.getSize()) + " properties in " + neighbourhood);
                System.out.println("The mean value is CAD " + String.format("%,.0f", neighbourHoods.getMeanAssessedValue()));
                System.out.println("The median value is CAD " + String.format("%,.0f", neighbourHoods.getMedianAssessedValue()));
            }
            System.out.print("\nPlease enter an assessment class: ");
            String assessmentClass = scanner.nextLine();

            // Get PropertyAssessments Object using the find by assessment class method
            PropertyAssessments filteredByClass = propertyAssessments.findByAssessmentClass(assessmentClass);

            // if the size is 0
            if (filteredByClass.getSize() == 0) {
                System.out.println("No properties found for assessment class: " + assessmentClass);
            } else {

                // Print properties using get methods
                System.out.println("There are " + String.format("%,d",filteredByClass.getSize()) + " " + assessmentClass + " properties in Edmonton");
                System.out.println("The min value is CAD " + String.format("%,.0f",filteredByClass.getMinValue()));
                System.out.println("The max value is CAD " + String.format("%,.0f",filteredByClass.getMaxValue()));
            }

        }

        catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

}

