public class Investments extends Money{

        private double investmentAmount;
        private int lengthOfInvestment;
        private double interestRate;
        private double monthlyInput;

    public Investments() {
    }

    public Investments(double amount, String currency, double investmentAmount, int lengthOfInvestment, double interestRate, double monthlyInput, String currency1) {
        super(amount, currency);
        this.investmentAmount = investmentAmount;
        this.lengthOfInvestment = lengthOfInvestment;
        this.interestRate = interestRate;
        this.monthlyInput = monthlyInput;
    }

    public double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public int getLengthOfInvestment() {
        return lengthOfInvestment;
    }

    public void setLengthOfInvestment(int lengthOfInvestment) {
        this.lengthOfInvestment = lengthOfInvestment;
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

    public double futureValue(){
        double fv = investmentAmount * Math.pow((1+(interestRate/12)),(lengthOfInvestment*12));
        return fv;
    }

    @Override
    public String to_currency() {
       String x = super.to_currency();
       String y = "Future Value Amount";
        return x + y;
    }
}
