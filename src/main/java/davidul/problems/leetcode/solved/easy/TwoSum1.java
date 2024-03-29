package davidul.problems.leetcode.solved.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class TwoSum1 {
    public static void main(String[] args) {
        final TwoSum1 twoSum1 = new TwoSum1();
        twoSum1.twoSum(new int[]{2, 7, 11, 15}, 9);
        twoSum1.twoSum(new int[]{3, 2, 4}, 6);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        //Arrays.sort(nums);
        Map<Integer, Integer> s = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            s.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            final int second = target - nums[i];
            if (s.containsKey(second)) {
                final Integer integer = s.get(second);
                if (integer != i) {
                    result[0] = i;
                    result[1] = integer;
                    return result;
                }
            }
        }
        return result;
    }
}
