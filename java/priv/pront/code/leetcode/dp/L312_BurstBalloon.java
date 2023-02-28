package priv.pront.code.leetcode.dp;

/**
 * @Description:  dp范围上的尝试 难
 * @Author: pront
 * @Time:2023-02-28 21:09
 */
public class L312_BurstBalloon {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] points = new int[n+2];
        points[0] = points[n+1] = 1;
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i-1];
        }

        int[][] dp = new int[n+2][n+2];
        for (int len = 3; len <= n+2; len++) {
            for (int i = 0; i <= n+2-len; i++) {
                int j = i + len - 1;
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i]*points[k]*points[j]);
                }
            }
        }
        return dp[0][n+1];
    }
}
