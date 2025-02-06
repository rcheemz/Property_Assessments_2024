package logic;

import com.opencsv.exceptions.CsvValidationException;
import data.Address;
import data.Neighbourhood;
import data.PropertyAssessment;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PropertyAssessments {
    private List<PropertyAssessment> assessments;
    private String filePath;

    // takes list of properties
    public PropertyAssessments(List<PropertyAssessment> assessments){
        this.assessments = assessments;
    }


    // Initialize assessments list to store data.PropertyAssessment objects
    public PropertyAssessments(String csvFileName) throws CsvValidationException {

        this.assessments = new ArrayList<>();
        this.filePath =  "data/"+ csvFileName;
        try {
            loadFromCSV(filePath);
        } catch (IOException e) {
            throw new CsvValidationException("Error reading CSV file: " + csvFileName);
        }
    }

    /**
     * Read the contents of a CSV file and store the data as data.PropertyAssessment objects.
     * @param csvFileName - the CSV file name
     * @throws IOException - input/output error
     */
    public void loadFromCSV(String csvFileName) throws IOException {
        String[][] data = readData(csvFileName);
        for (String[] row : data) {
            if (row.length >= 8) { // Ensure we have enough columns to prevent index errors
                String accountNumber = row[0];
                String suite = row[1];
                String houseNumber = row[2];
                String street = row[3];
                String neighbourhoodId = row[5];
                String neighbourhoodName = row[6];
                String ward = row[7];
                String assessedValue = row[8];
                double parsedValue = Double.parseDouble(assessedValue);
                Address address = new Address(houseNumber,suite,street);
                Neighbourhood neighbourhood = new Neighbourhood(neighbourhoodId,neighbourhoodName,ward);
                assessments.add(new PropertyAssessment(
                        accountNumber,
                        address,
                        neighbourhood,
                        ward,
                        parsedValue));
            }
        }
    }

    /**
     * Read the contents of a CSV file and return data as a 2D array of String.
     * @param csvFileName - the CSV file name
     * @return data - the values in the CSV file
     * @throws IOException - input/output error
     */
    public static String[][] readData(String csvFileName) throws IOException {

        // Create a stream to read the CSV file
        String[][] data;
        int index = 0;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(csvFileName))) {
            // Skip the header - this assumes the first line is a header
            reader.readLine();

            // Create 2D array to store all rows of data as String
            int initialSize = 50000; // Made bigger so resizing doesn't happen too many times cause time/memory overhead
            data = new String[initialSize][];

            // Read the file line by line and store all rows into a 2D array
            String line;
            while ((line = reader.readLine()) != null) {
                // Split a line by comma works for simple CSV files
                String[] values = line.split(",");

                // Check if the array is full
                if (index == data.length)
                    // Array is full, create and copy all values to a larger array
                    data = Arrays.copyOf(data, data.length * 2);

                data[index++] = values;
            }
        }

        return Arrays.copyOf(data, index);
    }


    /**
     * Get total number of rows in the assessments list
     * @return the lowest assessed value among all property assessments
     */
    public int getAllRecords(){

        return assessments.size();
    }

    /**
     * Find the lowest value in a column in a dataset.
     * @return minimumValue - the lowest value in the column 8 as a double
     * @throws NumberFormatException - if item in column can not be turned into a number
     * @throws ArrayIndexOutOfBoundsException - if column isn't in rows
     */
    public double getMinValue() {

        // Initialize minimumValue to the largest double value in java
        double minimumValue = Double.MAX_VALUE;

        // Loop through each row in dataset
        for (PropertyAssessment assessment : assessments) {
            try {
                // Get value in row at column index use parseDouble to convert String to Double
                double value = assessment.getAssessedValue();

                // If this value is less than the current minimumValue
                if (value < minimumValue) {
                    minimumValue = value; // Set minimumValue to this value
                }
            }
            // If not a convertable number or in Array skip line
            catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                // Skip the row if it is an invalid row
            }
        }

        return minimumValue; // Return the minimum value
    }

    /**
     * Find the highest value in a column in a dataset.
     * @return highest value - the highest value in the column 8 as a double
     * @throws NumberFormatException - if item in column can not be turned into a number
     * @throws ArrayIndexOutOfBoundsException - if column isn't in rows
     */
    public double getMaxValue() {

        // Initialize maximumValue to the smallest double value in java
        double maximumValue = Double.MIN_VALUE;

        // Loop through each row in dataset
        for (PropertyAssessment assessment : assessments) {
            try {
                // Get value in row at column index use parseDouble to convert String to Double
                double value = assessment.getAssessedValue();

                // If this value is greater than the current maximumValue
                if (value > maximumValue) {
                    maximumValue = value;// Set maximumValue to this value
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                // Skip the row if it is an invalid row
            }
        }

        return maximumValue; // Return the maximum value
    }

    /**
     * get mean assessed value
     * @return the mean assessed value of all property assessments
     */
    public double getMeanAssessedValue() {
        // initialize
        double mean = 0.0;

        for (PropertyAssessment assessment : assessments) {
            mean += assessment.getAssessedValue();
        }
        return mean/assessments.size();
    }

    /**
     * @return the median assessed value of all property assessments
     */
    public double getMedianAssessedValue() {
        List<Double> values = assessments.stream()
                // map all assessed values
                .map(PropertyAssessment::getAssessedValue)
                // sort in ascending order
                .sorted()
                // collect all the sorted values and return them as a new list
                .collect(Collectors.toList());

        int size = values.size();

        // if nothing in list just return 0.0
        if (size == 0) return 0.0;

        // if the list has an even number of values, take average of the 2 middle
        if (size % 2 == 0) {
            return (values.get(size / 2 - 1) + values.get(size / 2)) / 2;
        }
        // if odd just get middle number
        else {
            return values.get(size / 2);
        }
    }

    /**
     * Finds property assessments by account number
     *
     * @param accountNumber the account number
     */
    public String findByAccountNumber(String accountNumber) {
        for (PropertyAssessment assessment : assessments) {
            if (accountNumber.equals(assessment.getAccountNumber())) {
                return assessment.toString();
            }
        }
        return "Error: invalid account number: " + accountNumber;
    }

    /**
     * This is not good function but work temp.
     * This method I'm changing the assessments list and then bring it back
     * This can mess up the data if something goes wrong
     * Can be refactored using a data.Neighbourhood class
     * ASK for help regarding this
     * @param neighbourhood
     * @return
     */
    public String findByNeighbourhood(String neighbourhood) {
        List<PropertyAssessment> targetNeighbourHood = new ArrayList<>();

        // Filter properties by neighbourhood
        for (PropertyAssessment assessment : assessments) {
            if (neighbourhood.equalsIgnoreCase(assessment.getNeighbourhood().getNeighbourhoodName())) {
                targetNeighbourHood.add(assessment);
            }
        }

        double minValue = 0.0;
        double maxValue = 0.0;
        double meanValue= 0.0;
        // Check if any properties were found
        if (targetNeighbourHood.isEmpty()) {
            return "Error: No properties found in neighbourhood: " + neighbourhood;
        }
        else {
             PropertyAssessments propertyAssessments = new PropertyAssessments(targetNeighbourHood);
                // Calculate statistics using methods
                minValue = propertyAssessments.getMinValue();
                maxValue = propertyAssessments.getMaxValue();
                meanValue = getMeanAssessedValue();
            return String.format("data.Neighbourhood: %s%nNumber of Properties: %d%nMin Value: $%,.2f%nMax Value: $%,.2f%nMean Value: $%,.2f",
                    neighbourhood, targetNeighbourHood.size(), minValue, maxValue, meanValue);

        }

    }

    /**
     * This is not good function but work temp.
     * This method I'm changing the assessments list and then bring it back
     * This can mess up the data if something goes wrong
     * Can be refactored using a data.Neighbourhood class
     * ASK for help regarding this
     * @param neighbourhood
     * @return
     */
    public String findByNeighbourhoodMain3(String neighbourhood) {
        List<PropertyAssessment> targetNeighbourHoodLab3 = new ArrayList<>();

        // Filter properties by neighbourhood
        for (PropertyAssessment assessment : assessments) {
            if (neighbourhood.equalsIgnoreCase(assessment.getNeighbourhood().getNeighbourhoodName())) {
                targetNeighbourHoodLab3.add(assessment);
            }
        }

        double medianValue = 0.0;
        double meanValue= 0.0;
        // Check if any properties were found
        if (targetNeighbourHoodLab3.isEmpty()) {
            return "Error: No neighbourhood found named: " + neighbourhood;
        }
        else {
            PropertyAssessments propertyAssessments = new PropertyAssessments(targetNeighbourHoodLab3);
            // Calculate statistics using methods
            medianValue = getMedianAssessedValue();
            meanValue = getMeanAssessedValue();
            return String.format("There are %s properties in %s \nThe mean value is: %s\nThe median value is: \n", targetNeighbourHoodLab3.size(), meanValue, medianValue);

        }

    }


}
