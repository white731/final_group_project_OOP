public class Money {

    /*
    instance Variables amount and currency
     */
    private double amount;
    private String currency;

    /**
     * Money Method
     * Constructor #1
     * No parameters
     *
     */
    public Money() {
    }

    /**
     * Money Method
     * Constructor #2 - sets the values of the instace variable to amount and currency
     * @param amount - dollar value unformatted
     * @param currency - type of currency like "peso", "dollar" or "euro"
     */
    public Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    /**
     * getAmount
     * Method to get the amount from a Money object
     * @return currency
     */
    public double getAmount() {
        return amount;
    }

    /**
     * setAmount
     * Sets the amount of an object to instance variable value
     * @param amount this is a double, it represents an amount of unformatted money
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * getCurrency
     * Method to get the currency type from a Money object
     * @return currency
     */
    public String getCurrency() {
        return currency;
    }
    /**
     * setCurrency
     * Sets the currency of an object to instance variable value
     * @param currency this is a string like "dollar" or "euro"
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * to_currency
     * purpose is to format the money string with the appropriate money symbol
     * @return formatted currency amount
     */
    public String to_currency() {
        String symbol = "";
        switch (currency) {
            case "dollar":
                symbol = "$";
                break;
            case "pound":
                symbol = "£";
                break;
            case "euro":
                symbol = "€";
                break;
            case "peso":
                symbol = "₱";
                break;
            default:
                symbol = "Please enter the type “dollar”, “pound”, “euro” or “peso-------";
                break;
        }

        double formattedAmount = Math.round(amount * 100.0)/100.0;

        String money = symbol + formattedAmount;
        return money;
    }


}
