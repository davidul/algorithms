package davidul.problems.leetcode.solved.easy;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs70 {
    public static void main(String[] args) {
        final ClimbingStairs70 climbingStairs70 = new ClimbingStairs70();
        System.out.println(climbingStairs70.climbStairs(10));

    }

    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        final int[] ints = new int[n];
        ints[0] = 1;
        ints[1] = 2;
        for(int i = 2; i < n; i++){
            ints[i] = ints[i-1] + ints[i-2];
        }
        return ints[n-1];
    }
}