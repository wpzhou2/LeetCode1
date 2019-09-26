package LeetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Author: weipeng
 * @Date: 2019/5/15  19:59
 * @Description:
 **/
public class LC_20_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<Character>();
        set.add('(');
        set.add('[');
        set.add('{');

        for (char c : chars) {
            if (set.contains(c)) {
                stack.push(c);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                if (isMatch(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    public boolean isMatch(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }


    //第二种做法
    public boolean isValid1(String s) {
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s.replace("()", "");
            s.replace("[]", "");
            s.replace("{}", "");
        }
        return s.length() == 0;
    }
}
