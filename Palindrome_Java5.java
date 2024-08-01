import java.util.Scanner;
public class Palindrome_Java5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer:");
        int number = scanner.nextInt();
        if (isPalindrome(number)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }
    public static boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }
        String numStr = Integer.toString(number);
        String reversedStr = new StringBuilder(numStr).reverse().toString();
        return numStr.equals(reversedStr);
    }
}