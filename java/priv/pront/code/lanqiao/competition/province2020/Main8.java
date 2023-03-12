package priv.pront.code.lanqiao.competition.province2020;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: 在平面上有一些二维的点阵。
 * 这些点的编号就像二维数组的编号一样，从上到下依次为第 1 至第 n 行，
 * 从左到右依次为第 1 至第 m 列，每一个点可以用行号和列号来表示。
 * 现在有个人站在第 1 行第 1 列，要走到第 n 行第 m 列。只能向右或者向下
 * 走。
 * 注意，如果行号和列数都是偶数，不能走入这一格中。
 * 问有多少种方案。
 * @Author: pront
 * @Time:2023-03-12 14:54
 */
public class Main8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] dp = new int[row][col];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < row; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if ((i + 1) % 2 != 0 || (j + 1) % 2 != 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        System.out.println(dp[row - 1][col - 1]);
    }
}
