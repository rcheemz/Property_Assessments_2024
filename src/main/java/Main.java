import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get file from client

        System.out.print("Enter CSV file: ");
        String csvFileName = scanner.nextLine();

        try{
            PropertyAssessments propertyAssessments = new PropertyAssessments(csvFileName); // pass file name
            //propertyAssessments.loadFromCSV(csvFileName); // Kept away from the client

            System.out.println("n = " + propertyAssessments.getAllRecords());
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

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
