package org.algorithms.and.data.structures.array.or.string;
// https://leetcode.com/problems/increasing-triplet-subsequence/description/?envType=study-plan-v2&envId=leetcode-75

public class IncreasingTripletSubsequence
{
    public static boolean increasingTriplet(int[] nums)
    {
        var is = new int[nums.length];
        var ks = new int[nums.length];

        is[0] = nums[0];
        ks[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++)
        {
            is[i] = Math.min(is[i - 1], nums[i]);
            ks[nums.length - i - 1] = Math.max(ks[nums.length - i], nums[nums.length - i - 1]);
        }

        for (int i = 1; i < nums.length - 1; i++)
        {
            if (is[i - 1] < nums[i] && nums[i] < ks[i + 1])
            {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        System.out.println(increasingTriplet(new int[]{20,100,10,12,5,13}));
    }
}
