package org.algorithmsAndDataStructures.slidingWindow;
// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        var map = new HashMap<Character, Integer>();
        int counter = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                max = Math.max(max, counter);
                counter = 0;
                i = map.get(s.charAt(i)) + 1;
                map = new HashMap<>();
            }

            counter ++;
            map.put(s.charAt(i), i);
        }

        return Math.max(max, counter);
    }

    public static void main(String[] args) {
        var ans = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(ans.lengthOfLongestSubstring("pwwkew"));
    }
}
