package org.algorithms.and.data.structures.heap.priority.queue;
// https://leetcode.com/problems/total-cost-to-hire-k-workers/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.ArrayList;
import java.util.PriorityQueue;

public class TotalCostToHireKWorkers
{
    public static long totalCost(int[] costs, int k, int candidates)
    {
        var list = new ArrayList<Integer>();
        var l = new PriorityQueue<Integer>();
        var r = new PriorityQueue<Integer>();
        long ans = 0;

        for (int i : costs)
        {
            list.add(i);
        }

        if (list.size() / 2 < candidates)
        {
            for (int i = 0; i < candidates; i++)
            {
                l.add(list.get(i));
            }
            for (int i = 0; i < candidates; i++)
            {
                list.remove(0);
            }

            for (int i = 0; i < candidates; i++)
            {
                if (list.isEmpty()) break;

                r.add(list.get(list.size() - 1 - i));

                if (i == list.size() - 1) break;
            }

            for (int i = 0; i < candidates; i++)
            {
                if (list.isEmpty()) break;

                list.remove(list.size() - 1);
            }
        }
        else
        {
            for (int i = 0; i < candidates; i++)
            {
                l.add(list.get(i));
                r.add(list.get(list.size() - 1 - i));
            }

            for (int i = 0; i < candidates; i++)
            {
                list.remove(0);
                list.remove(list.size() - 1);
            }
        }


        while (k --> 0)
        {
            if (!l.isEmpty() && !r.isEmpty())
            {
                if (l.peek() <= r.peek())
                {
                    ans += l.poll();
                }
                else
                {
                    ans += r.poll();
                }
            }
            else if (!l.isEmpty())
            {
                ans += l.poll();
            }
            else
            {
                ans += r.poll();
            }

            if (!list.isEmpty())
            {
                if (l.size() < candidates)
                {
                    l.add(list.get(0));
                    list.remove(0);
                }
                else
                {
                    r.add(list.get(list.size() - 1));
                    list.remove(list.size() - 1);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(totalCost(new int[]{69,10,63,24,1,71,55,46,4,61,78,21,85,52,83,77,42,21,73,2,80,99,98,89,55,94,63,50,43,62,14}, 21, 31));
    }
}
