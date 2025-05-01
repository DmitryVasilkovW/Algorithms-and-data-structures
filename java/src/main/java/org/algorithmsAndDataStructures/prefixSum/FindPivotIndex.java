package org.algorithmsAndDataStructures.prefixSum;
// https://leetcode.com/problems/find-pivot-index/?envType=study-plan-v2&envId=leetcode-75

public class FindPivotIndex
{
    public static int pivotIndex(int[] nums)
    {
        if (nums.length == 1)
        {
            return 0;
        }

        var nums1 = new int[nums.length];
        var nums2 = new int[nums.length];

        nums1[0] = nums[0];
        nums2[0] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++)
        {
            nums1[i] = nums[i] + nums1[i - 1];
            nums2[i] = nums[nums.length - i - 1] + nums2[i - 1];
        }

        int l;
        int r;
//        int preR;
//        int preL;
//        int nextR;
//        int nextL;
        int ans = -1;

        for (int i = 0; i < nums.length; i++)
        {
            l = nums1[i];
            r = nums2[nums2.length - 1 - i];

            if (r == l)
            {
                ans = i;
                break;
            }

//            if (i == 0)
//            {
//                preL = 0;
//                nextL = nums1[i + 1];
//                preR = 0;
//                nextR = nums2[nums2.length - i - 2];
//            }
//            else if (i == nums.length - 1)
//            {
//                nextL = 0;
//                preL = nums1[i - 1];
//                nextR = 0;
//                preR = nums2[nums2.length - i];
//            }
//            else
//            {
//                preL = nums1[i - 1];
//                nextL = nums1[i + 1];
//                preR = nums2[nums2.length - i];
//                nextR = nums2[nums2.length - i - 2];
//            }
//
//            l = nums1[i];
//            r = nums2[nums2.length - 1 - i];
//
//            if (r == l && (preL == nextR || preR == nextL))
//            {
//                ans = i;
//                break;
//            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(pivotIndex(new int[] {2,1,-1}));
    }
}
