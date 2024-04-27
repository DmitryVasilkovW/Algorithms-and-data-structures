package org.algorithmsAndDataStructures.TwoPointers;
// https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=leetcode-75

public class IsSubsequence
{
    public static boolean isSubsequence(String s, String t)
    {
        if (s.length() == 0) return true;

        int r = 0, l = 0;

        for (int i = 0; i < t.length() && l < s.length(); i++)
        {
            if (s.charAt(l) == t.charAt(r))
            {
                l++;
                r++;
            }
            else
            {
                r++;
            }
        }

        return l == s.length() ? true : false;
    }

    public static void main(String[] args)
    {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }
}
