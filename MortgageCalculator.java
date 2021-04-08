import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        final byte PARCENTAGE = 100;
        final byte TOTAL_MONTH = 12;
        Scanner input = new Scanner(System.in);

        int principal;
        float annualInterest;
        float interestRate;
        short years;
        int period;
        float mortgage;
        float n;

        while (true) {
            System.out.print("Principal (1K - 1M): ");
            principal = input.nextInt();
            if(principal >= 1000 && principal <= 1000000)
                break;
            else
             System.out.println("Please enter a number between 1000 and 1,000,000.");
            }
            
        while (true) {
            System.out.print("Interest Rate: ");
            annualInterest = input.nextFloat();
            if(annualInterest >= 1 && annualInterest <= 30){
                interestRate = annualInterest / PARCENTAGE / TOTAL_MONTH;
                break;
            }
            else
                System.out.println("Please enter a value greater than 0 and not more than 30.");
        }

        while (true) {
            System.out.print("Period (Years): ");
            years = input.nextShort();
            if(years >= 1 && years <= 30){
                period = years * TOTAL_MONTH;
                break;
            }
            else
                System.out.println("Year must be 1 to 30.");
        }

        n = (float) Math.pow((1 + interestRate), period);

        mortgage = (principal * (interestRate * n)) / (n - 1);
        System.out.printf("Mortgage: %.2f", mortgage);
    }
}