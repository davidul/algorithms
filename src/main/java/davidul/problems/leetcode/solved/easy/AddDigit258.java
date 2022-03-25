package davidul.problems.leetcode.solved.easy;

/**
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 38
 * Output: 2
 * Explanation: The process is
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * Since 2 has only one digit, return it.
 */
public class AddDigit258 {

    public static void main(String[] args) {
        AddDigit258 addDigit258 = new AddDigit258();
        System.out.println(addDigit258.addDigits(256));
        System.out.println(addDigit258.addDigitsShort(256));
    }

    public int addDigits(int num) {
        if(num == 0)
            return 0;

        int res = 0;
        do {
            while (num > 0) {
                res += num % 10;
                num = num / 10;
            }
            num = res;
            res = 0;
        }while (num > 9);

        return num;
    }

    public int addDigitsShort(int num){
        if(num == 0) return 0;
        if(num % 9 == 0) return 9;
        return num % 9;
    }
}
