package org.algorithms.and.data.structures.hash.map.or.set;
// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        var ans = new ArrayList<Integer>();
        HashMap<Character, Integer> mapP = makeMap(p);
        int hashP = hash(p);

        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            String sub = s.substring(i, i + p.length());
            int hashSub = hash(sub);

            if (hashSub == hashP) {
                HashMap<Character, Integer> mapSub = makeMap(sub);

                if (mapSub.equals(mapP)) ans.add(i);
            }
        }

        return ans;
    }

    private HashMap<Character, Integer> makeMap(String p) {
        var map = new HashMap<Character, Integer>();

        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }

    private int hash(String p) {
        int hash = 0;

        for (char c : p.toCharArray()) {
            hash += c;
        }

        return hash;
    }

    public static void main(String[] args) {
        System.out.print(new FindAllAnagramsInAString().findAnagrams("abab", "ab"));
    }
}
