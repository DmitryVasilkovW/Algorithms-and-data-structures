package org.algorithms.and.data.structures.d.p1d;
// https://leetcode.com/problems/house-robber/?envType=study-plan-v2&envId=leetcode-75

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;

        for (int num : nums) {
            int tmp = prev1;

            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }

    public static void main(String[] args) {
        System.out.print(new HouseRobber().rob(new int[]{2,1,1,2}));
    }
}
