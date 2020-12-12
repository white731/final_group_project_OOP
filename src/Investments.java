import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// create a class called Investments that extends Money

public class Investments extends Money{

// Create 4 instance variables that will be necessary to calculate the future value for the user.

        private double investmentAmount;
        private int lengthOfInvestment;
        private double interestRate;
        private double monthlyInput;

    /**
     * Investments
     * empty constructor
     * this is here so that you can create empty objects off the bat if you want.
     * Returns Nada
     * no Params
     */
    public Investments() {
    }

    /**
     * Investments
     * Second constructor but with params. Purpose is to create an object with different attributes
     * @params amount - this is inherited from the Money class its actually represents the future value in our case
     * @params currency - what ever type of currency the user wants. Dollar, euro, pound, etc.
     * @params investmentAmount - present value
     * @params lengthOfInvestment - in years
     * @params interestRate - for one year
     * @params monthlyInput - the amount of money the user puts in each month
     */

    public Investments(double amount, String currency, double investmentAmount, int lengthOfInvestment, double interestRate, double monthlyInput) {
        super(amount, currency);
        this.investmentAmount = investmentAmount;
        this.lengthOfInvestment = lengthOfInvestment;
        this.interestRate = interestRate;
        this.monthlyInput = monthlyInput;
    }

    /**
     * getInvestmentAmount
     * getter for InvestmentAmount
     * @return investmentAmount
     */
    public double getInvestmentAmount() {
        return investmentAmount;
    }

    /**
     * setInvestmentAmount
     * sets the investmentAmount for an instance of the class
     * @param investmentAmount
     */
    public void setInvestmentAmount(double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    /**
     * getLengthOfInvestment
     * getter for LengthOfInvestment
     * @return LengthOfInvestment
     */
    public int getLengthOfInvestment() {
        return lengthOfInvestment;
    }

    /**
     * setLengthOfInvestment
     * sets the lengthOfInvestment for an instance of the class
     * @param lengthOfInvestment
     */
    public void setLengthOfInvestment(int lengthOfInvestment) {
        this.lengthOfInvestment = lengthOfInvestment;
    }

    /**
     * getInterestRate
     * getter for interestRate
     * @return interestRate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * setInterestRate
     * sets the interestRate for an instance of the class
     * @param interestRate
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * getMonthlyInput
     * getter for MonthlyInput
     * @return MonthlyInput
     */
    public double getMonthlyInput() {
        return monthlyInput;
    }

    /**
     * setMonthlyInput
     * sets the MonthlyInput for an instance of the class
     * @param monthlyInput
     */
    public void setMonthlyInput(double monthlyInput) {
        this.monthlyInput = monthlyInput;
    }

    /**
     * futureValue
     * This is the main method where future value is calculated. to get it the user just creates a investments object
     * and writes "objectName".futureValue().
     * @return fv or the future value of an object
     */
    public double futureValue(){
        double interestRate1 = interestRate/12;
        int periods = lengthOfInvestment*12;
        double fv = investmentAmount + lengthOfInvestment;
        return fv;
    }

    /**
     * to_currency
     * This is the method that formats the futureValue amount into whatever currency the user has chosen
     * @return a string that's formatted. ie. $200.00
     */
    @Override
    public String to_currency() {
       String x = super.to_currency();
       String y = "Future Value Amount is: ";
        return y + x;
    }

    /**
     * Main
     * Main does a lot. Refer to the comments to see all thats going on but to be concise it does the following:
     * 1. Gets info from the files from the user
     * 2. parses the information to be used
     * 3. creates an instance of the Investment class
     * 4. calculates future value
     * 5. outputs the answer in a text file.
     *
     */
    public static void main(String[] args){
//        1. Create a new fileObject using the File class for reading the InvestmentData.txt file

        File investmentFile = new File("InvestmentData.txt");

         /*
        Create a new ArrayList object for gathering all the information from the investment the files
         */

        ArrayList<String> investmentArray = new ArrayList<>();

        /*
        Use a try/catch combination to scan each file for the data
         */

        try {

            // create a scanner to read in investment file
            Scanner readInvestmentFile = new Scanner(investmentFile);

            // loop over the the lines of the file with the scanner
            while(readInvestmentFile.hasNextLine()){
                investmentArray.add(readInvestmentFile.nextLine());
            }
            readInvestmentFile.close();
            // if file does not exist, goes to catch and prints an error message
        } catch (FileNotFoundException ex){
            System.out.println("This File does not Exist. Make sure that it is available on the server");
            System.out.println(ex);
        }

        /*
        Parse out each of the strings returned from the scanner and turn them into their respective data types
        use the split function on the character ":" to split the string into an array of 2. the string at array [0]
        will be the label and the item at location [1] will be the response from the user.
         */

        /*
        include some validations on some inputs (like interest rate ) so that an input without a "%" won't work
         */

        String investmentAmountString = investmentArray.get(0).split(":")[0];
        double investmentAmountNum = Double.parseDouble(investmentArray.get(0).split(":")[1]);
        String investmentYearsString = investmentArray.get(1).split(":")[0];
        int investmentYearsNum = Integer.parseInt(investmentArray.get(1).split(":")[1]);
        String investmentInterestString = investmentArray.get(2).split(":")[0];
        String investmentInterestNumString = investmentArray.get(2).split(":")[1];
        double investmentInterestNum = 0.00;
        if (investmentInterestNumString.contains("%")) {
            investmentInterestNum = Double.parseDouble(investmentArray.get(2).split(":")[1].split("%")[0]);
        } else {
            System.out.printf("Sorry You'll need to adjust your answer so there is a percentage on the number. like this %s",investmentInterestNumString);
        }
        String investmentInputString = investmentArray.get(3).split(":")[0];
        double investmentInputNum = Double.parseDouble(investmentArray.get(3).split(":")[1]);
        String investmentCurrencyString = investmentArray.get(4).split(":")[0];
        String investmentCurrency = investmentArray.get(4).split(":")[1].trim();

        /*
        create an Investments object called fv (future value)
         */
        Investments fv = new Investments();

        double futureValue1 = 100.00;


        /*
        Assign the the newly created investment object all the inputs that were gathered from the scanner
         */

        fv.setCurrency(investmentCurrency);
        fv.setInterestRate(investmentInterestNum);
        fv.setInvestmentAmount(investmentAmountNum);
        fv.setLengthOfInvestment(investmentYearsNum);
        fv.setMonthlyInput(investmentInputNum);

        /*
        create a variable that stores the fv.futureValue
         */

        double futureValue = fv.futureValue();

        /*
        set Amount to futureValue
         */
        fv.setAmount(futureValue);

        /*
        Write the answers to the very same file that was read. Write back in all the original inputs along with the
        the answer (future value) using the to_currency method
         */


        System.out.println("futureValue is:" + fv.futureValue());
        System.out.println(fv.to_currency());



         /*
        Write the answers to the very same file that was read. Write back in all the original inputs along with the
        the answer (future value) using the to_currency method
         */

        try {
            FileWriter investmentWriter = new FileWriter("InvestmentData.txt",true);
            investmentWriter.append("\n");
            investmentWriter.append(fv.to_currency());
            investmentWriter.close();



        } catch (IOException e) {
            System.out.println("An Error occurred");

        }






    }
}
