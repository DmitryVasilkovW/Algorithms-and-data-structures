package org.algorithms.and.data.structures.array.or.string;
// https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75

public class MergeStringsAlternately
{
    public String mergeAlternately(String word1, String word2)
    {
        var ans = new StringBuffer();

        for (int i = 0, j = 0; i < word1.length() || j < word2.length(); i++, j++)
        {
            if (i < word1.length()) ans.append(word1.charAt(i));
            if (j < word2.length()) ans.append(word2.charAt(j));
        }

        return ans.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(new MergeStringsAlternately().mergeAlternately("abc", "pqrqqq"));
    }
}
