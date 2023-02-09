package priv.pront.code.leetcode.dp;

import com.sun.org.apache.bcel.internal.generic.DCONST;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-09 16:12
 */
public class L746_MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));
    }
}
