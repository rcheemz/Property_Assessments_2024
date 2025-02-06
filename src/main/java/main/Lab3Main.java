package main;

import logic.PropertyAssessments;

import java.util.Scanner;

public class Lab3Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get file from client

        System.out.print("Enter CSV file: ");
        String csvFileName = scanner.nextLine();

        try{
            PropertyAssessments propertyAssessments = new PropertyAssessments(csvFileName); // pass file name
            //propertyAssessments.loadFromCSV(csvFileName);

            System.out.println();
            // Get account number from client
            System.out.print("Please enter neighbourhood: ");
            String neighbourhood = scanner.nextLine();
            String neighbourhoodData = propertyAssessments.findByNeighbourhoodMain3(neighbourhood);
            System.out.print(neighbourhoodData);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

