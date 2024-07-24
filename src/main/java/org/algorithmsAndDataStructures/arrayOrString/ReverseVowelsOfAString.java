package org.algorithmsAndDataStructures.arrayOrString;
// https://leetcode.com/problems/reverse-vowels-of-a-string/?envType=study-plan-v2&envId=leetcode-75

public class ReverseVowelsOfAString
{
    public static char[] data = new char[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

    public static int isInData(char c1, char c2)
    {
        int res = 0;

        for (char ch : data)
        {
            if (ch == c1) res += 1;
            if (ch == c2) res += 2;
        }

        return res;
    }

    public static String reverseVowels(String s)
    {
        var res = new char[s.length()];
        var ans = new StringBuilder();
        int r = s.length() - 1, l = 0;

        while (r >= l)
        {
            if (isInData(s.charAt(l), s.charAt(r)) == 3)
            {
                res[l] = s.charAt(r);
                res[r] = s.charAt(l);

                l++;
                r--;
            }
            else if (isInData(s.charAt(l), s.charAt(r)) == 1)
            {
                res[r] = s.charAt(r);

                r--;
            }
            else if (isInData(s.charAt(l), s.charAt(r)) == 2)
            {
                res[l] = s.charAt(l);

                l++;
            }
            else
            {
                res[l] = s.charAt(l);
                res[r] = s.charAt(r);

                l++;
                r--;
            }
        }

        for (char ch : res)
        {
            ans.append(ch);
        }

        return ans.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(reverseVowels("leetcode"));
    }
}
