package priv.pront.code.leetcode.dp;

import java.util.Arrays;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-10 12:11
 */
public class L62_UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++){
            dp[i][0] = 1;
        }
        for(int i = 0; i< n;i++){
            dp[0][i] = 1;
        }
        for(int i = 1;i< m;i++){
            for(int j = 1;j< n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    // 状态压缩
    public static int uniquePaths2(int m, int n) {
        int[] dp = new int[m];
        Arrays.fill(dp,1);
        for(int i = 0;i < n - 1;i++){
            for(int j = 1;j< m;j++){
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[m-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
        System.out.println(uniquePaths2(3, 7));
    }
}
