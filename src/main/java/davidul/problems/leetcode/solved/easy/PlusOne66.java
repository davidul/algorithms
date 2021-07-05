package davidul.problems.leetcode.solved.easy;

/**
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Example 3:
 *
 * Input: digits = [0]
 * Output: [1]
 */
public class PlusOne66 {
    public static void main(String[] args) {
        final PlusOne66 plusOne66 = new PlusOne66();
        //plusOne66.plusOne(new int[]{1,2,3});
        plusOne66.plusOne(new int[]{9,9});
    }

    public int[] plusOne(int[] digits) {
        final int lastDigit = digits.length - 1;
        digits = plusOne(digits, lastDigit);
        return digits;
    }

    public int[] plusOne(int [] digits, int pos){
        if(pos == -1){
            int [] newdigits = new int[digits.length + 1];
            System.arraycopy(digits, 0, newdigits, 1, digits.length);
            newdigits[0] = 1;
            return newdigits;
        }
        final int i = digits[pos] + 1;
        if(i > 9){
            digits[pos] = 0;
            digits = plusOne(digits, --pos);
        }else{
            digits[pos] = i;
        }

        return digits;

    }
}
