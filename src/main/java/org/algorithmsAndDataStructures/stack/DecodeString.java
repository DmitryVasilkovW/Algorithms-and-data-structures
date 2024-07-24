package org.algorithmsAndDataStructures.stack;
// https://leetcode.com/problems/decode-string/?envType=study-plan-v2&envId=leetcode-75

import java.util.Stack;

public class DecodeString
{
    public static String decodeString(String s)
    {
        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> chars = new Stack<>();
        StringBuilder curr = new StringBuilder();

        int k = 0;

        for(char ch : s.toCharArray())
        {
            if(Character.isDigit(ch))
            {
                k = k * 10 + (ch-'0');
            }
            else if(ch == '[')
            {
                nums.push(k);
                chars.push(curr);

                k = 0;
                curr = new StringBuilder();
            }
            else if(ch == ']')
            {
                StringBuilder lastStr = chars.pop();
                int lastK = nums.pop();

                while(lastK-- > 0)
                {
                    lastStr.append(curr);
                }

                curr = lastStr;
            }
            else
            {
                curr.append(ch);
            }
        }

        return curr.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
