package davidul.problems.leetcode.solved.easy;

import java.util.Arrays;

/**
 * You have some apples, where arr[i] is the weight of the i-th apple.  You also have a basket that can carry up to 5000 units of weight.
 *
 * Return the maximum number of apples you can put in the basket.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [100,200,150,1000]
 * Output: 4
 * Explanation: All 4 apples can be carried by the basket since their sum of weights is 1450.
 * Example 2:
 *
 * Input: arr = [900,950,800,1000,700,800]
 * Output: 5
 * Explanation: The sum of weights of the 6 apples exceeds 5000 so we choose any 5 of them.
 */
public class Apples1196 {
    public static void main(String[] args) {
        System.out.println(new Apples1196().maxNumberOfApples(new int[]{100,200,150,1000}));
        System.out.println(new Apples1196().maxNumberOfApples(new int[]{900,950,800,1000,700,800}));
    }

    /**
     * Solution:
     * Sort array, then sum up until the threshold and count number of elements.
     * @param arr
     * @return
     */
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        int apples = 0;
        for(int i = 0; i < arr.length && sum + arr[i] <= 5000; i++){
            apples++;
            sum += arr[i];
        }
        return apples;
    }
}
