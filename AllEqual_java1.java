package com.example.allequal;
import java.util.Scanner;
public class AllEqual_java1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt the user for three integers
            System.out.println("Enter the first integer:");
            int num1 = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter the second integer:");
            int num2 = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter the third integer:");
            int num3 = Integer.parseInt(scanner.nextLine());

            // Check if all three integers are equal
            if (num1 == num2 && num2 == num3) {
                System.out.println("equal");
            } else {
                System.out.println("not equal");
            }

        } catch (NumberFormatException e) {
            // Handle non-integer inputs
            System.out.println("Invalid input");
        }
    }
}