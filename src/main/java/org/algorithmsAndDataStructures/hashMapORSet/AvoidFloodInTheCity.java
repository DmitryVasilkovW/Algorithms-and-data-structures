package org.algorithmsAndDataStructures.hashMapORSet;
// https://leetcode.com/problems/avoid-flood-in-the-city/description/

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class AvoidFloodInTheCity {

    public int[] avoidFlood(int[] rains) {
        var lastRain = new HashMap<Integer, Integer>();
        var dry = new TreeSet<Integer>();
        var ans = new int[rains.length];

        for (int i = 0; i < rains.length; i++){
            int x = rains[i];

            if(x == 0) {
                dry.add(i);
                ans[i] = 1;
            } else {
                Integer id = lastRain.get(x);

                if (id == null) {
                    lastRain.put(x , i);
                } else {
                    Integer dryingDay = dry.higher(id);

                    if (dryingDay == null) {
                        return new int[0];
                    }

                    ans[dryingDay] = x;
                    dry.remove(dryingDay);

                    lastRain.put(x , i);
                }

                ans[i] = -1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new AvoidFloodInTheCity().avoidFlood(new int[]{1, 2, 0, 0, 2, 1})));
    }
}
