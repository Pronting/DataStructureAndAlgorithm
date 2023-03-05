package priv.pront.code.lanqiao.teach;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-02 09:49
 */
public class GetTrangelMaxSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();

        // 构建二维数组
        int[][] triangle = new int[row][];
        for (int i = 0; i < row; i++) {
            int[] arr = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                arr[j] = scanner.nextInt();
            }
            triangle[i] = arr;
        }

        int sum = getMaxSum(triangle, row);
        System.out.println(sum);
    }

    private static int getMaxSum(int[][] triangle, int row) {
        if (triangle.length == 0) {
            return 0;
        }

        // 初始化 dp
        int[][] dp = new int[row][row];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {  // 最左边的点只依赖上面的点
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == i) {  // 最右边的点只依赖上面的点左上角的点
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {  // 中间的点依赖上面的点左上角的点和右上角的点
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }

        // 找到最后一行中的最大值
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            res = Math.max(res, dp[row - 1][i]);
        }
        return res;
    }
}
