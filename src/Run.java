import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args){

        File fileText = new File("InvestmentInfo.txt");
        ArrayList<String> fileArray = new ArrayList<>();

        try {
            Scanner readFile = new Scanner(fileText);
            while(readFile.hasNextLine()){
                fileArray.add(readFile.nextLine());
            }
            readFile.close();
        } catch (FileNotFoundException ex){
            System.out.println("This File does not Exist. Make sure that it is available on the server");
            System.out.println(ex);
        }


            String investmentAmountString = fileArray.get(0).split(":")[0];
            double investmentAmountNum = Double.parseDouble(fileArray.get(0).split(":")[1]);

        System.out.println(investmentAmountNum);
        System.out.println(investmentAmountString);

            String yearsString = fileArray.get(1).split(":")[0];
            double yearsNum = Double.parseDouble(fileArray.get(1).split(":")[1]);

        System.out.println(yearsNum);
        System.out.println(yearsString);

            String interestString = fileArray.get(2).split(":")[0];
            System.out.println(interestString);
            String interestNumString = fileArray.get(2).split(":")[1];
            if (interestNumString.contains("%")) {
                double interestNum = Double.parseDouble(fileArray.get(2).split(":")[1].split("%")[0]);
                System.out.println(interestNum);
            } else {
                System.out.printf("Sorry You'll need to adjust your answer so there is a percentage on the number. like this %s",interestNumString);
            }

            String inputString = fileArray.get(3).split(":")[0];
            double inputNum = Double.parseDouble(fileArray.get(3).split(":")[1]);
            System.out.println(inputNum);
            System.out.println(inputString);







    }
}
