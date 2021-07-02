package davidul.problems.leetcode.unsolved.easy;

/**
 * Given an integer array nums and an integer k, return true
 * if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 */
public class ContainsDuplicateII219 {
    public static void main(String[] args) {
        final ContainsDuplicateII219 containsDuplicateII219 = new ContainsDuplicateII219();
        System.out.println(containsDuplicateII219.containsNearbyDuplicate(new int[]{1,2,3,1}, 2));
        System.out.println(containsDuplicateII219.containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        System.out.println(containsDuplicateII219.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
        System.out.println(containsDuplicateII219.containsNearbyDuplicate(new int[]{1}, 0));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            for(int x = i+1; x <= i+k && x < nums.length; x++){
                if(nums[i] == nums[x] && Math.abs(i - x) <= k){
                    return true;
                }
            }
        }
        return false;
    }
}