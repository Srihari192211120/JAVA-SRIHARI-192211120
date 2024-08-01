import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
public class MaxNum_java4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the array elements (separated by spaces):");
        String input = scanner.nextLine();
        String[] tokens = input.split("\\s+");
        Integer[] array = new Integer[tokens.length];
        try {
            for (int i = 0; i < tokens.length; i++) {
                array[i] = Integer.parseInt(tokens[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in the input.");
            return;
        }

        System.out.println("Enter the value of M (for Mth maximum):");
        int M = readPositiveInteger(scanner);

        System.out.println("Enter the value of N (for Nth minimum):");
        int N = readPositiveInteger(scanner);

        if (M <= 0 || M > array.length || N <= 0 || N > array.length) {
            System.out.println("Invalid input for M or N.");
            return;
        }
        Integer[] sortedArrayDescending = array.clone();
        Arrays.sort(sortedArrayDescending, Collections.reverseOrder());
        int MthMax = sortedArrayDescending[M - 1];
        Integer[] sortedArrayAscending = array.clone();
        Arrays.sort(sortedArrayAscending);
        int NthMin = sortedArrayAscending[N - 1];
        int sum = MthMax + NthMin;
        int difference = MthMax - NthMin;
        System.out.println("Mth maximum number: " + MthMax);
        System.out.println("Nth minimum number: " + NthMin);
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
    }

    private static int readPositiveInteger(Scanner scanner) {
        while (true) {
            try {
                int value = scanner.nextInt();
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Please enter a positive integer:");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer:");
                scanner.next();
            }
        }
    }
}
