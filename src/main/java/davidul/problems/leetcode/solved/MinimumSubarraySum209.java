package davidul.problems.leetcode.solved;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
 * of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * *
 * <p>
 * Example 1:
 * <p>
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 * <p>
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 * <p>
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * <p>
 * <p>
 * Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 * Accepted
 */
public class MinimumSubarraySum209 {
    public static void main(String[] args) {
        final MinimumSubarraySum209 minimumSubarraySum209 = new MinimumSubarraySum209();
        System.out.println(minimumSubarraySum209.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minimumSubarraySum209.minSubArrayLen_1(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minimumSubarraySum209.minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minimumSubarraySum209.minSubArrayLen_1(4, new int[]{1, 4, 4}));
        System.out.println(minimumSubarraySum209.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(minimumSubarraySum209.minSubArrayLen_1(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int count = 0;
        int elements = 0;
        int minElements = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            for (int k = i; k < nums.length; k++) {
                count = count + nums[k];
                elements++;
                if (count >= target) {
                    count = 0;
                    if (minElements > elements) {
                        minElements = elements;
                        elements = 0;
                        break;
                    }

                    if (elements >= minElements) {
                        elements = 0;
                        break;
                    }
                }
            }
        }
        if (nums.length + 1 == minElements)
            return 0;
        return minElements;
    }

    //2,3,1,2,4,3
    //0 -> 2 + 3 + 1 + 2
    //1 ->     3 + 1 + 2 + 4
    //2 ->         1 + 2 + 4
    //3 ->             2 + 4 + 3
    //4 ->                 4 + 3
    //5 ->                     3
    public int minSubArrayLen_1(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int count = Integer.MAX_VALUE;
        int sum = 0;
        while(right < nums.length || sum >= target){
            if(sum < target && right < nums.length){
                sum = sum + nums[right];
                right++;
            }else if(sum >= target){
                count = Math.min(right - left, count);
                sum = sum - nums[left];
                left++;
            }
        }

        return count == Integer.MAX_VALUE ? 0 : count;
    }
}
