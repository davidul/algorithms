package davidul.problems.leetcode.solved.easy;

/**
 *Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Example 4:
 *
 * Input: x = -101
 * Output: false
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 */
public class PalindromeNumber9 {
    public static void main(String[] args) {
        final PalindromeNumber9 palindromeNumber9 = new PalindromeNumber9();
        System.out.println(palindromeNumber9.isPalindrome(121));
        System.out.println(palindromeNumber9.isPalindrome(123));
        System.out.println(palindromeNumber9.isPalindrome(-101));
    }

    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        return x == reverse(x);
    }

    public int reverse(int x) {
        int rev = 0;
        while(x != 0) {
            int pop = x % 10;
            x = x / 10;

            if(rev > Integer.MAX_VALUE/10 || rev < Integer.MIN_VALUE/10){
                return 0;
            }
            rev = rev * 10 + pop;
        }

        return rev;
    }
}
