package org.algorithmsAndDataStructures.BinarySearch;
// https://leetcode.com/problems/successful-pairs-of-spells-and-potions/?envType=study-plan-v2&envId=leetcode-75

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions
{
    public static long count(int[] p, long tar, int spell)
    {
        long count = 0;
        int r = p.length, l = -1;

        while (r > l + 1)
        {
            int mid = (r + l + 1) / 2;

            if ((long)p[mid] * spell >= tar)
            {
                count += r - mid;

                r = mid;
            }
            else
            {
                l = mid;
            }
        }

        return count;
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success)
    {
        var ans = new int[spells.length];
        long counter;

        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++)
        {
            counter = count(potions, success, spells[i]);

            ans[i] = (int) counter;
        }

        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(successfulPairs(new int[]{3,1,2}, new int[]{8,5,8}, 16)));
    }
}
