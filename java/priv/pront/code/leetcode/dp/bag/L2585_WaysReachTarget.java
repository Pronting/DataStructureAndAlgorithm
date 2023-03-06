package priv.pront.code.leetcode.dp.bag;

/**
 * @Description: 多重背包
 * @Author: pront
 * @Time:2023-03-06 21:45
 */
public class L2585_WaysReachTarget {

    public int waysToReachTarget(int target, int[][] types) {
        int mod = 1000000007;
        int n = types.length;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            int count = types[i - 1][0];
            int mark = types[i - 1][1];
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; k <= count; k++) {
                    if (j >= k * mark) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k * mark]) % mod;
                    } else {
                        break;
                    }
                }
            }
        }
        return dp[n][target];
    }
}
