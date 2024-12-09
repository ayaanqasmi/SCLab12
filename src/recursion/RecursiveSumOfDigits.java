package recursion;
/**
 * A program to calculate the sum of the digits of a given integer using recursion.
 * 
 * Specifications:
 * - Takes a non-negative or negative integer as input.
 * - Implements a recursive function `sumOfDigits` to calculate the digit sum.
 * - Handles edge cases such as 0 and large integers.
 * - Converts negative numbers to positive before processing.
 * - Analyzes time complexity as O(d), where d is the number of digits in the number.
 * - Includes proper error handling and modular code.
 */

import java.util.Scanner;

public class RecursiveSumOfDigits {

    /**
     * Recursively calculates the sum of digits of a number.
     * Converts negative numbers to positive before calculation.
     * 
     * @param number The input integer.
     * @return The sum of the digits of the absolute value of the input integer.
     */
    public static int sumOfDigits(int number) {
        // Convert negative numbers to positive
        if (number < 0) {
            number = -number;
        }

        // Base case: if the number is reduced to 0, return 0
        if (number == 0) {
            return 0;
        }

        // Recursive case: add the last digit and call the function on the rest
        return (number % 10) + sumOfDigits(number / 10);
    }

    /**
     * Main method to take user input and display the sum of digits.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer:");
        int inputNumber = scanner.nextInt();

        // Calculate and display the sum of digits
        int result = sumOfDigits(inputNumber);
        System.out.println("The sum of the digits is: " + result);

        scanner.close();
    }
}
