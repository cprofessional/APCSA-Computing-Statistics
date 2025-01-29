package lib;

import src.ComputingStatistics;
import src.Loan;

import java.util.*;
import java.io.*;
import java.text.*;

public class ComputingStatisticsRunner {
    public static void main(String[] args) throws FileNotFoundException {
        // Specifies the data file to be used.
        String file = "lib/kiva_loans_small.csv";

        // Creates an ArrayList to store the data and calls the readData() method.
        ArrayList<Loan> list = readData(file);

        // Loop to print out the existing data to see how it is structured.
//        for(int i = 0; i < list.size(); i++) {
//           System.out.println(list.get(i));
//        }

        //Use this code to test the methods in the ComputingStatistics class
        ComputingStatistics analysis = new ComputingStatistics(list);
        System.out.println("Total amount: " + analysis.totalAmount());
        System.out.println("Average loan amount: " + analysis.avgLoan());
        System.out.println("Largest Loan: " + analysis.largestLoan());
        System.out.println("Smallest Loan: " + analysis.smallestLoan());
        System.out.println("Largest Loan Country: " + analysis.largestLoanCountry());
        System.out.println("Smallest Loan Country: " + analysis.smallestLoanCountry());
        System.out.println("Average days to fund: " + analysis.avgDaysToFund());
        System.out.println("Average loan amount in the Philippines: "+ analysis.avgLoanPhilippines());
        System.out.println("The country with the longest to fund loan:" + analysis.longestToFundCountry());
        System.out.println("Variance: " + analysis.variance());
        System.out.println("Standard Deviation: " + analysis.standardDeviation());
        System.out.println("Empiricial Rules (yes/no): " + analysis.empiricalRule());
    }


    /**
     * Reads in the provided file and creates an ArrayList of the data.
     * @param file the name of the text file containing the data.
     * @return the ArrayList containing the data from the text file.
     */
    public static ArrayList<Loan> readData(String file) throws FileNotFoundException {
        // Scanner used to read in the data from the file.
        Scanner in = new Scanner(new File(file));
        // ArrayList to store the data.
        ArrayList<Loan> list = new ArrayList<Loan>();
        // Read in the header line so it is not added to the ArrayLists.
        String header = in.nextLine();
        // Check to see if the file still has data to be read in.
        while(in.hasNextLine()) {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // Read in the line of data and
            // use a space as a delimiter to separate the different columns.
            String[] line = in.nextLine().split(",");

            // Local variable containing the ID.
            int ID = Integer.parseInt(line[0]);

            // Local variable containing the amount.
            int amount = Integer.parseInt(line[2]);

            // Local variable containing the country.
            String country = line[5];

            // Local variable containing the lenders.
            int lenders = Integer.parseInt(line[11]);

            // Local variable containing the difference in days.
            int differenceInDays = -1;

            try {
                Date postedDate = sdf.parse(line[8]);

                Date fundedDate = sdf.parse(line[9]);

                long differenceInTime = fundedDate.getTime() - postedDate.getTime();

                differenceInDays = (int)((differenceInTime / (1000 * 60 * 60 * 24)) % 365);
            }

            // Catch the Exception
            catch (ParseException e) {
                e.printStackTrace();
            }
            // Add the loan to the arraylist.
            list.add(new Loan(ID, amount, country, differenceInDays, lenders));

        }
        // Return the completed ArrayLists.
        return list;
    }
}