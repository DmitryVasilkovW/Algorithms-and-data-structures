package org.algorithmsAndDataStructures.TwoPointers;
// https://leetcode.com/problems/valid-palindrome/description/

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int l = 0, r = str.length() - 1;

        while (l <= r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
