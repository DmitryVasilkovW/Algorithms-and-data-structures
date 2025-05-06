package org.algorithms.and.data.structures.array.or.string;
// https://leetcode.com/problems/non-decreasing-array/description/

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }

        int count = 0;
        int mod = -1;
        int val = 0;
        for (int r = 1, l = 0; r < nums.length; r++, l++) {
            if (nums[r] < nums[l]) {
                count ++;
                if (count > 1) break;

                val = nums[r];
                mod = r;
                nums[r] = nums[l];
                r = 0;
                l = -1;
            }
        }

        if (mod > 0) nums[mod] = val;

        if (count < 2) return true;

        count = 0;
        for (int r = 1, l = 0; r < nums.length; r++, l++) {
            if (nums[r] < nums[l]) {
                count ++;
                if (count > 1) break;

                nums[l] = nums[r];
                r = 0;
                l = -1;
            }
        }

        return count < 2;
    }

    public static void main(String[] args) {
        System.out.println(new NonDecreasingArray().checkPossibility(new int[]{3,4,2,3}));
    }
}
