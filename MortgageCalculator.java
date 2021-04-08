import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        int principal = (int)getInput("Principal (1K - 1M): ", 1000, 1000000);
        float annualInterest = (float)getInput("Annual Interest Rate: ", 1, 30);
        byte years = (byte)getInput("Period (Years): ", 1, 30);

        double mortgage = mortgageCal(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    public static double getInput(String prompt, double min, double max){
        Scanner input = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = input.nextFloat();
            if(value >= min && value <= max)
                break;
            System.out.println("Please enter a number between " + min + "    and " + max + ".");
        };
        return value;
    }

    public static double mortgageCal(int principal, float annualInterest, byte years) {
        final byte PARCENTAGE = 100;
        final byte TOTAL_MONTH = 12;

        float interestRate = annualInterest / PARCENTAGE / TOTAL_MONTH;
        short period = (short)(years * TOTAL_MONTH);
        float n = (float) Math.pow((1 + interestRate), period);
        
        double mortgage = (principal * (interestRate * n)) / (n - 1);
        return mortgage;
    }
}