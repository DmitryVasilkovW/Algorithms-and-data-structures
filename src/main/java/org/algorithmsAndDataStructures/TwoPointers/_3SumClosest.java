package org.algorithmsAndDataStructures.TwoPointers;
// https://leetcode.com/problems/3sum-closest/description/

import java.util.Arrays;

public class _3SumClosest
{
    public static int threeSumClosest(int[] nums, int target)
    {
        int min = 13001;
        int minSum = 0;

        Arrays.sort(nums);

        for (int l = 0; l < nums.length; l++)
        {
            int rl = l + 1;
            int r = nums.length - 1;

            while (rl < r)
            {
                int sum = nums[l] + nums[r] + nums[rl];

                if (sum == target)
                {
                    return sum;
                }
                else
                {
                    if (min > Math.abs(sum - target))
                    {
                        min = Math.abs(sum - target);
                        minSum = sum;
                    }

                    if (sum < target)
                    {
                        rl++;
                    }
                    else
                    {
                        r--;
                    }
                }
            }
        }

        return minSum;
    }

    public static void main(String[] args)
    {
        System.out.println(threeSumClosest(new int[]{-1000,-1000,-1000}, 10000));
    }
}
