package priv.pront.code.leetcode.dp;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-02 19:05
 */
public class L221_MaxiMalSquare {

    public static int maximalSquare(char[][] matrix) {
        if(matrix.length == 1){
            return matrix[0][0];
        }

        int maxBorder = Integer.MIN_VALUE;

        int[][] dp = new int[matrix.length][matrix[0].length];

        dp[0][0] = matrix[0][0] == '1' ? 1 : 0 ;
        for(int i = 1; i < matrix[0].length; i++){
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            maxBorder = Math.max(maxBorder,dp[0][i]);
        }

        for(int i = 1; i < matrix.length; i++){
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            maxBorder = Math.max(maxBorder,dp[i][0]);
        }

        for(int i = 1; i< matrix.length; i++){
            for(int j = 1 ; j < matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),dp[i - 1][j - 1]) + 1;
                    maxBorder = Math.max(maxBorder,dp[i][j]);
                }
            }
        }
        return maxBorder * maxBorder;
    }

    public static void main(String[] args) {

        char[][] arr1 = {{'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}};

        char[][] arr2 = {
                {'0', '1'},
                {'1', '0'}
        };
        System.out.println(maximalSquare(arr2));
    }
}
