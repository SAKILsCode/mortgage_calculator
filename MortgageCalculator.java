import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    final static byte PARCENTAGE = 100;
    final static byte TOTAL_MONTH = 12;

    public static void main(String[] args) {
        int principal = (int)getInput("Principal (1K - 1M): ", 1000, 1000000);
        float annualInterest = (float)getInput("Annual Interest Rate: ", 1, 30);
        byte years = (byte)getInput("Period (Years): ", 1, 30);

        printPaymentSchedule(principal, annualInterest, years);
        printMortgage(principal, annualInterest, years);
    }

    private static void printMortgage(int principal, float annualInterest, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for(short month = 0; month <= years * TOTAL_MONTH; month++) {
            double balance = remainingBalance(principal, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    private static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        double mortgage = mortgageCal(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    public static double remainingBalance(int principal, float annualInterest, byte years, short numberOfPaymentsMade){
        float monthlyInterest = annualInterest / PARCENTAGE / TOTAL_MONTH;
        short period = (short)(years * TOTAL_MONTH);

        float a = (float)Math.pow((1 + monthlyInterest), period);
        float b = (float)Math.pow((1 + monthlyInterest), numberOfPaymentsMade);

        double balance = (principal * (a-b))/(a - 1);
        return balance;
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
        float monthlyInterest = annualInterest / PARCENTAGE / TOTAL_MONTH;
        short period = (short)(years * TOTAL_MONTH);
        float n = (float) Math.pow((1 + monthlyInterest), period);

        double mortgage = (principal * (monthlyInterest * n)) / (n - 1);
        return mortgage;
    }
}