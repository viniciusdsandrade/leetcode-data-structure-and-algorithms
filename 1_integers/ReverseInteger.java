import java.util.Scanner;

public class ReverseInteger {

    /*
    Given a signed 32-bit integer x, return x with its digits reversed.
    If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1],
    then return 0.

    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

    Example 1:
    Input: x = 123
    Output: 321

    Example 2:
    Input: x = -123
    Output: -321

    Example 3:
    Input: x = 120
    Output: 21

    Constraints:
    -2^31 <= x <= 2^31 - 1
    */

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int x = scanner.nextInt();

            long startTime = System.nanoTime();
            int answer = reverse(x);
            long endTime = System.nanoTime();

            System.out.println("Input:  " + x);
            System.out.println("Output: " + answer);
            System.out.println("Execution time: " + (endTime - startTime) + " ns");
            System.out.println("Execution time: " + (endTime - startTime) / 1000000 + " ms");
        }
    }

    public static int reverse(int x) {

        if (x == 0)
            return 0;

        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;

            // Check for overflow
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7))
                return 0;

            // Check for underflow
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8))
                return 0;

            x = x / 10;
            reversed = reversed * 10 + digit;
        }

        return reversed;
    }
}