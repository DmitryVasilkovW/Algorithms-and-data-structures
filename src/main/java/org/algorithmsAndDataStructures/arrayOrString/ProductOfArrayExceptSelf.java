package org.algorithmsAndDataStructures.arrayOrString;
// https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75

public class ProductOfArrayExceptSelf
{
    public static int[] productExceptSelf(int[] nums)
    {
        int[] pref = new int[nums.length];
        int[] suff = new int[nums.length];

        pref[0] = nums[0];
        suff[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++)
        {
            pref[i] = pref[i - 1] * nums[i];
            suff[nums.length - i - 1] = suff[nums.length - i] * nums[nums.length - i - 1];
        }

        for (int i = 1; i < nums.length - 1; i++)
        {
            nums[i] = pref[i - 1] * suff[i + 1];
        }

        nums[0] = suff[1];
        nums[nums.length - 1] = pref[nums.length - 2];

        return nums;
    }

    public static void main(String[] args)
    {
        System.out.println(productExceptSelf(new int[]{1, 2, 3, 4}));
    }
}
