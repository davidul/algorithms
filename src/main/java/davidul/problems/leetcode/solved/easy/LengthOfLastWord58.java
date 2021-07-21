package davidul.problems.leetcode.solved.easy;

/**
 * Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.
 *
 * A word is a maximal substring consisting of non-space characters only.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Hello World"
 * Output: 5
 * Example 2:
 *
 * Input: s = " "
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of only English letters and spaces ' '.
 */
public class LengthOfLastWord58 {
    public static void main(String[] args) {
        final LengthOfLastWord58 lengthOfLastWord58 = new LengthOfLastWord58();
        System.out.println(lengthOfLastWord58.lengthOfLastWord("Hello Word"));
        System.out.println(lengthOfLastWord58.lengthOfLastWord("Hello Word xxx"));
        System.out.println(lengthOfLastWord58.lengthOfLastWord("Hello"));
        System.out.println(lengthOfLastWord58.lengthOfLastWord(" "));
        System.out.println(lengthOfLastWord58.lengthOfLastWord("   "));
    }

    public int lengthOfLastWord(String s) {
        if(s.length() == 0)
            return 0;

        final String[] s1 = s.split(" ");
        if(s1.length == 0){
            return 0;
        }

        if(s1.length > 1){
            return s1[s1.length - 1].length();
        }else{
            final char[] chars = s1[0].toCharArray();
            boolean onlySpace = true;
            for(int i = 0; i < chars.length; i++){
                if(chars[i] != ' ')
                    onlySpace = false;
            }

            if(onlySpace)
                return 0;
            else
                return s1[0].length();


        }

    }
}
