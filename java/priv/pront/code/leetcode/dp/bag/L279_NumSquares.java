package priv.pront.code.leetcode.dp.bag;

import java.util.Arrays;

/**
 * @Description: 完全背包问题 ： 装满背包最小物品个数
 * @Author: pront
 * @Time:2023-03-02 19:37
 */
public class L279_NumSquares {

    public int numSquares(int n) {
        // 开平方最大整数
        int max = (int) Math.sqrt(n);
        // 凑成 j 的完全平方数的最小数量为 dp[j]
        int[] dp = new int[n + 1];
        // 初始化：除了第一个元素，其他下标元素初始化为最大值，防止获取后面值时被小值覆盖
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 平方数【物品重量】
        for (int i = 1; i <= max; i++) {
            // 平方数
            int weight = i * i;
            // 背包容量
            for (int j = weight; j <= n; j++) {
                // 如果数量为初始值直接跳过
                if (dp[j - weight] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - weight] + 1);
                }
            }
        }
        return dp[n];
    }
}
