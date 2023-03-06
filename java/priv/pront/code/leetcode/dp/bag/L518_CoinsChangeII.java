package priv.pront.code.leetcode.dp.bag;

/**
 * @Description: 完全背包
 * @Author: pront
 * @Time:2023-03-06 21:40
 */
public class L518_CoinsChangeII {

//    一维版本
    public int change(int amount, int[] coins) {
        int[] f = new int[amount + 1];
        f[0] = 1; //f[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            int v = coins[i - 1];
            for (int j = v; j <= amount; j++) {
                f[j] += f[j - v];
            }
        }
        return f[amount];
    }


//    二维版本
public int change2(int amount, int[] coins) {
    int[][] dp = new int[coins.length + 1][amount + 1];
//     使用0种货币，凑0元钱,也是一种方案
    for(int i = 0; i < coins.length + 1;i++){
        dp[i][0] = 1;
    }
    for(int i = 1; i <= coins.length; i++){
        for(int j = 1; j <= amount; j++){
            for(int k = 0; k * coins[i - 1] <= j; k++){
                dp[i][j] += dp[i - 1][j - k * coins[i - 1]];
            }

        }
    }
    return dp[coins.length][amount];
}
}
