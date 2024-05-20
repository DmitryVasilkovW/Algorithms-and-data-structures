package org.algorithmsAndDataStructures.SlidingWindow;
// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=study-plan-v2&envId=leetcode-75

public class LongestSubarrayOf1sAfterDeletingOneElement
{
    private static int max = 0;
    private static int count = 0;
    private static int l = 0, r = -1;
    private static int one = 0;
    private static int sum;

    private static boolean incL(int[] nums)
    {
        if (count > 1)
        {
            if(nums[l] == 0)
            {
                count --;
                one = 0;
            }

            if (l + 1 < nums.length) l++;
            count--;

            sum -= nums[r];
            r--;

            return true;
        }

        return false;
    }

    public static int longestSubarray(int[] nums)
    {
        while (r < nums.length)
        {
            if (r + 1 < nums.length) r++;
            else break;

            sum += nums[r];

            if (nums[r] == 0)
            {
                count++;
                one = 1;
            }

            if (incL(nums))
            {
                continue;
            }

            if (sum == nums.length)
            {
                one = 1;
            }
            else if (sum  == 0 && r == nums.length - 1) return 0;

            max = Math.max(max, r - l - one + 1);
        }

        return max;
    }

    public static void main(String[] args)
    {
        System.out.println(longestSubarray(new int[]{0,0,1,1}));
    }
}
