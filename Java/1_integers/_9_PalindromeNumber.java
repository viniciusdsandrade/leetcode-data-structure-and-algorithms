import java.util.Scanner;

public class _9_PalindromeNumber {

    /*
    9. Given an integer, return true if it is a palindrome integer, and false otherwise.
    
    Example 1:
    Input: x = 121
    Output: true
    
    Example 2:
    Input: x = -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
    
    Example 3:
    Input: x = 10
    Output: false

    Constraints:
    -2^31 <= x <= 2^31 - 1
    */

    public static void main(String[] args) {
        // Teste 1
        testIsPalindrome(121);

        // Teste 2
        testIsPalindrome(-121);

        // Teste 3
        testIsPalindrome(10);
    }

    private static void testIsPalindrome(int x) {
        try {
            long startTime = System.nanoTime();
            boolean answer = isPalindrome(x);
            long endTime = System.nanoTime();

            System.out.println("\nInput:  " + x);
            System.out.printf("Answer: %b\n", answer);
            System.out.println("Execution time: " + (endTime - startTime) + " ns");
            System.out.printf("Execution time: %.5f ms\n", (endTime - startTime) / 1_000_000.0);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isPalindrome(int x) {

        // Se o número for negativo, não é palíndromo
        if (x < 0)
            return false;

        // Se o número for 0, é palíndromo
        if (x != 0 && x % 10 == 0)
            return false;

        // Converter o número para string
        String s = Integer.toString(x);

        // Percorrer a string e verificar se o primeiro caractere é igual ao último, o segundo ao penúltimo, e assim por diante
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }

        return true;
    }
}