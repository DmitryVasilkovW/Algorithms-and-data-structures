package org.algorithmsAndDataStructures.hashMapORSet;
// https://leetcode.com/problems/group-anagrams/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<HashMap<Character, Integer>, List<String>>();
        var ans = new ArrayList<List<String>>();

        for (String str : strs) {
            var tmp = new HashMap<Character, Integer>();

            for (char c : str.toCharArray()) {
                tmp.put(c, tmp.getOrDefault(c, 0) + 1);
            }

            List<String> tempList = map.getOrDefault(tmp, new ArrayList<>());
            tempList.add(str);
            map.put(tmp, tempList);
        }

        for (var val : map.values()) {
            ans.add(val);
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }
}
