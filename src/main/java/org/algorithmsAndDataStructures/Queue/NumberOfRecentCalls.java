package org.algorithmsAndDataStructures.Queue;
// https://leetcode.com/problems/number-of-recent-calls/?envType=study-plan-v2&envId=leetcode-75

import java.util.LinkedList;
import java.util.Queue;

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */

public class NumberOfRecentCalls
{
    static class RecentCounter
    {
        private final Queue<Integer> queue = new LinkedList<>();

        public RecentCounter() {}

        public int ping(int t)
        {
            queue.add(t);

            while (queue.peek() < t - 3000)  queue.poll();

            return queue.size();
        }
    }

    public static void main(String[] args)
    {
        var tmp = new RecentCounter();
        var test = new int[]{2196,3938,4723,4775,5952};

        for (int i : test)
        {
            System.out.println(tmp.ping(i));
        }
    }
}
