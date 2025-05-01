package org.algorithmsAndDataStructures.hashMapORSet;
// https://leetcode.com/problems/find-the-difference-of-two-arrays/?envType=study-plan-v2&envId=leetcode-75

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindTheDifferenceOfTwoArrays
{
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2)
    {
        var ans1 = new HashMap<Integer, Integer>();
        var ans2 = new HashMap<Integer, Integer>();
        var ans = new ArrayList<List<Integer>>();

        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());

        for (int i = 0; i < Math.max(nums1.length, nums2.length); i++)
        {
            while (i < Math.min(nums1.length, nums2.length))
            {

                if (!ans1.containsKey(nums1[i])) ans1.put(nums1[i], nums1[i]);
                else nums1[i] = 1001;

                if (!ans2.containsKey(nums2[i])) ans2.put(nums2[i], nums2[i]);
                else nums2[i] = 1001;

                i++;
            }

            if (i >= nums1.length && i >= nums2.length) break;

            if (nums1.length > nums2.length)
            {
                if (!ans1.containsKey(nums1[i])) ans1.put(nums1[i], nums1[i]);
                else nums1[i] = 1001;
            }
            else
            {
                if (!ans2.containsKey(nums2[i])) ans2.put(nums2[i], nums2[i]);
                else nums2[i] = 1001;
            }
        }

        for (int i = 0; i < Math.max(nums1.length, nums2.length); i++)
        {
            while (i < Math.min(nums1.length, nums2.length))
            {
                if (!ans2.containsKey(nums1[i]) && nums1[i] != 1001)
                {
                    ans.get(0).add(nums1[i]);
                }
                if (!ans1.containsKey(nums2[i]) && nums2[i] != 1001)
                {
                    ans.get(1).add(nums2[i]);
                }

                i++;
            }

            if (i >= nums1.length && i >= nums2.length) break;

            if (nums1.length > nums2.length)
            {
                if (!ans2.containsKey(nums1[i]) && nums1[i] != 1001)
                {
                    ans.get(0).add(nums1[i]);
                }
            }
            else
            {
                if (!ans1.containsKey(nums2[i]) && nums2[i] != 1001)
                {
                    ans.get(1).add(nums2[i]);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(findDifference(new int[] { 83,-98,-78,35,-98,79,-21,-33,53 }, new int[] { 58,-10,29,-57,-2,-39,-60,18,17,-37 }));
    }
}
