import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args){

        /*
        1. Create a new fileObject using the File class for reading the InvestmentData.txt file
        1. Create a new fileObject using the File class for reading the LoanData.txt file
         */

        File investmentFile = new File("InvestmentData.txt");
        File loanFile = new File("LoanData.txt");

        /*
        Create two new ArrayList objects for gathering all the information from each of the files
         */
        ArrayList<String> investmentArray = new ArrayList<>();
        ArrayList<String> loanArray = new ArrayList<>();

        /*
        Use a try/catch combination to scan each file for the data
         */

        //------------------Investments-----------------------//

        try {
            Scanner readInvestmentFile = new Scanner(investmentFile);
            while(readInvestmentFile.hasNextLine()){
                investmentArray.add(readInvestmentFile.nextLine());
            }
            readInvestmentFile.close();
            // if file does not exist, goes to catch and prints an error message
        } catch (FileNotFoundException ex){
            System.out.println("This File does not Exist. Make sure that it is available on the server");
            System.out.println(ex);
        }

        String investmentAmountString = investmentArray.get(0).split(":")[0];
        double investmentAmountNum = Double.parseDouble(investmentArray.get(0).split(":")[1]);
        String investmentYearsString = investmentArray.get(1).split(":")[0];
        double investmentYearsNum = Double.parseDouble(investmentArray.get(1).split(":")[1]);
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

        //------------------Loans-----------------------//
        try {
            Scanner readLoanFile = new Scanner(loanFile);
            while(readLoanFile.hasNextLine()){
                loanArray.add(readLoanFile.nextLine());
            }
            readLoanFile.close();

        } catch (FileNotFoundException ex){
            System.out.println("This File does not Exist. Make sure that it is available on the server");
            System.out.println(ex);
        }

        String loanAmountString = loanArray.get(0).split(":")[0];
        double loanAmountNum = Double.parseDouble(loanArray.get(0).split(":")[1]);
        String loanYearsString = loanArray.get(1).split(":")[0];
        double loanYearsNum = Double.parseDouble(loanArray.get(1).split(":")[1]);
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
        

        /*
        Output of Investment File
         */

        System.out.println("-------------------------------------Investment Information--------------------------------");
        System.out.println(investmentAmountString);
        System.out.println(investmentAmountNum);
        System.out.println(investmentInterestString);
        System.out.println(investmentInterestNum+"%");
        System.out.println(investmentYearsString);
        System.out.println(investmentYearsNum);
        System.out.println(investmentInputString);
        System.out.println(investmentInputNum);
        System.out.println(investmentCurrencyString);
        System.out.println(investmentCurrency);
        

        /*
        Output of Loan File
         */

        System.out.println("-------------------------------------Loan Information--------------------------------");
        System.out.println(loanAmountString);
        System.out.println(loanAmountNum);
        System.out.println(loanInterestString);
        System.out.println(loanInterestNum+"%");
        System.out.println(loanYearsString);
        System.out.println(loanYearsNum);
        System.out.println(loanInputString);
        System.out.println(loanInputNum);
        System.out.println(loanCurrencyString);
        System.out.println(loanCurrency);





    }
}
