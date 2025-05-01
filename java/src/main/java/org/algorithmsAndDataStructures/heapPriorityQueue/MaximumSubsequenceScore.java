package org.algorithmsAndDataStructures.heapPriorityQueue;

import java.util.*;

public class MaximumSubsequenceScore
{
    static class Pair implements Comparable<Pair>
    {
        int first;
        int second;

        Pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair pair)
        {
            return Integer.compare(this.second, pair.second);
        }
    }

    public static long maxScore(int[] nums1, int[] nums2, int k)
    {
        var list = new ArrayList<Pair>();
        var arr1 = new int[nums1.length];
        var arr2 = new int[nums2.length];
        long ans = 0;

        if (k == 1)
        {
            for (int i = 0; i < nums1.length; i++)
            {
                ans = Math.max(ans, nums1[i] * nums2[i]);
            }

            return ans;
        }

        for (int i = 0; i < nums1.length; i++)
        {
            list.add(new Pair(nums1[i], nums2[i]));
        }

        Collections.sort(list);

        for (int i = 0; i < nums1.length; i++)
        {
            arr1[i] = list.get(i).first;
            arr2[i] = list.get(i).second;
        }

        var queue = new PriorityQueue<Integer>();

        long sum = 0;
        for (int i = nums1.length - 1; i >= 0; i--)
        {
            int cur = arr1[i];

            if (i <= nums2.length - k)
            {
                ans = Math.max(ans, (sum + cur) * arr2[i]);
            }
            if (queue.size() < k - 1)
            {
                queue.add(cur);
                sum += cur;
            }
            else if (cur > queue.peek())
            {
                sum -= queue.poll();
                queue.add(cur);
                sum += cur;
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(maxScore(new int[]{2,1,14,12}, new int[]{11,7,13,6}, 3));
    }
}
