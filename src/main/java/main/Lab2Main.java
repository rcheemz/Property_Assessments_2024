package main;

import com.opencsv.exceptions.CsvValidationException;
import data.PropertyAssessment;
import logic.PropertyAssessments;

import java.util.Scanner;

public class Lab2Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get file name from client
        System.out.print("Enter CSV file: ");
        String csvFileName = scanner.nextLine();

        try{

            // Pass the file name and create a new PropertyAssessment object
            PropertyAssessments propertyAssessments = new PropertyAssessments(csvFileName);

            // Get the number of assessments using getSize method
            System.out.println("n = " + String.format("%,d",propertyAssessments.getSize()));

            // Get the min/max/mean/range/median values of the assessments and print
            System.out.println("min = $" + String.format("%,.0f", propertyAssessments.getMinValue()));
            System.out.println("max = $" + String.format("%,.0f", propertyAssessments.getMaxValue()));
            System.out.println("mean = $" + String.format("%,.0f", propertyAssessments.getMeanAssessedValue()));

            // use max and min methods to get range. there is no range method in PropertyAssessment because it seems unnecessary
            double range = propertyAssessments.getMaxValue() - propertyAssessments.getMinValue();
            System.out.println("range =$" + String.format("%,.0f", range));
            System.out.println("median = $" + String.format("%,.0f", propertyAssessments.getMedianAssessedValue()));
            System.out.println();


            // Get account number from client
            System.out.print("Find a property assessment by account number: ");
            String accountNumber = scanner.nextLine();

            // If account number isn't empty
            if (!accountNumber.isEmpty()) {
                // Make a new property assessment object with target account number
                PropertyAssessment accountData = propertyAssessments.findByAccountNumber(accountNumber);
                // if a null object is returned
                if (accountData == null) {
                    System.out.println("Sorry, can't find property with account number " + accountNumber);
                }
                // if there is a property assessment object
                else {
                    System.out.print(accountData); // toString override has it formatted perfectly
                    // However if you want to print each thing separately just call the get functions for each property
                }
            } else {
                System.out.println("Sorry, can't find property with account number " + accountNumber);
            }

            System.out.println();


            // Get neighbourhood from client
            System.out.print("Neighbourhood: ");
            String neighbourhood = scanner.nextLine();

            // Create PropertyAssessments object with target neighbourhood name
            PropertyAssessments neighbourHoods = propertyAssessments.findByNeighbourhood(neighbourhood);

            // Check if any neighbourhood weren't found
            if (neighbourHoods == null) {
                System.out.println("Sorry, can't find data in " + neighbourhood);
            }

            else {

                System.out.println("Statistics (neighbourhood =" + neighbourhood);
                //********** fix formating of string to return numbers properly**********
                System.out.println("n = " + neighbourHoods.getSize());
                System.out.println("min = $" + String.format("%,.0f", neighbourHoods.getMinValue()));
                System.out.println("max = $" + String.format("%,.0f", neighbourHoods.getMaxValue()));
                System.out.println("mean = $" + String.format("%,.0f", neighbourHoods.getMeanAssessedValue()));
                double neighourhoodRange = neighbourHoods.getMaxValue() - neighbourHoods.getMinValue();
                System.out.println("range = $" + String.format("%,.0f", neighourhoodRange));
                System.out.println("median = $" + String.format("%,.0f",neighbourHoods.getMedianAssessedValue()));
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
