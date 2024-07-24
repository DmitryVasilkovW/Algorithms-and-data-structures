package org.algorithmsAndDataStructures.heapPriorityQueue;
// https://leetcode.com/problems/kth-largest-element-in-an-array/?envType=study-plan-v2&envId=leetcode-75

import java.util.PriorityQueue;

public class KthLargestElementInAnArray
{
    public static int findKthLargest(int[] nums, int k)
    {
        var q = new PriorityQueue<Integer>((a,b) -> b - a);

        for (int i : nums)
        {
            q.add(i);
        }

        int ans = 0;
        while (k --> 0)
        {
            ans = q.poll();
        }

        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
