package org.algorithmsAndDataStructures.arrayOrString;
// https://leetcode.com/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75

public class GreatestCommonDivisorOfStrings
{
    public static String gcdOfStrings(String str1, String str2)
    {
        int count = 0;

        if (!(str1 + str2).equals(str2 + str1))
        {
            return "";
        }

        for (int i = 1; i <=  Math.min(str1.length(), str2.length()); i++)
        {
            if (str1.length() % i == 0 && str2.length()  % i == 0)
            {
                count = i;
            }
        }

        return str1.substring(0, count);
    }

    public static int[] pref(String text)
    {
        var pref = new int[text.length()];

        for (int i = 1; i < text.length(); i++)
        {
            int j = pref[i - 1];

            while (j > 0 && text.charAt(j) != text.charAt(i))
            {
                j = pref[j - 1];
            }

            if (text.charAt(i) == text.charAt(j))
            {
                j += 1;
            }

            pref[i] = j;
        }


        return pref;
    }



    public static void main(String[] args)
    {
        System.out.println(gcdOfStrings("LEET", "CODE"));
    }
}