package davidul.problems.leetcode.solved.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * Example 4:
 *
 * Input: s = "  Bob    Loves  Alice   "
 * Output: "Alice Loves Bob"
 * Example 5:
 *
 * Input: s = "Alice does not even like bob"
 * Output: "bob like even not does Alice"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 * There is at least one word in s.
 */
public class ReverseWordsInAString151 {

    public static void main(String[] args) {
        final ReverseWordsInAString151 reverseWordsInAString151 = new ReverseWordsInAString151();
        reverseWordsInAString151.reverseWords("the sky is blue");
        reverseWordsInAString151.reverseWords("  hello world  ");
        reverseWordsInAString151.reverseWords("  Bob    Loves  Alice   ");
    }

    public String reverseWords(String s) {
        final String trim = s.trim();
        final String[] s1 = trim.split(" ");
        List<String> fin = new ArrayList<>();
        for(int i = 0; i < s1.length; i++){
            if(s1[i].length() > 0){
                fin.add(s1[i]);
            }
        }
        final String[] strings = fin.toArray(new String[0]);
        StringBuffer sb = new StringBuffer();
        for(int i = strings.length - 1; i >= 0; i--){
            sb.append(strings[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
