package priv.pront.code.leetcode.dp;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-27 19:31
 */
public class L64_MinPathSum {

    public static  int minPathSum(int[][] grid) {
        if(grid.length == 1 && grid[0].length == 1){
            return 0;
        }

        int[] dp = new int[grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < dp.length; j++){
                if(j - 1 >= 0 && i - 1 >= 0){
                    dp[j] = Math.min(dp[j],dp[j - 1]) + grid[i][j];
                }else if(j - 1 < 0){
                    dp[j] = dp[j] + grid[i][j];
                } else if (i - 1 < 0) {
                    dp[j] = dp[j - 1] + grid[i][j];
                }

            }
        }
        return dp[dp.length - 1];

    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));

    }
}
