package org.algorithmsAndDataStructures.ArrayOrString;
// https://leetcode.com/problems/string-compression/description/?envType=study-plan-v2&envId=leetcode-75

public class StringCompression
{
    public static int compress(char[] chars)
    {
        var ans = new StringBuilder();
        int count = 1;
        int tmp = 0;

        if (chars.length == 1) ans.append(chars[0]);

        for (int i = 1; i < chars.length; i++)
        {
            if (chars[i] != chars[i - 1])
            {
                if (count > 1) ans.append(chars[i - 1] + "" + count);
                else ans.append(chars[i - 1]);

                count = 1;
            }
            else
            {
                count ++;
            }

            if (i == chars.length - 1)
            {
                if (count > 1) ans.append(chars[i] + "" + count);
                else ans.append(chars[i]);
            }

            for (; tmp < ans.length(); tmp++)
            {
                chars[tmp] = ans.charAt(tmp);
            }
        }

        return ans.length();
    }

    public static void main(String[] args)
    {
        System.out.println(compress(new char[] {'a', 'a', 'a'}));
    }
}
