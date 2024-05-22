package org.algorithmsAndDataStructures.TwoPointers;
// https://leetcode.com/problems/remove-element/

public class RemoveElement
{
    public static int removeElement(int[] nums, int val)
    {
        int j = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if(nums[i] != val)
            {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j++;
            }
        }

        return j;
    }

    public static void main(String[] args)
    {
        System.out.println(removeElement(new int[]{2,3,2,3}, 3));
    }
}
