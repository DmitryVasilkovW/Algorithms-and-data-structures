package org.algorithmsAndDataStructures.Backtracking;
// https://leetcode.com/problems/generate-parentheses/description/

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        var result = new ArrayList<String>();

        dfs(result, n, 0, 0, "");

        return result;
    }

    public void dfs(List<String> parenthesis, int n, int left, int right, String str) {
        if (left == right && left + right == n * 2) {
            parenthesis.add(str);
            return;
        }

        if (left < n) {
            dfs(parenthesis, n, left + 1, right, str + "(");
        }

        if (left > right) {
            dfs(parenthesis, n, left, right + 1, str + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(10));
    }
}
