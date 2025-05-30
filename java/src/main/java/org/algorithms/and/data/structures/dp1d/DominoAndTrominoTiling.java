package org.algorithms.and.data.structures.dp1d;
// https://leetcode.com/problems/domino-and-tromino-tiling/description/?envType=study-plan-v2&envId=leetcode-75

public class DominoAndTrominoTiling {
    public int numTilings(int n) {
        long[] dp = new long[4];

        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 5;

        int cur = n - 1;
        for (int i = 3; i < n; i++) {
            cur = i % 4;
            dp[cur] = (2 * dp[(cur + 3) % 4] + dp[(cur + 1) % 4]) % 1000000007;
        }

        return (int)dp[cur];
    }

    public static void main(String[] args) {
        System.out.println(new DominoAndTrominoTiling().numTilings(5));
    }
}
