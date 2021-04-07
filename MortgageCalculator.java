import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        final byte PARCENTAGE = 100;
        final byte TOTAL_MONTH = 12;
        Scanner input = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = input.nextInt();

        while (principal < 0) {
            System.out.println("Please enter a positive decimal number_ ");
            principal = input.nextInt();
        }

        System.out.print("Interest Rate: ");
        float annualInterest = input.nextFloat();
        while (annualInterest < 0) {
            System.out.println("Please enter a valid Interest Rate_ ");
            annualInterest = input.nextFloat();
        }

        float interestRate = annualInterest / PARCENTAGE / TOTAL_MONTH;
        System.out.print("Period (Years): ");
        short years = input.nextShort();
        while (years < 0 || years > 30) {
            System.out.println("Year must be positive decimal number and not more than 30 ");
            years = input.nextShort();
        }
        int period = years * TOTAL_MONTH;

        float n = (float) Math.pow((1 + interestRate), period);

        float mortgage = (principal * (interestRate * n)) / (n - 1);
        System.out.printf("Mortgage: %.2f", mortgage);
    }
}