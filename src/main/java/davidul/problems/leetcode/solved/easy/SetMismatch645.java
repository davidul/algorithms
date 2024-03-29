package davidul.problems.leetcode.solved.easy;

import java.util.Arrays;

/**
 * You have a set of integers s, which originally contains all the numbers from 1 to n.
 * Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 *
 * You are given an integer array nums representing the data status of this set after the error.
 *
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 */
public class SetMismatch645 {
    public static void main(String[] args) {
        final SetMismatch645 setMismatch645 = new SetMismatch645();
        System.out.println(setMismatch645.findErrorNums(new int[] {1,2,2,4}));
        System.out.println(setMismatch645.findErrorNums(new int[] {1,2,2,3}));
        System.out.println(setMismatch645.findErrorNums(new int[] {1,1}));
        System.out.println(setMismatch645.findErrorNums(new int[] {2,2}));
        System.out.println(setMismatch645.findErrorNums(new int[] {1,2,4,4}));
        System.out.println(setMismatch645.findErrorNums(new int[] {3,2,3,4,6,5}));
        System.out.println(setMismatch645.findErrorNums(new int[] {1,5,3,2,2,7,6,4,8,9}));
    }

    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int [] result = new int[]{-1,-1};
        result[0] = duplicate(nums);
        result[1] = missing(nums);
        return result;
    }

    private int missing(int [] nums){
        for(int i = 0; i < nums.length; i++){
            if(!find(i + 1, nums))
                return i + 1;
        }
        return 0;
    }

    private boolean find(int n, int [] nums){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == n){
                return true;
            }
        }
        return false;
    }


    private int duplicate(int [] nums){
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }

}
