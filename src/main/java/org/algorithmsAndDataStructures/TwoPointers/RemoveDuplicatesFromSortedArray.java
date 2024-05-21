package org.algorithmsAndDataStructures.TwoPointers;
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

public class RemoveDuplicatesFromSortedArray
{
    public static int removeDuplicates(int[] nums)
    {
        int j = 0;

        for (int i = 1; i < nums.length; i++)
        {
            if(nums[i] != nums[(j)])
            {
                nums[++j] = nums[i];
            }
        }

        return ++j;
    }

    public static void main(String[] args)
    {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
    }
}
