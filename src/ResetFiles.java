import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ResetFiles {

    public static void main(String[] args){

        try {
            File investmentFile = new File("InvestmentData.txt");
            if (investmentFile.createNewFile()) {
                System.out.println("File created: " + investmentFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter investmentStartData = new FileWriter("InvestmentData.txt");
            investmentStartData.write(
                    "Investment Amount:\n" +
                    "Length of Investment in Year(s):\n" +
                    "Annual Interest Rate:\n" +
                    "Monthly input:\n" +
                    "Currency (Input “dollar”, “pound”, “euro” or “peso”):");
            investmentStartData.close();

        } catch ( IOException e) {
            System.out.println("Theres Been an Error");
        }
//---------------------------------Loan------------------------------------//
        try {
            File loanFile = new File("LoanData.txt");
            if (loanFile.createNewFile()) {
                System.out.println("File created: " + loanFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter loanStartData = new FileWriter("LoanData.txt");
            loanStartData.write(
                    "Loan Amount:\n" +
                            "Length of Loan in Years:\n" +
                            "Annual Interest Rate:\n" +
                            "Currency (Type “dollar”, “pound”, “euro” or “peso”):");
            loanStartData.close();

        } catch ( IOException e) {
            System.out.println("Theres Been an Error");
        }

    }
}
