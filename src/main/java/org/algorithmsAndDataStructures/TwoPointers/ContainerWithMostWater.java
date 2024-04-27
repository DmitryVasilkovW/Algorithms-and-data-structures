package org.algorithmsAndDataStructures.TwoPointers;
// https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=leetcode-75

public class ContainerWithMostWater
{
    public static int maxArea(int[] height)
    {
        int maxArea = -239;
        int r = height.length - 1, l = 0;

        while (r > l)
        {
            maxArea = Math.max(maxArea, Math.min(height[r], height[l]) * (r - l));

            if (height[r] > height[l])
            {
                l++;
            }
            else
            {
                r--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args)
    {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
