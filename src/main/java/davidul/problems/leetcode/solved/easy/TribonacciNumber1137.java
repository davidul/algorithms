package davidul.problems.leetcode.solved.easy;

/**
 * The Tribonacci sequence Tn is defined as follows:
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * Example 2:
 *
 * Input: n = 25
 * Output: 1389537
 *
 * Constraints:
 *
 * 0 <= n <= 37
 * The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
 */
public class TribonacciNumber1137 {
    public static void main(String[] args) {
        final TribonacciNumber1137 tribonacciNumber1137 = new TribonacciNumber1137();
        //System.out.println(tribonacciNumber1137.tribonacci(4));
        //System.out.println(tribonacciNumber1137.tribonacci(25));
        //System.out.println(tribonacciNumber1137.tribonacci(37));
        System.out.println(tribonacciNumber1137.tribonacci_1(4));
        System.out.println(tribonacciNumber1137.tribonacci_1(25));
        System.out.println(tribonacciNumber1137.tribonacci_1(37));
    }

    private static int[] memo = new int[38];

    public int tribonacci(int n) {
        if(n <= 0) return 0;
        if(n == 1 || n == 2 ) return 1;

        return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
    }

    public int tribonacci_1(int n){
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;

        for(int i = 3; i < 38; i++){
            memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
        }

        return memo[n];
    }
}
