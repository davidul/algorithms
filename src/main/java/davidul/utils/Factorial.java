package davidul.utils;

import java.util.HashMap;
import java.util.Map;

public class Factorial {

    private static Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        final Factorial factorial = new Factorial();
    }

    public static long factMemoized(long n){
        if(n == 0)
            return 1;

        if(n == 1)
            return 1;

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        memo.put(n, n* Factorial.factMemoized(n-1));
        return memo.get(n);
    }

    public static long factorial(long n){
        if(n == 0)
            return 1;

        if(n == 1)
            return 1;

        return n*factorial(n-1);
    }

    public static int factorial(int n){
        if(n == 0)
            return 1;

        if(n == 1)
            return 1;

        return n*factorial(n-1);
    }
}
