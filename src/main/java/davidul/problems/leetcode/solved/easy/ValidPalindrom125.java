package davidul.problems.leetcode.solved.easy;

public class ValidPalindrom125 {
    public static void main(String[] args) {
        final ValidPalindrom125 validPalindrom125 = new ValidPalindrom125();
        System.out.println(validPalindrom125.isPalindrome("abba"));
        System.out.println(validPalindrom125.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrom125.isPalindrome("abc"));
        System.out.println(validPalindrom125.isPalindrome("aba"));
        System.out.println(validPalindrom125.isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        final char[] chars = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "").toCharArray();
        for(int i = 0, k = chars.length - 1; i < chars.length/2 && k >= chars.length/2; i++, k--){
            if(chars[i] != chars[k])
                return false;
        }
        return true;
    }
}
