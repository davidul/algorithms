package davidul.problems.leetcode.solved.easy;

import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 * Example 4:
 *
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 *
 * Input: s = "{[]}"
 * Output: true
 */
public class ValidParentheses20 {
    public static void main(String[] args) {
        final ValidParentheses20 validParentheses20 = new ValidParentheses20();
        System.out.println(validParentheses20.isValid("()"));
        System.out.println(validParentheses20.isValid("()[]{}"));
        System.out.println(validParentheses20.isValid("(]"));
        System.out.println(validParentheses20.isValid("([)]"));
        System.out.println(validParentheses20.isValid("{[]}"));
        System.out.println(validParentheses20.isValid("]"));
        System.out.println(validParentheses20.isValid("([]){"));
        List.of("1", "2").equals(List.of("1", "2"));
        Set.of("1","2").equals(Set.of("2","1"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        final char[] chars = s.toCharArray();
        boolean isValid = false;
        for(int i = 0; i < chars.length; i++) {
            final char aChar = chars[i];
            if(aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(chars[i]);
            }else {
                if(stack.isEmpty()){
                    isValid = false;
                    break;
                }
                final Character pop = stack.pop();
                if(pop == '(' && aChar == ')'){
                    isValid = true;
                }else if(pop == '[' && aChar == ']'){
                    isValid = true;
                }else if(pop == '{' && aChar == '}'){
                    isValid = true;
                }else {
                    isValid = false;
                    break;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return isValid;
    }
}
