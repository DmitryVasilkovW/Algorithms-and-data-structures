package org.algorithms.and.data.structures.sliding.window;
// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/?envType=study-plan-v2&envId=leetcode-75

public class MaximumNumberOfVowelsInASubstringOfGivenLength
{
    public static int maxVowels(String s, int k)
    {
        int vowels = 0, max = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if ("aeiou".indexOf(s.charAt(i)) != -1)
            {
                vowels++;
            }
            if (i >= k && "aeiou".indexOf(s.charAt(i - k)) != -1)
            {
                vowels--;
            }
            if (i >= k - 1)
            {
                max = Math.max(max, vowels);
            }
        }
        return max;
    }

    public static void main(String[] args)
    {
        System.out.println(maxVowels("abciiidef", 3));
    }
}
