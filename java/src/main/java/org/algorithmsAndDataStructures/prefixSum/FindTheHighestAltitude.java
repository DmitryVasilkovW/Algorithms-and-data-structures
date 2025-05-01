package org.algorithmsAndDataStructures.prefixSum;
// https://leetcode.com/problems/find-the-highest-altitude/description/?envType=study-plan-v2&envId=leetcode-75

public class FindTheHighestAltitude
{
    public static int largestAltitude(int[] gain)
    {
        int max = Math.max(gain[0], 0);

        for (int i = 1; i < gain.length; i++)
        {
            gain[i] += gain[i - 1];

            if (gain[i] > max)
            {
                max = gain[i];
            }
        }

        return max;
    }

    public static void main(String[] args)
    {
        System.out.println(largestAltitude(new int[] {52,-91,72}));
    }
}
