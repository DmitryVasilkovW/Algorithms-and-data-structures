package org.algorithms.and.data.structures.two.pointers;
// https://leetcode.com/problems/3sum/description/

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _3Sum
{
    public static List<List<Integer>> threeSum(int[] nums)
    {
        var ansed = new HashSet<List<Integer>>();

        Arrays.sort(nums);

        for (int l = 0; l < nums.length; l++)
        {
            int rl = l + 1;
            int r = nums.length - 1;

            while (rl < r)
            {
                int sum = nums[l] + nums[r] + nums[rl];

                if (sum == 0)
                {
                    ansed.add(Arrays.asList(nums[l], nums[r], nums[rl]));

                    rl++;
                    r--;
                }
                else if (sum > 0)
                {
                    r--;
                }
                else
                {
                    rl++;
                }
            }
        }

        return ansed.stream().toList();
    }

    public static void main(String[] args)
    {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
