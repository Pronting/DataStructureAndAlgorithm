package priv.pront.code.lanqiao.LG;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-12-01 21:30
 */
public class P1044 {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(getStackCount(0, n, 18));
    }

    /**
     * dp
     *
     * @param x 栈内的元素
     * @param y 栈外的元素
     * @param n 元素总数
     * @return dp
     */
    private static int getStackCount(int x, int y, int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
//            将第0行的元素全填1
            dp[0][i] = 1;
        }
//        row  y
        for (int i = 1; i < dp.length; i++) {
//            col x
            for (int j = 0; j < dp[0].length; j++) {
                if (j - 1 < 0) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else if (j == dp[0].length-1) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j + 1] + dp[i][j - 1];
                }
            }
        }
        return dp[y][x];
    }

}
