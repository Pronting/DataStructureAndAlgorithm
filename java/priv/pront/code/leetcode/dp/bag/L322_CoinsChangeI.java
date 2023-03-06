package priv.pront.code.leetcode.dp.bag;

import java.util.Arrays;

/**
 * @Description: 完全背包
 * @Author: pront
 * @Time:2023-03-06 21:39
 */
public class L322_CoinsChangeI {

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
