import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Investments extends Money{

        private double investmentAmount;
        private int lengthOfInvestment;
        private double interestRate;
        private double monthlyInput;

    public Investments() {
    }

    public Investments(double amount, String currency, double investmentAmount, int lengthOfInvestment, double interestRate, double monthlyInput) {
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
       String y = "Future Value Amount is: ";
        return y + x;
    }

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
        double futureValue = fv.futureValue();


        /*
        Assign the the newly created investment object all the inputs that were gathered from the scanner
         */
        fv.setAmount(futureValue);
        fv.setCurrency(investmentCurrency);
        fv.setInterestRate(investmentInterestNum);
        fv.setInvestmentAmount(investmentAmountNum);
        fv.setLengthOfInvestment(investmentYearsNum);
        fv.setMonthlyInput(investmentInputNum);

        /*
        Write the answers to the very same file that was read. Write back in all the original inputs along with the
        the answer (future value) using the to_currency method
         */

        System.out.println("futureValue is:" + fv.futureValue());
        System.out.println(fv.to_currency());


       /*
        create an Investments object called fv (future value)
         */

         /*
        Assign the the newly created investment object all the inputs that were gathered from the scanner
         */

         /*
        Write the answers to the very same file that was read. Write back in all the original inputs along with the
        the answer (future value) using the to_currency method
         */






    }
}
