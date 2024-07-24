package org.algorithmsAndDataStructures.twoPointers;
// https://leetcode.com/problems/4sum/

import java.util.*;

public class _4Sum
{
    public static List<List<Integer>> fourSum(int[] nums, int target)
    {
        var ansed = new HashSet<java.util.List<Integer>>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++)
        {
            for (int l = i + 1; l < nums.length; l++)
            {

                int rl = l + 1;
                int r = nums.length - 1;

                while (rl < r)
                {
                    var sum = (long) nums[l] + nums[r] + nums[rl];

                    if (sum == target - nums[i])
                    {
                        var tmp = new PriorityQueue<Integer>();

                        tmp.add(nums[i]);
                        tmp.add(nums[rl]);
                        tmp.add(nums[r]);
                        tmp.add(nums[l]);

                        ansed.add(tmp.stream().toList());

                        rl++;
                        r--;
                    }
                    else if (sum > target - nums[i])
                    {
                        r--;
                    }
                    else
                    {
                        rl++;
                    }
                }
            }
        }

        return ansed.stream().toList();
    }

    public static void main(String[] args)
    {
        System.out.println(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
    }
}
