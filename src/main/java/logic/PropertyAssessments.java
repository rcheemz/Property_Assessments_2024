package logic;

import com.opencsv.exceptions.CsvValidationException;
import data.Address;
import data.AssessmentClass;
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
            // Ensure every row has exactly 18 columns by filling missing values
            row = Arrays.copyOf(row, 18);
            for (int i = 0; i < row.length; i++) {
                if (row[i] == null || row[i].trim().equals("<null>")) {
                    row[i] = ""; // Replace <null> or missing values with empty string
                }
            }

            String accountNumber = row[0];
            String suite = row[1];
            String houseNumber = row[2];
            String street = row[3];
            String neighbourhoodId = row[5];
            String neighbourhoodName = row[6];
            String ward = row[7];
            String assessedValue = row[8];

            // If assessed value is empty, set to 0
            double parsedValue = assessedValue.isEmpty() ? 0.0 : Double.parseDouble(assessedValue);

            // Extract AssessmentClass fields
            String percent1 = row[12].isEmpty() ? "0" : row[12];
            String percent2 = row[13].isEmpty() ? "0" : row[13];
            String percent3 = row[14].isEmpty() ? "0" : row[14];
            String class1 = row[15].isEmpty() ? "Unknown" : row[15];
            String class2 = row[16].isEmpty() ? "Unknown" : row[16];
            String class3 = row[17].isEmpty() ? "Unknown" : row[17];

            AssessmentClass assessmentClass = new AssessmentClass(percent1, percent2, percent3, class1, class2, class3);
            Address address = new Address(houseNumber, suite, street);
            Neighbourhood neighbourhood = new Neighbourhood(neighbourhoodId, neighbourhoodName, ward);

            // Add the property assessment even if some fields are missing
            assessments.add(new PropertyAssessment(
                    accountNumber,
                    address,
                    neighbourhood,
                    ward,
                    parsedValue,
                    assessmentClass));
        }

        System.out.println("Total properties loaded: " + assessments.size());
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
    public int getSize(){

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
     * Find properties by neighbourhood
     * @param neighbourhood - name of neighbourhood target
     * @return PropertyAssessments
     */
    public PropertyAssessments findByNeighbourhood(String neighbourhood) {
        List<PropertyAssessment> targetNeighbourHood = new ArrayList<>();

        // Filter properties by neighbourhood
        for (PropertyAssessment assessment : assessments) {
            if (neighbourhood.equalsIgnoreCase(assessment.getNeighbourhood().getNeighbourhoodName())) {
                targetNeighbourHood.add(assessment);
            }
        }

        if (targetNeighbourHood.isEmpty()) {
            return null;
        }
        else {
             PropertyAssessments neighbourhoodAssessments = new PropertyAssessments(targetNeighbourHood);
                return neighbourhoodAssessments;
        }
    }

    /**
     * Filters properties by assessment class and returns a new PropertyAssessments object.
     * @param assessmentClassQuery The assessment class name to filter by (e.g., "Residential").
     * @return A PropertyAssessments object with only the matching properties.
     */
    public PropertyAssessments findByAssessmentClass(String assessmentClassQuery) {
        List<PropertyAssessment> filtered = new ArrayList<>();

        for (PropertyAssessment assessment : assessments) {
            AssessmentClass ac = assessment.getAssessmentClass();

            // If 100%, only check the first class.
            if ("100".equals(ac.getAssessmentPrecent1())) {
                if (ac.getAssessmentClass1().equalsIgnoreCase(assessmentClassQuery)) {
                    filtered.add(assessment);
                }
            } else {
                // Otherwise, check all three class fields.
                if (ac.getAssessmentClass1().equalsIgnoreCase(assessmentClassQuery) ||
                        ac.getAssessmentClass2().equalsIgnoreCase(assessmentClassQuery) ||
                        ac.getAssessmentClass3().equalsIgnoreCase(assessmentClassQuery)) {
                    filtered.add(assessment);
                }
            }
        }

        return new PropertyAssessments(filtered);
    }


}
