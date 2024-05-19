package org.algorithmsAndDataStructures.HeapPriorityQueue;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class SmallestInfiniteSet
{
    private PriorityQueue<Integer> queue = new PriorityQueue<>();
    private Set<Integer> set = new HashSet<>();

    public SmallestInfiniteSet()
    {
        for (int i = 1; i <= 1000; i++)
        {
            queue.add(i);
            set.add(i);
        }
    }

    public int popSmallest()
    {
        set.remove(queue.peek());
        return queue.poll();
    }

    public void addBack(int num)
    {
        if (!set.contains(num))
        {
            queue.add(num);
            set.add(num);
        }
    }
}