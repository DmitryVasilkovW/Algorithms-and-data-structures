package org.algorithmsAndDataStructures.arrayOrString;
// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=problem-list-v2&envId=string

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static int kmpMatcher(String s, String pattern) {
        int m = pattern.length();
        if (m == 0)
            return 0;

        int[] p = prefixFunction(pattern);

        for (int i = 0, k = 0; i < s.length(); i++) {
            for (; ; k = p[k - 1]) {
                if (pattern.charAt(k) == s.charAt(i)) {
                    if (++k == m) {
                        return i + 1 - m;
                    }
                    break;
                }
                if (k == 0) {
                    break;
                }
            }
        }

        return -1;
    }

    private static int[] prefixFunction(String pattern) {
        int n = pattern.length();
        var p = new int[n];

        for (int i = 1; i < n; i++) {
            int cur = p[i - 1];
            while (pattern.charAt(i) != pattern.charAt(cur) && cur > 0)
                cur = p[cur - 1];

            if (pattern.charAt(i) == pattern.charAt(cur))
                p[i] = cur + 1;
        }

        return p;
    }

    public int strStr(String haystack, String needle) {
        return kmpMatcher(haystack, needle);
    }

    public static void main(String[] args) {
        var s = new FindTheIndexOfTheFirstOccurrenceInAString();

        System.out.println(s.strStr("mississippi", "issip"));
    }
}
