package org.algorithmsAndDataStructures.queue;
// https://leetcode.com/problems/sliding-window-maximum/

import java.util.Arrays;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        var queue = new MonotonicQueue<Integer>(k);
        var ans = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }

        ans[0] = queue.getMax();

        for (int i = k; i < nums.length; i++) {
            queue.add(nums[i]);
            ans[i - k + 1] = queue.getMax();
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.print(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(new int[]{7,2,4}, 2)));
    }
}

class MonotonicQueue<T extends Comparable<T>> {
    private final LinkedList<T> queue;
    private final LinkedList<T> maxQueue;
    private final int capacity;

    public MonotonicQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.maxQueue = new LinkedList<>();
        this.capacity = capacity;
    }

    public void add(T element) {
        if (queue.size() >= capacity) {
            T removed = queue.removeFirst();
            if (removed.equals(maxQueue.getFirst())) {
                maxQueue.removeFirst();
            }
        }

        queue.addLast(element);

        while (!maxQueue.isEmpty() && maxQueue.getLast().compareTo(element) < 0) {
            maxQueue.removeLast();
        }

        maxQueue.addLast(element);
    }

    public T remove() {
        T removed = queue.removeFirst();
        if (removed.equals(maxQueue.getFirst())) {
            maxQueue.removeFirst();
        }
        return removed;
    }

    public T getFirst() {
        return queue.getFirst();
    }

    public T getMax() {
        return maxQueue.getFirst();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}