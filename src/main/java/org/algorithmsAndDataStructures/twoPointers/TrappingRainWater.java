package org.algorithmsAndDataStructures.twoPointers;
// https://leetcode.com/problems/trapping-rain-water/description/

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length < 3) return 0;

        int l = 0, r = height.length - 1;
        int maxL = 0, maxR = 0;
        int ans = 0;

        while (l <= r) {
            if (height[l] < height[r]) {
                maxL = Math.max(maxL, height[l]);
                ans += maxL - height[l];
                l++;
            } else {
                maxR = Math.max(maxR, height[r]);
                ans += maxR - height[r];
                r--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.print(new TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
