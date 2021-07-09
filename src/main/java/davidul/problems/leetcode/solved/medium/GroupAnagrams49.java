package davidul.problems.leetcode.solved.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lower-case English letters.
 */
public class GroupAnagrams49 {
    public static void main(String[] args) {
        final GroupAnagrams49 groupAnagrams49 = new GroupAnagrams49();
        final List<List<String>> lists = groupAnagrams49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            final char[] v = strs[i].toCharArray();
            Arrays.sort(v);
            final String s = new String(v);
            if(map.containsKey(s)) {
                final List<String> strings = map.get(s);
                strings.add(strs[i]);
                map.put(s, strings);
            }else{
                List<String> lst = new ArrayList<>();
                lst.add(strs[i]);
                map.put(s, lst);
            }
        }
        List<List<String>> lstOfLst = new ArrayList<>();
        for (String s : map.keySet()) {
            final List<String> strings = map.get(s);
            lstOfLst.add(strings);
        }
        return lstOfLst;
    }
}
