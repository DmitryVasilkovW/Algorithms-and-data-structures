package org.algorithmsAndDataStructures.slidingWindow;
// https://leetcode.com/problems/max-consecutive-ones-iii/description/?envType=study-plan-v2&envId=leetcode-75

public class MaxConsecutiveOnesIII
{
    private static int max = 0;
    private static int count = 0;
    private static int l = 0, r = -1;

    private static boolean incL(int k, int[] nums)
    {
        if (count > k)
        {
            if (nums[l] == 0)
            {
                count --;
            }

            if (l + 1 < nums.length) l++;
            count--;

            if (r - 1 > 0) r--;

            return true;
        }

        return false;
    }

    public static int longestOnes(int[] nums, int k)
    {
        if (k == 0)
        {
            int sum = 0;

            for (int i = 0; i < nums.length; i++)
            {
                sum += nums[i];

                if (nums[i] == 0 || i == nums.length - 1)
                {
                    max = Math.max(max, sum);

                    sum = 0;
                }
            }
        }
        else
        {
            while (r < nums.length && l < nums.length)
            {
                if (r + 1 < nums.length) r++;
                else break;

                if (nums[r] == 0)
                {
                    count++;
                }

                if (incL(k, nums))
                {
                    continue;
                }

                max = Math.max(max, r - l + 1);
            }
        }

        return max;
    }

    public static void main(String[] args)
    {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1}, 0));
    }
}
