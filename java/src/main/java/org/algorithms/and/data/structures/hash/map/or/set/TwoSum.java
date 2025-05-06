package org.algorithms.and.data.structures.hash.map.or.set;
// https://leetcode.com/problems/two-sum/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum
{
    public static int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        var ans = new int[2];
        int count = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (!map.containsKey(nums[i]))
            {
                var tmp = new ArrayList<Integer>();

                tmp.add(i);

                map.put(nums[i], tmp);
            }
            else
            {
                map.get(nums[i]).add(i);
            }
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(target - nums[i]))
            {
                boolean t = false;

                for (int j : map.get(target - nums[i]))
                {
                    if (j != i) t = true;
                }

                if (t)
                {
                    ans[count] = i;
                    count++;
                }

                if (count == 2) break;
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(twoSum(new int[]{3,3}, 6)));
    }
}
