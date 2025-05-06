package org.algorithms.and.data.structures.two.pointers;
// https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75


public class MoveZeroes
{
    public static void moveZeroes(int[] nums)
    {
        int r = 0, l = -1;

        for (int i = 0; i < nums.length; i++)
        {

            if (nums[i] == 0)
            {
                r = i + 1;

                if (r > nums.length - 1)
                {
                    break;
                }

                if (l == -1)
                {
                    l = i;
                }
            }

            if (nums[r] != 0 && l >= 0)
            {
                int tmp = nums[r];
                nums[r] = nums[l];
                nums[l] = tmp;

                l++;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {1,0,1};

        moveZeroes(nums);
    }
}
