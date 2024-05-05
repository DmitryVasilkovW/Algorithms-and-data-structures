package org.algorithmsAndDataStructures.HashMapORSet;
// https://leetcode.com/problems/determine-if-two-strings-are-close/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.*;

public class DetermineIfTwoStringsAreClose
{
    public static boolean closeStrings(String word1, String word2)
    {
        var set1 = new HashSet<Character>();
        var set2 = new HashSet<Character>();
        var map1 = new HashMap<Character, Integer>();
        var map2 = new HashMap<Character, Integer>();
        var map11 = new HashMap<Integer, Integer>();
        var map22 = new HashMap<Integer, Integer>();

        for (char c : word1.toCharArray())
        {
            set1.add(c);
        }

        for (char c : word2.toCharArray())
        {
            set2.add(c);
        }

        var tmp = word1.toCharArray();

        Arrays.sort(tmp);

        var word11 = tmp;
        tmp = word2.toCharArray();

        Arrays.sort(tmp);

        var word21 = tmp;

        var count = 0;
        var prev = word11[0];
        for (int i = 0; i < word11.length; i++)
        {
            count ++;

            if (word11[i] != prev)
            {
                prev = word11[i];
                if (i > 0) i--;
                count --;

                map1.put(word11[i], count);

                count = 0;
            }
            if (i == word11.length - 1)
            {
                map1.put(word11[i], count);
            }
        }

        prev = word21[0];
        count = 0;
        for (int i = 0; i < word21.length; i++)
        {
            count ++;

            if (word21[i] != prev)
            {
                prev = word21[i];
                if (i > 0) i--;
                count --;

                map2.put(word21[i], count);

                count = 0;
            }
            if (i == word21.length - 1)
            {
                map2.put(word21[i], count);
            }
        }

        boolean check = set1.equals(set2);

        if (check)
        {
            var arr1 = map1.values().toArray();
            var arr2 = map2.values().toArray();

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            var p = arr1[0];
            count = 0;
            for (int i = 0; i < arr1.length; i++)
            {
                count ++;

                if (arr1[i] != p)
                {
                    p = arr1[i];
                    if (i > 0) i--;
                    count --;

                    map11.put((Integer) arr1[i], count);

                    count = 0;
                }
                if (i == arr1.length - 1)
                {
                    map11.put((Integer) arr1[i], count);
                }
            }

            p = arr2[0];
            count = 0;
            for (int i = 0; i < arr2.length; i++)
            {
                count ++;

                if (arr2[i] != p)
                {
                    p = arr2[i];
                    if (i > 0) i--;
                    count --;

                    map22.put((Integer) arr2[i], count);

                    count = 0;
                }
                if (i == arr2.length - 1)
                {
                    map22.put((Integer) arr2[i], count);
                }
            }

            for (var i : map11.keySet())
            {
                if (map11.get(i) != map22.get(i))
                {
                    check = false;
                    break;
                }
            }
        }

        return check;
    }

    public static void main(String[] args)
    {
        System.out.println(closeStrings("cabbba", "abbccc"));
    }
}
