package davidul.problems.leetcode.solved.medium;

/**
 *
 * A peak element is an element that is strictly greater than its neighbors.
 *
 * Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * nums[i] != nums[i + 1] for all valid i.
 *
 *
 * Follow up: Could you implement a solution with logarithmic complexity?
 */
public class FindPeakElements162 {
    public static void main(String[] args) {
        final FindPeakElements162 findPeakElements162 = new FindPeakElements162();
        System.out.println(findPeakElements162.findPeakElement(new int[]{1}));
        System.out.println(findPeakElements162.linearScan(new int[]{1}));
        System.out.println(findPeakElements162.findPeakElement(new int[]{1,2}));
        System.out.println(findPeakElements162.linearScan(new int[]{1,2}));
        System.out.println(findPeakElements162.findPeakElement(new int[]{1,2,3,1}));
        System.out.println(findPeakElements162.linearScan(new int[]{1,2,3,1}));
        System.out.println(findPeakElements162.findPeakElement(new int[]{1,2,1,3,5,6,4}));
        System.out.println(findPeakElements162.linearScan(new int[]{1,2,1,3,5,6,4}));
        System.out.println(findPeakElements162.linearScan(new int[]{1,2,1,3,5,6,4,3,2,1}));
        System.out.println(findPeakElements162.findPeakElement(new int[]{1,2,1,3,5,6,4,3,2,1}));
        System.out.println(findPeakElements162.linearScan(new int[]{1,1,1,1,1,1,1,1,2,1}));
        System.out.println(findPeakElements162.findPeakElement(new int[]{1,1,1,1,1,1,1,1,2,1}));
    }

    public int linearScan(int [] nums){
        int left = 0;
        int right = 0;
        int middle = 0;
        for(int i = 0; i < nums.length; i++){
            if(i - 1 < 0){
                left = Integer.MIN_VALUE;
            }else {
                left = nums[i - 1];
            }

            if(i + 1 > nums.length - 1){
                right = Integer.MIN_VALUE;
            }else {
                right = nums[i+1];
            }
            if(left < nums[i] && nums[i] > right){
                return i;
            }
        }

        return 0;
    }

    public int linearScan(int [] nums, int start, int end){
        int left = 0;
        int right = 0;
        int middle = 0;
        for(int i = start; i <= end; i++){
            if(i - 1 < 0){
                left = Integer.MIN_VALUE;
            }else {
                left = nums[i - 1];
            }

            if(i + 1 > nums.length - 1){
                right = Integer.MIN_VALUE;
            }else {
                right = nums[i+1];
            }
            if(left < nums[i] && nums[i] > right){
                return i;
            }
        }
        return -1;
    }

    public int findPeakElement(int[] nums) {
        final int length = nums.length;
        if(length <= 3){
            return linearScan(nums);
        }

        final int i = length / 2;
        final int peakElement = findPeakElement(nums, 0, i - 1);//0..i 0..10
        if(peakElement != -1){
            return peakElement;
        }
        return findPeakElement(nums, i, nums.length-1);
    }

    //1 2 3 4
    //1 2   3 4
    public int findPeakElement(int[] nums, int start, int end){
        final int length = end - start;
        if(length <= 3){
            return linearScan(nums, start, end);
        }else{
            final int peakElement = findPeakElement(nums, start, start + (end - start) / 2);
            if(peakElement != -1){
                return peakElement;
            }
            return findPeakElement(nums, start + (end-start)/2, end);
        }
    }
}
