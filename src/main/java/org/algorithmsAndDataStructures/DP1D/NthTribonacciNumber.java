package org.algorithmsAndDataStructures.DP1D;
// https://leetcode.com/problems/n-th-tribonacci-number/?envType=study-plan-v2&envId=leetcode-75

public class NthTribonacciNumber {
    public int tribonacci(int n) {
        var dp = new int[n + 1];

        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        NthTribonacciNumber nth = new NthTribonacciNumber();
        System.out.println(nth.tribonacci(25));
    }
}
