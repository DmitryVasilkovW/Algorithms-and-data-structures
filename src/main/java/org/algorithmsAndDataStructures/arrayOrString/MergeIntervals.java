package org.algorithmsAndDataStructures.arrayOrString;
// https://leetcode.com/problems/merge-intervals/description/

import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) { return intervals; }

        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));
        var ans = new ArrayList<int[]>();

        pq.addAll(Arrays.stream(intervals).toList());

        while (!pq.isEmpty()) {
            var first = pq.poll();
            var second = pq.poll();

            if (second != null && first[1] >= second[0]) {
                pq.add(new int[]{Math.min(first[0], second[0]), Math.max(first[1], second[1])});
            } else {
                if (first != null) ans.add(first);
                if (second != null) pq.add(second);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        var ans = new MergeIntervals().merge(new int[][]{{1,3},{2,6}, {8, 10}, {15,18}});

        for (int[] interval : ans) {
            System.out.print(Arrays.toString(interval) + " ");
        }
    }
}
