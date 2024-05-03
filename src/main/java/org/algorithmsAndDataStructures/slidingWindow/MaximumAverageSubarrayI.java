package org.algorithmsAndDataStructures.slidingWindow;
// https://leetcode.com/problems/maximum-average-subarray-i/?envType=study-plan-v2&envId=leetcode-75

public class MaximumAverageSubarrayI
{
    public static double findMaxAverage(int[] nums, int k)
    {
        double max = Double.NEGATIVE_INFINITY;
        int sum = 0;

        for (int i = 0; i < nums.length - k + 1; i++)
        {
            for (int j = 0; j < k; j++)
            {
                sum += nums[i + j];
            }

            max = Math.max(max, (double) sum / k);
            sum = 0;
        }

        return max;
    }

    public static void main(String[] args)
    {
        System.out.println(findMaxAverage(new int[]{-1}, 1));
    }
}
