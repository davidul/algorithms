package davidul.problems.leetcode.unsolved.medium;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class LongestSubstring3 {
    public static void main(String[] args) {
        final LongestSubstring3 longestSubstring3 = new LongestSubstring3();
       // System.out.println(longestSubstring3.lengthOfLongestSubstring("abcabcbb"));
       // System.out.println(longestSubstring3.lengthOfLongestSubstring("bbbbb"));
       // System.out.println(longestSubstring3.lengthOfLongestSubstring("pwwkew"));
       // System.out.println(longestSubstring3.lengthOfLongestSubstring(""));
      //  System.out.println(longestSubstring3.lengthOfLongestSubstring(" "));
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
