package org.algorithms.and.data.structures.array.or.string;
// https://leetcode.com/problems/permutation-in-string/

import java.util.HashMap;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        var map1 = new HashMap<Character, Integer>();
        var map2 = new HashMap<Character, Integer>();

        int hash = hash(s1);
        map1 = makeMap(s1, map1);

        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            String sub = s2.substring(i, i + s1.length());

            if (hash == hash(sub)){
                map2 = makeMap(sub, map2);

                if (map1.equals(map2)) return true;
            }
        }

        return false;
    }

    private int hash(String s) {
        int hash = 0;

        for (char c : s.toCharArray()) {
            hash = hash + c;
        }

        return hash;
    }

    private HashMap<Character, Integer> makeMap(String s, HashMap<Character, Integer> map) {
        map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }

    public static void main(String[] args) {
        var task = new PermutationInString();

        System.out.println(task.checkInclusion("ab", "eidbaooo"));
    }
}
