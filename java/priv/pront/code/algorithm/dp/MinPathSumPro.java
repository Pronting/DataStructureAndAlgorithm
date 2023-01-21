package priv.pront.code.algorithm.dp;

import priv.pront.constants.MatrixUtils;

/**
 * @Description: 最短路径和pro版本
 * @Author: pront
 * @Time:2023-01-18 11:44
 */
public class MinPathSumPro {

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            int[][] matrix = MatrixUtils.generateMatrix(10, 10);
            if (main(matrix) != getMinPathCompression(matrix, matrix.length, matrix[0].length)
                    || main(matrix) != getMinPathCompression(matrix, matrix.length, matrix[0].length)
            || getMinPathForDP(matrix, matrix.length, matrix[0].length) != getMinPathCompression(matrix, matrix.length, matrix[0].length)) {
                System.out.println("Ooops!");
                break;
            }
        }
    }

    private static int main(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        return getMinPathForRecursion(matrix, 0, 0, 0);
    }

    private static int getMinPathForRecursion(int[][] matrix, int curRow, int curCol, int pre) {

        if (curRow > matrix.length - 1 || curCol > matrix[0].length - 1) {
            return pre;
        }
        int curSum = pre + matrix[curRow][curCol];
        return Math.min(getMinPathForRecursion(matrix, curRow, curCol + 1, curSum),
                getMinPathForRecursion(matrix, curRow + 1, curCol, curSum));

    }

    private static int getMinPathForDP(int[][] matrix, int row, int col) {
        int[][] dp = new int[row][col];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = matrix[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = matrix[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(matrix[i][j] + dp[i - 1][j], matrix[i][j] + dp[i][j - 1]);
            }
        }
        return dp[row - 1][col - 1];
    }

    private static int getMinPathCompression(int[][] matrix, int row, int col) {
        int dp[] = new int[col];
        dp[0] = matrix[0][0];
//        先将第一行的数据初始化
        for (int i = 1; i < col; i++) {
            dp[i] = matrix[0][i] + dp[i - 1];
        }
//        利用第一行的数据滚动更新下去
        for (int i = 1; i < row; i++) {
            dp[0] = dp[0] + matrix[i][0];
            for (int j = 1; j < col; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + matrix[i][j];
            }
        }
        return dp[col - 1];
    }
}
