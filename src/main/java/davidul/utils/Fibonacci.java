package davidul.utils;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private static final Map<Integer, Integer> memo = new HashMap<>();

    /**
     * Memoized Fibonacci number
     * @param n n-th F-number
     * @return Fibonacci number
     */
    public static int fib(int n){
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        if(n <= 2) return 1;
        memo.put(n, fib(n-2) + fib(n-1));
        return memo.get(n);
    }
}
