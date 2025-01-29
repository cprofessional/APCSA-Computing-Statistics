package src;

public class Loan {

    private int id;
    private double loanAmount;
    private String country;
    private int daysToFund;
    private int numLenders;

    public Loan(int i, double l, String c, int d, int n) {
        id = i;
        loanAmount = l;
        country = c;
        daysToFund = d;
        numLenders = n;
    }

    public int getID() { return id; }
    public double getLoanAmount() { return loanAmount; }
    public String getCountry() { return country; }
    public int getDaysToFund() { return daysToFund; }
    public int getNumLenders() { return numLenders; }

    public void setID(int id) { this.id = id; }
    public void setLoanAmount(double loanAmount) { this.loanAmount = loanAmount; }
    public void setCountry(String country) { this.country = country; }
    public void setDaysToFund(int daysToFund) { this.daysToFund = daysToFund; }
    public void setNumLenders(int numLenders) { this.numLenders = numLenders; }

    public String toString() {
        return "ID: " + id + " loan amount: " + loanAmount +
                " country: " + country + " days to fund: " + daysToFund +
                " num lenders: " + numLenders;
    }
}
