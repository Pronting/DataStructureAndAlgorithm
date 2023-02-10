package priv.pront.code.leetcode.dp;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-10 13:17
 */
public class L63_UniquePathsWithObstacles {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < dp.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                for (int j = i; j < dp.length; j++) {
                    dp[j][0] = 0;
                }
                break;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < dp[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                for (int j = i; j < dp[0].length; j++) {
                    dp[0][j] = 0;
                }
                break;
            } else {
                dp[0][i] = 1;
            }
        }

        if(dp[0][0] == 0){
            return 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0},
                {1, 1},
                {0, 0},
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}

