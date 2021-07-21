package davidul.problems.leetcode.solved.medium;

import java.util.HashSet;
import java.util.Set;

/**
 *Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 * Example 3:
 *
 * Input: s = "a"
 * Output: "a"
 * Example 4:
 *
 * Input: s = "ac"
 * Output: "a"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters (lower-case and/or upper-case),
 */
public class LongestSubstring3 {
    public static void main(String[] args) {
        final LongestSubstring3 longestSubstring3 = new LongestSubstring3();
        System.out.println(longestSubstring3.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestSubstring3.lengthOfLongestSubstring("bbbbb"));
        System.out.println(longestSubstring3.lengthOfLongestSubstring("pwwkew"));
        System.out.println(longestSubstring3.lengthOfLongestSubstring(""));
        System.out.println(longestSubstring3.lengthOfLongestSubstring(" "));
        System.out.println(longestSubstring3.lengthOfLongestSubstring("jbpnbwwd"));
    }

    public int lengthOfLongestSubstring(String s) {
        final char[] chars = s.toCharArray();
        Set<Character> stringSet = new HashSet<>();
        int lengthOfSubstring = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int k = i; k < chars.length; k++) {
                if (stringSet.contains(chars[k])) {
                    if (stringSet.size() > lengthOfSubstring) {
                        lengthOfSubstring = stringSet.size();
                    }
                    stringSet.clear();
                    break;
                } else {
                    stringSet.add(chars[k]);
                }
            }
        }
        return lengthOfSubstring == 0 ? stringSet.size() : lengthOfSubstring;
    }
}
