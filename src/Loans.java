public class Loans extends Money {

    private double loanAmount;
    private int lengthOfLoan;
    private double interestRate;
    private double downPayment;
    private String currency;

    public Loans() {

    }

    public Loans(double amount, String currency, double loanAmount, int lengthOfLoan, double interestRate, double downPayment, String currency1) {
        super(amount, currency);
        this.loanAmount = loanAmount;
        this.lengthOfLoan = lengthOfLoan;
        this.interestRate = interestRate;
        this.downPayment = downPayment;
        this.currency = currency1;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getLengthOfLoan() {
        return lengthOfLoan;
    }

    public void setLengthOfLoan(int lengthOfLoan) {
        this.lengthOfLoan = lengthOfLoan;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    @Override
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String to_currency() {
        String x = super.to_currency();
        String y = "Future Value Amount";
        return x + y;
    }

}
