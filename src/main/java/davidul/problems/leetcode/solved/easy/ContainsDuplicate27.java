package davidul.problems.leetcode.solved.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class ContainsDuplicate27 {
    public static void main(String[] args) {
        final ContainsDuplicate27 containsDuplicate27 = new ContainsDuplicate27();
        containsDuplicate27.containsDuplicate(new int[]{1,2,3,1});
    }

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            final Integer v = map.computeIfPresent(nums[i], (key, value) -> ++value);
            map.putIfAbsent(nums[i], 1);
            if(v != null && v > 1){
                return true;
            }
        }

        return false;
    }
}
