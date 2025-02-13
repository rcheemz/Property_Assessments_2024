package main;

import logic.PropertyAssessments;

import java.util.Scanner;

public class Lab2Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get file from client

        System.out.print("Enter CSV file: ");
        String csvFileName = scanner.nextLine();

        try{
            PropertyAssessments propertyAssessments = new PropertyAssessments(csvFileName); // pass file name

            System.out.println("n = " + propertyAssessments.getSize());
            System.out.println("min = $" + String.format("%,.2f", propertyAssessments.getMinValue()));
            System.out.println("max = $" + String.format("%,.2f", propertyAssessments.getMaxValue()));
            System.out.println("mean = $" + String.format("%,.2f", propertyAssessments.getMeanAssessedValue()));
            System.out.println("range =$" + String.format("%,.2f", propertyAssessments.getMinValue()) + " - " + String.format("%,.2f", propertyAssessments.getMaxValue()));
            System.out.println("median = $" + String.format("%,.2f", propertyAssessments.getMedianAssessedValue()));
            System.out.println();
            // Get account number from client
            System.out.print("Find a property assessment by account number: ");
            String accountNumber = scanner.nextLine();
            String accountData = propertyAssessments.findByAccountNumber(accountNumber);
            System.out.print(accountData);
            System.out.println();
            System.out.print("Neighbourhood: ");
            String neighbourhood = scanner.nextLine();

            PropertyAssessments neighbourHoods = propertyAssessments.findByNeighbourhood(neighbourhood);

            //Property_Assessment_Data_2024.csv
            // Check if any neighbourhood was found
            if (neighbourHoods == null) {
                System.out.println("No neighbourhood found");
            }

            else {

                System.out.println("Statistics (neighbourhood =" + neighbourhood);
                //********** fix formating of string to return numbers properly**********
                System.out.println("n = " + neighbourHoods.getSize());
                System.out.println("min = " + neighbourHoods.getMinValue());
                System.out.println("max = " + neighbourHoods.getMaxValue());
                System.out.println("mean = " + neighbourHoods.getMeanAssessedValue());
                //***************get range function********************************88
                System.out.println("median = " + neighbourHoods.getMedianAssessedValue());
                System.out.println();
            }



        }
        catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
