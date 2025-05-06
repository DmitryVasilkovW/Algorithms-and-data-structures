package org.algorithms.and.data.structures.binary.search;
// https://leetcode.com/problems/find-peak-element/description/?envType=study-plan-v2&envId=leetcode-75

public class FindPeakElement
{

    public static int findPeakElement(int[] nums)
    {
        return search(nums, 0, nums.length - 1);
    }

    public static int search(int[] nums, int l, int r)
    {
        if (l == r)
        {
            return l;
        }

        int mid = (l + r) / 2;

        if (nums[mid] > nums[mid + 1])
        {
            return search(nums, l, mid );
        }

        return search(nums, mid + 1, r);
    }

    public static void main(String[] args)
    {
        System.out.println(findPeakElement(new int[]{2, 1}));
    }
}
