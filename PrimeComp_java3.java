import java.util.Scanner;
public class PrimeComp_java3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers (separated by spaces):");
        String input = scanner.nextLine();

        if (input.trim().isEmpty()) {
            System.out.println("Number of prime numbers: 0");
            System.out.println("Number of composite numbers: 0");
            return;
        }

        String[] tokens = input.split("\\s+");
        int primeCount = 0;
        int compositeCount = 0;

        for (String token : tokens) {
            try {
                int num = Integer.parseInt(token);
                if (num > 1) {
                    if (isPrime(num)) {
                        primeCount++;
                    } else {
                        compositeCount++;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Ignoring non-integer input: " + token);
            }
        }

        System.out.println("Number of prime numbers: " + primeCount);
        System.out.println("Number of composite numbers: " + compositeCount);
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
