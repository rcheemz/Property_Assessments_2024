package main;

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

            PropertyAssessments neighbourHoods = propertyAssessments.findByNeighbourhood(neighbourhood);
            // Check if any neighbourhood was found
            if (neighbourHoods == null) {
                System.out.println("No neighbourhood found");
            }

            else {
                System.out.println("There are "+ neighbourHoods.getSize() + "properties in " + neighbourhood);
                System.out.println("The mean value is CAD " + neighbourHoods.getMeanAssessedValue());
                System.out.println("The median value is CAD " + neighbourHoods.getMedianAssessedValue());
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

