package davidul.problems.leetcode.solved;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 *
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray53 {
    public static void main(String[] args) {
        final MaximumSubarray53 maximumSubarray53 = new MaximumSubarray53();
        System.out.println("K: " + maximumSubarray53.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println("BF:" + maximumSubarray53.bruteForce(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println("DQ:" + maximumSubarray53.divideAndConquer(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println("K: " + maximumSubarray53.maxSubArray(new int[]{1}));
        System.out.println("BF:" + maximumSubarray53.bruteForce(new int[]{1}));
        System.out.println("DQ:" + maximumSubarray53.divideAndConquer(new int[]{1}));
        System.out.println("K: " + maximumSubarray53.maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println("BF:"+ maximumSubarray53.bruteForce(new int[]{5,4,-1,7,8}));
        System.out.println("DQ:"+ maximumSubarray53.divideAndConquer(new int[]{5,4,-1,7,8}));
    }

    //Kadane
    public int maxSubArray(int[] nums) {
        int maxGlobal = nums[0];
        int maxCurrent = nums[0];

        for(int i = 1; i < nums.length; i++){
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            if(maxCurrent > maxGlobal) maxGlobal = maxCurrent;
        }
        return maxGlobal;
    }

    public int bruteForce(int [] nums){
        int max;
        int globalMax = nums[0];
        for(int i = 0; i < nums.length; i++){
            max = nums[i];
            for(int k = i+1; k < nums.length; k++) {
                max = max + nums[k];
                if (max > globalMax) {
                    globalMax = max;
                }
            }
        }
        return globalMax;
    }

    public int divideAndConquer(int [] nums){
        return bestSum(nums, 0, nums.length);
    }

    private int bestSum(int [] nums, int a, int b){
        int middle = a + b / 2;
        int max = 0;
        int bestLeft = 0;
        int bestRight = 0;
        for(int i = middle - 1; i >= a ; i--){
            max = max + nums[i];
            bestLeft = Math.max(max, bestLeft);
        }

        max = 0;
        for(int i = middle + 1; i < b; i++){
            max = max + nums[i];
            bestRight = Math.max(max, bestRight);
        }

        return nums[middle] + bestLeft + bestRight;
    }
}
