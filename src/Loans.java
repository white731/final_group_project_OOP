import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Loans extends Money {
    /*
    instance variables loanAmount, lengthOfLoan, interestRate
     */
    private double loanAmount;
    private int lengthOfLoan;
    private double interestRate;

    /**
     * Loans Method
     * Constructor #1
     * No parameters
     */
    public Loans() {
    }

    /**
     * Loans Method
     * Constructor #2 - sets the values of the instance variable to loanAmount, lengthOfLoan, interestRate
     * @param loanAmount - currency value unformatted
     * @param lengthOfLoan - how long the loan is for
     * @param interestRate - the interest the user will be charged
     */

    public Loans(double amount, String currency, double loanAmount, int lengthOfLoan, double interestRate, String currency1) {
        super(amount, currency);
        this.loanAmount = loanAmount;
        this.lengthOfLoan = lengthOfLoan;
        this.interestRate = interestRate;
    }

    /**
     * getLoanAmount
     * Method to get the amount from a Money object
     * @return loanAmount
     */
    public double getLoanAmount() {
        return loanAmount;
    }

    /**
     * setLoanAmount
     * Sets the amount of an object to instance variable value
     * @param loanAmount this is a double, it represents an amount of unformatted money
     */
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * getLengthOfLoan
     * Method to get the amount from a Money object
     * @return lengthOfLoan
     */
    public int getLengthOfLoan() {
        return lengthOfLoan;
    }

    /**
     * setLengthOfLoan
     * Sets the amount of an object to instance variable value
     * @param lengthOfLoan this is a double, it represents how long it will take to pay off the loan
     */
    public void setLengthOfLoan(int lengthOfLoan) {
        this.lengthOfLoan = lengthOfLoan;
    }

    /**
     * getInterestRate
     * Method to get the loan interest from a Money object
     * @return interestRate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * setInterestRate
     * Sets the interest of an object to instance variable value
     * @param interestRate this is a double, it represents the interest rate of the loan
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }


    /** monthlyPayment Method
     * monthlyPayment method will calculate how much the user
     *  needs to pay monthly to finish paying the loan in a certain period.
     * @return  montlhyPayment
     */

    public double monthlyPayment (){
        double monthlyRate = interestRate/1200;
        double periods= lengthOfLoan*12;
        double payment = (loanAmount * monthlyRate)/(1-Math.pow(1+ monthlyRate, -periods));
        return payment;
    }

    @Override
    public String to_currency() {
        String x = super.to_currency();
        String y = "Monthly Payment is: ";
        return y + x;
    }

    public static void main(String[] arg) {

             /*
        1. Create a new fileObject using the File class for reading the InvestmentData.txt file
        1. Create a new fileObject using the File class for reading the LoanData.txt file
         */

        File loanFile = new File("LoanData.txt");

        /*
        Create two new ArrayList objects for gathering all the information from each of the files
         */

        ArrayList<String> loanArray = new ArrayList<>();

        /*
        Use a try/catch combination to scan each file for the data
         */


        //------------------Loans-----------------------//

        // create a scanner to read in the loan file
        try {
            Scanner readLoanFile = new Scanner(loanFile);

            // loop over all the lines of the loan file to to get all the strings
            while (readLoanFile.hasNextLine()) {
                loanArray.add(readLoanFile.nextLine());
            }
            readLoanFile.close();

            // if file does not exist, goes to catch and prints an error message

        } catch (FileNotFoundException ex) {
            System.out.println("This File does not Exist. Make sure that it is available on the server");
            System.out.println(ex);
        }

        /*
        Parse out each of the strings returned from the scanner and turn them into their respective data types
        use the split function on the character ":" to split the string into an array of 2. the string at array [0]
        will be the label and the item at location [1] will be the response from the user.
         */
        try{

            String loanAmountString = loanArray.get(0).split(":")[0];
            double loanAmountNum = Double.parseDouble(loanArray.get(0).split(":")[1].trim());
            String loanYearsString = loanArray.get(1).split(":")[0];
            int loanYearsNum = Integer.parseInt(loanArray.get(1).split(":")[1].trim());
            String loanInterestString = loanArray.get(2).split(":")[0];
            String loanInterestNumString = loanArray.get(2).split(":")[1].trim();
            double loanInterestNum = 0.00;
            if (loanInterestNumString.contains("%")) {
                loanInterestNum = Double.parseDouble(loanArray.get(2).split(":")[1].split("%")[0].trim());
            } else {
                System.out.printf("Sorry You'll need to adjust your answer so there is a percentage on the number. like this %s", loanInterestNumString);
            }
            String loanCurrencyString = loanArray.get(3).split(":")[0];
            String loanCurrency = loanArray.get(3).split(":")[1].trim();

          /*
        create an Investments object called fv (future value)
         */
            Loans mp = new Loans();


        /*
        Assign the the newly created investment object all the inputs that were gathered from the scanner
         */

            mp.setCurrency(loanCurrency);
            mp.setInterestRate(loanInterestNum);
            mp.setLoanAmount(loanAmountNum);
            mp.setLengthOfLoan(loanYearsNum);

        /*
        create a variable that stores the fv.futureValue
         */

            double monthlyPayment = mp.monthlyPayment();

        /*
        set Amount to futureValue
         */
            mp.setAmount(monthlyPayment);

        /*
        Write the answers to the very same file that was read. Write back in all the original inputs along with the
        the answer (future value) using the to_currency method
         */


            System.out.println(mp.to_currency());



         /*
        Write the answers to the very same file that was read. Write back in all the original inputs along with the
        the answer (future value) using the to_currency method
         */

            try {
                FileWriter investmentWriter = new FileWriter("LoanData.txt", true);
                investmentWriter.append("\n");
                investmentWriter.append(mp.to_currency());
                investmentWriter.close();


            } catch (IOException e) {
                System.out.println("An Error occurred");

            }

        }

        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Please enter values into the LoanData.txt file");
        }
        catch(NumberFormatException e) {
            System.out.println("When entering dollar amounts, only enter numbers with no dollar signs" +
                    "or any other characters. The interest rate is the only number field that requires a % sign.");
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("It looks like you've changed part of the of original text file");
            ResetFiles.main(null);
        }
    }
}
