public class Investments extends Money{

        private double investmentAmount;
        private int lengthOfLoan;
        private double interestRate;
        private double monthlyInput;
        private String currency;

    public Investments() {

    }

    public Investments(double amount, String currency, double investmentAmount, int lengthOfLoan, double interestRate, double monthlyInput, String currency1) {
        super(amount, currency);
        this.investmentAmount = investmentAmount;
        this.lengthOfLoan = lengthOfLoan;
        this.interestRate = interestRate;
        this.monthlyInput = monthlyInput;
        this.currency = currency1;
    }

    public double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(double investmentAmount) {
        this.investmentAmount = investmentAmount;
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

    public double getMonthlyInput() {
        return monthlyInput;
    }

    public void setMonthlyInput(double monthlyInput) {
        this.monthlyInput = monthlyInput;
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
