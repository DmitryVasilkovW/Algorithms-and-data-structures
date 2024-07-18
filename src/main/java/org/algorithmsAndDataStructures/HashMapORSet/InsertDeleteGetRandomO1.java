package org.algorithmsAndDataStructures.HashMapORSet;
// https://leetcode.com/problems/insert-delete-getrandom-o1/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandomO1 {
    private HashMap<Integer, Integer> map = new HashMap<>();
    private Random rand = new Random();
    private ArrayList<Integer> list = new ArrayList<>();

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        list.add(val);
        map.put(val, list.size() - 1);

        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int tmp = map.get(val);

        if (tmp < list.size() - 1) {
            int last = list.get(list.size() - 1);
            list.set(tmp, last);
            map.put(last, tmp);
        }
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
