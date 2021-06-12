package davidul.problems.leetcode.unsolved.easy;

import java.util.Arrays;

public class Apples1196 {
    public static void main(String[] args) {
        System.out.println(new Apples1196().maxNumberOfApples(new int[]{100,200,150,1000}));
        System.out.println(new Apples1196().maxNumberOfApples(new int[]{900,950,800,1000,700,800}));
    }

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
