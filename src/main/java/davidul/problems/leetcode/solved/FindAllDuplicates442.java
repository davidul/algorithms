package davidul.problems.leetcode.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 *
 * Example 2:
 *
 * Input: nums = [1,1,2]
 * Output: [1]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: []
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * Each element in nums appears once or twice.
 *
 *
 * Follow up: Could you do it without extra space and in O(n) runtime?
 */
public class FindAllDuplicates442 {
    public static void main(String[] args) {
        final FindAllDuplicates442 findAllDuplicates442 = new FindAllDuplicates442();
        List<Integer> integers = findAllDuplicates442.bruteForce(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        for(Integer i : integers){
            System.out.println(i);
        }

        integers = findAllDuplicates442.sortAndCompare(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        for(Integer i : integers){
            System.out.println(i);
        }
    }

    public List<Integer> bruteForce(int [] a){
        List<Integer> lst = new ArrayList<>();
        for(int i = 0; i < a.length; i++){
            for(int k = i + 1; k < a.length; k++){
                if(a[i] == a[k]){
                    lst.add(a[i]);
                }
            }
        }
        return lst;
    }

    public List<Integer> sortAndCompare(int [] a){
        List<Integer> lst = new ArrayList<>();
        Arrays.sort(a);
        for(int i = 0; i < a.length - 1; i++){
            if(a[i] == a[i+1]){
                lst.add(a[i]);
            }
        }

        return lst;
    }
}
