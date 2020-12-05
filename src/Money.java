public class Money {

    private double amount;
    private String currency;

    public Money() {
    }

    public Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String to_currency(){
        String money = currency+String.valueOf(amount);
        return money;
    }

}
