package org.algorithmsAndDataStructures.stack;
// https://leetcode.com/problems/valid-parentheses/

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        var open = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                open.push(c);
            }
            else if (c == ')' || c == '}' || c == ']') {
                if (open.isEmpty()) return false;

                char parenthesis = open.pop();

                if ((parenthesis == '(' && c != ')')
                        || (parenthesis == '{' && c != '}')
                        || (parenthesis == '[' && c != ']')) {
                    return false;
                }
            }
        }

        return open.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("(]"));
    }
}
