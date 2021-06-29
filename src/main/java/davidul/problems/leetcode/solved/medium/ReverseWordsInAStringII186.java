package davidul.problems.leetcode.solved.medium;

/**
 * Given a character array s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.
 *
 * Your code must solve the problem in-place, i.e. without allocating extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: s = ['t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e']
 * Output: ['b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e']
 * Example 2:
 *
 * Input: s = ['a']
 * Output: ['a']
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is an English letter (uppercase or lowercase), digit, or space ' '.
 * There is at least one word in s.
 * s does not contain leading or trailing spaces.
 * All the words in s are guaranteed to be separated by a single space.
 */
public class ReverseWordsInAStringII186 {
    public static void main(String[] args) {
        final ReverseWordsInAStringII186 reverseWordsInAStringII186 = new ReverseWordsInAStringII186();
        reverseWordsInAStringII186.reverseWords(new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'});
        reverseWordsInAStringII186.reverseWords(new char[]{'a'});
    }

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);

        int separator = 0;
        for(int i = 0; i < s.length; i++){
            if(s[i] == ' '){
                reverse(s, separator, i - 1);
                separator = i + 1;
            }
        }
        reverse(s, separator, s.length-1);
    }

    private void reverse(char [] s, int start, int end){
        int left = start;
        int right = end;
        while (left < right){
            final char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
