package org.algorithmsAndDataStructures.arrayOrString;
// https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/description/?envType=problem-list-v2&envId=string

import java.util.HashMap;

public class CheckIfAllCharactersHaveEqualNumberOfOccurrences {
    public boolean areOccurrencesEqual(String s) {
        var map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = map.get(s.charAt(0));
        return map.values().stream().allMatch(v -> v == max);
    }

    public static void main(String[] args) {
        var task = new CheckIfAllCharactersHaveEqualNumberOfOccurrences();
        String s = "abacbc";

        System.out.println(task.areOccurrencesEqual(s));
    }
}
