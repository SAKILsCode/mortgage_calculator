import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args){
        final byte parcentage = 100;
        final byte totalMonths = 12;
        Scanner input = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = input.nextInt();

        System.out.print("Interest Rate: ");
        float interestRate = (float)input.nextDouble();

        interestRate = interestRate/parcentage/totalMonths;
        System.out.print("Period (Years): ");
        byte years = input.nextByte();
        int period = years * totalMonths;

        float n = (float)Math.pow((1+interestRate), period);
        
        float mortgage = (principal * (interestRate * n))/(n-1);
        System.out.printf("Mortgage: %.2f", mortgage);
    }
}