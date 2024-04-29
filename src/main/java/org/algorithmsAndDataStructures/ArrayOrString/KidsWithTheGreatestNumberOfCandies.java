package org.algorithmsAndDataStructures.ArrayOrString;
// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies
{
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies)
    {
        List<Boolean> result = new ArrayList<>();
        int max = -1;

        for (int candy : candies)
        {
            if (candy > max)
            {
                max = candy;
            }
        }

        for (int candy : candies)
        {
            if (candy + extraCandies >= max)
            {
                result.add(true);
            }
            else
            {
                result.add(false);
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        for (boolean candy : kidsWithCandies(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 5)) System.out.println(candy);
    }
}
