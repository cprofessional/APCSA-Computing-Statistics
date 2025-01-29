package src;

import java.util.ArrayList;

public class ComputingStatistics {
    /**
     * The ArrayList containing all of the loan data.
     */
    private ArrayList<Loan> data;

    /**
     * Creates a new ComputingStatistics object with an empty ArrayList.
     */
    public ComputingStatistics() {
        data = new ArrayList<Loan>();
    }

    /**
     * Creates a new ComputingStatistics object with the data passed in.
     * @param d The list of Loan objects.
     */
    public ComputingStatistics(ArrayList<Loan> d) {
        data = d;
    }

    /**
     * Calculates the total amount funded from all of the loans in the file.
     * @return The total loan amount.
     */
    public double totalAmount() {
        double amount = 0.0;
        for (int i = 0; i < data.size(); i++) {
            amount = amount + data.get(i).getLoanAmount();
        }
        return amount;
    }

    /**
     * Calculates the average loan amount.
     * @return The average loan amount.
     */
    public double avgLoan() {
        return totalAmount() / data.size();
    }

    /**
     * Finds the largest loan amount.
     * @return The largest loan amount.
     */
    public double largestLoan() {
        double max = Double.MIN_VALUE;
        for (Loan loan : data) {
            if (loan.getLoanAmount() > max) {
                max = loan.getLoanAmount();
            }
        }
        return max;
    }

    /**
     * Finds the smallest loan amount.
     * @return The smallest loan amount.
     */
    public double smallestLoan() {
        double min = Double.MAX_VALUE;
        for (Loan loan : data) {
            if (loan.getLoanAmount() < min) {
                min = loan.getLoanAmount();
            }
        }
        return min;
    }

    /**
     * Finds the country with the largest loan amount.
     * @return The country with the largest loan.
     */
    public String largestLoanCountry() {
        double max = Double.MIN_VALUE;
        String country = "";
        for (Loan loan : data) {
            if (loan.getLoanAmount() > max) {
                max = loan.getLoanAmount();
                country = loan.getCountry();
            }
        }
        return country;
    }

    /**
     * Finds the country with the smallest loan amount.
     * @return The country with the smallest loan.
     */
    public String smallestLoanCountry() {
        double min = Double.MAX_VALUE;
        String country = "";
        for (Loan loan : data) {
            if (loan.getLoanAmount() < min) {
                min = loan.getLoanAmount();
                country = loan.getCountry();
            }
        }
        return country;
    }

    /**
     * Calculates the average number of days needed to fund a loan.
     * @return The average number of days to fund a loan.
     */
    public double avgDaysToFund() {
        double totalDays = 0;
        for (Loan loan : data) {
            totalDays += loan.getDaysToFund();
        }
        return totalDays / data.size();
    }

    /**
     * Finds the largest loan amount made to people in Kenya.
     * @return The largest loan amount in Kenya.
     */
    public double largestLoanKenya() {
        double max = Double.MIN_VALUE;
        for (Loan loan : data) {
            if (loan.getCountry().equals("Kenya") && loan.getLoanAmount() > max) {
                max = loan.getLoanAmount();
            }
        }
        return max;
    }

    /**
     * Calculates the average loan amount in the Philippines.
     * @return The average loan amount in the Philippines.
     */
    public double avgLoanPhilippines() {
        double total = 0;
        int count = 0;
        for (Loan loan : data) {
            if (loan.getCountry().equals("Philippines")) {
                total += loan.getLoanAmount();
                count++;
            }
        }
        return (count > 0) ? total / count : 0;
    }

    /**
     * Finds the country with the longest time to fund a loan.
     * @return The country with the longest time to fund a loan.
     */
    public String longestToFundCountry() {
        int maxDays = Integer.MIN_VALUE;
        String country = "";
        for (Loan loan : data) {
            if (loan.getDaysToFund() > maxDays) {
                maxDays = loan.getDaysToFund();
                country = loan.getCountry();
            }
        }
        return country;
    }

    /**
     * Determines which country, El Salvador or Kenya, has more loans funded.
     * @return The country with the most loans funded.
     */
    public String mostLoansFunded() {
        int kenyaCount = 0, elSalvadorCount = 0;
        for (Loan loan : data) {
            if (loan.getCountry().equals("Kenya")) kenyaCount++;
            if (loan.getCountry().equals("El Salvador")) elSalvadorCount++;
        }
        return (kenyaCount > elSalvadorCount) ? "Kenya" : "El Salvador";
    }

    /**
     * Calculates the variance of the loan amounts.
     * @return The variance of the loan amounts.
     */
    public double variance() {
        double mean = avgLoan();
        double sum = 0;
        for (Loan loan : data) {
            sum += Math.pow(loan.getLoanAmount() - mean, 2);
        }
        return sum / data.size();
    }

    /**
     * Calculates the standard deviation of the loan amounts.
     * @return The standard deviation of the loan amounts.
     */
    public double standardDeviation() {
        return Math.sqrt(variance());
    }

    /**
     * Checks whether the empirical rule (68% of data within 1 standard deviation) holds.
     * @return true if the empirical rule holds, false otherwise.
     */
    public boolean empiricalRule() {
        double mean = avgLoan();
        double stdDev = standardDeviation();
        int count = 0;
        for (Loan loan : data) {
            if (Math.abs(loan.getLoanAmount() - mean) <= stdDev) {
                count++;
            }
        }
        return (count / (double) data.size()) >= 0.68;
    }
}
