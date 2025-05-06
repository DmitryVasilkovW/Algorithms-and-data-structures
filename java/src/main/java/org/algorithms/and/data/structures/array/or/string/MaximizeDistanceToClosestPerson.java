package org.algorithms.and.data.structures.array.or.string;
// https://leetcode.com/problems/maximize-distance-to-closest-person/description/

public class MaximizeDistanceToClosestPerson {
    public static int maxDistToClosest(int[] seats) {
        int max = 0, last = -1;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                max = last == -1 ? i : Math.max(max, (i - last) / 2);
                last = i;
            }
        }

        max = Math.max(max, seats.length - last - 1);

        return max;
    }

    public static void main(String[] args) {
        System.out.print(maxDistToClosest(new int[] { 1,0,0,0,1,0,1 }));
    }
}
