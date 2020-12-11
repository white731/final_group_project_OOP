import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Loans extends Money {

    private double loanAmount;
    private int lengthOfLoan;
    private double interestRate;
    private double downPayment;

    public Loans() {
    }

    public Loans(double amount, String currency, double loanAmount, int lengthOfLoan, double interestRate, double downPayment, String currency1) {
        super(amount, currency);
        this.loanAmount = loanAmount;
        this.lengthOfLoan = lengthOfLoan;
        this.interestRate = interestRate;
        this.downPayment = downPayment;
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
    public String to_currency() {
        String x = super.to_currency();
        String y = "Future Value Amount";
        return x + y;
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
            while(readLoanFile.hasNextLine()){
                loanArray.add(readLoanFile.nextLine());
            }
            readLoanFile.close();

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
        String loanAmountString = loanArray.get(0).split(":")[0];
        double loanAmountNum = Double.parseDouble(loanArray.get(0).split(":")[1]);
        String loanYearsString = loanArray.get(1).split(":")[0];
        int loanYearsNum = Integer.parseInt(loanArray.get(1).split(":")[1]);
        String loanInterestString = loanArray.get(2).split(":")[0];
        String loanInterestNumString = loanArray.get(2).split(":")[1];
        double loanInterestNum = 0.00;
        if (loanInterestNumString.contains("%")) {
            loanInterestNum = Double.parseDouble(loanArray.get(2).split(":")[1].split("%")[0]);
        } else {
            System.out.printf("Sorry You'll need to adjust your answer so there is a percentage on the number. like this %s",loanInterestNumString);
        }
        String loanInputString = loanArray.get(3).split(":")[0];
        double loanInputNum = Double.parseDouble(loanArray.get(3).split(":")[1]);
        String loanCurrencyString = loanArray.get(4).split(":")[0];
        String loanCurrency = loanArray.get(4).split(":")[1].trim();


    }
}
