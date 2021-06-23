package davidul.problems.leetcode.solved.easy;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */
public class ReverseString344 {
    public static void main(String[] args) {
        final ReverseString344 reverseString344 = new ReverseString344();
        char[] chars = {'a', 'b', 'c'};
        reverseString344.reverseString(chars);
        chars = new char[]{'h','e','l','l','o'};
        reverseString344.reverseString(chars);
        chars = new char[]{'H','a','n','n','a','h'};
        reverseString344.reverseString(chars);

    }

    // a b c d
    //a b c
    public void reverseString(char[] s) {
        for(int i = 0, k = s.length - 1; i < s.length/2 && k >= s.length/2; i++, k--){
            final char c = s[i];
            s[i] = s[k];
            s[k] = c;
        }
    }
}
