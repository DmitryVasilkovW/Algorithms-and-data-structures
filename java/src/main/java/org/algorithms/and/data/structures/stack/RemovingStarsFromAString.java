package org.algorithms.and.data.structures.stack;
// https://leetcode.com/problems/removing-stars-from-a-string/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.Stack;

public class RemovingStarsFromAString
{
    public static String removeStars(String s)
    {
        var ans = new Stack<Character>();
        var sb = new StringBuilder();

        for (char c : s.toCharArray())
        {
            if (c == '*')
            {
                ans.pop();
            }
            else
            {
                ans.push(c);
            }
        }

        for (char c : ans)
        {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(removeStars("leet**cod*e"));
    }
}
