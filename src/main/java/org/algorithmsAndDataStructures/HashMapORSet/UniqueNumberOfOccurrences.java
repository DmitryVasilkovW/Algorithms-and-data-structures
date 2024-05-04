package org.algorithmsAndDataStructures.HashMapORSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class UniqueNumberOfOccurrences
{
    public static boolean uniqueOccurrences(int[] arr)
    {
        var map = new HashMap<Integer, Integer>();
        var tmp = new ArrayList<Integer>();
        int count = 0;

        Arrays.sort(arr);

        int prev = arr[0];

        for (int i = 0; i < arr.length; i++)
        {
            count ++;

            if (arr[i] != prev)
            {
                prev = arr[i];
                if (i > 0) i--;
                count--;

                map.put(count, arr[i]);
                tmp.add(arr[i]);

                count = 0;
            }
            if (i == arr.length - 1)
            {
                map.put(count, arr[i]);
                tmp.add(arr[i]);
            }
        }

        return map.size() == tmp.size();
    }

    public static void main(String[] args)
    {
        System.out.println(uniqueOccurrences(new int[]{6, 6, -1}));
    }
}
