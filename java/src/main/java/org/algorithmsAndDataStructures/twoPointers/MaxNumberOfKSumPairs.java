package org.algorithmsAndDataStructures.twoPointers;
// https://leetcode.com/problems/max-number-of-k-sum-pairs/?envType=study-plan-v2&envId=leetcode-75

import java.util.Arrays;

public class MaxNumberOfKSumPairs
{
    public static int maxOperations(int[] nums, int k)
    {
        int r = nums.length - 1, l = 0, count = 0;

        Arrays.sort(nums);

        while (r > l)
        {
            if (nums[r] + nums[l] == k)
            {
                count++;
                r--;
                l++;
            }
            else if (nums[l] + nums[r] < k)
            {
                l++;
            }
            else
            {
                r--;
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        System.out.println(maxOperations(new int[]{4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4}, 2));
    }
}
