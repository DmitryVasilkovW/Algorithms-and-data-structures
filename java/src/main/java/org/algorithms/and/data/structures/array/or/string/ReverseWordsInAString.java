package org.algorithms.and.data.structures.array.or.string;
// https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75

public class ReverseWordsInAString
{
    public static String reverseWords(String s)
    {
        if (s.length() == 1) return s;

        int r1 = s.length() - 1, r2 = r1;
        var ans = new StringBuilder();

        while (true)
        {
            if (r1 <= 0 || r2 <= 0) break;

            while (s.charAt(r2) == ' ')
            {
                r2--;

                if (r2 <= 0) break;
            }

            r1 = r2;

            while (s.charAt(r1) != ' ')
            {
                r1--;

                if (r1 < 0) break;
            }

            r1++;

            ans.append(s.substring(r1, r2 + 1));
            ans.append(' ');

            r2 = r1 - 1;
        }

        r1 = ans.length() - 1;
        while (ans.charAt(r1) == ' ')
        {
            r1--;
        }

        return ans.substring(0, r1 + 1).toString();
    }

    public static void main(String[] args)
    {
        System.out.println(reverseWords("the sky is blue"));
    }
}
