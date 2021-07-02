package davidul.problems.leetcode.unsolved.easy;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 * Example 4:
 *
 * Input: x = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 */
public class ReverseInteger7 {
    public static void main(String[] args) {
        final ReverseInteger7 reverseInteger7 = new ReverseInteger7();
        reverseInteger7.reverse(1463847412);
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
