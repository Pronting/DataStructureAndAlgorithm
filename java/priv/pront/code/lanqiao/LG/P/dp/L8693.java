package priv.pront.code.lanqiao.LG.P.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: 大胖子走迷宫
 * @Author: pront
 * @Time:2023-03-07 14:48
 */
public class L8693 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        char[][] grid = new char[n][n];
//        构建grid
        for (int i = 0; i < n; i++) {
            grid[i] = scanner.next().toCharArray();
        }
        System.out.println(process(k, grid));
    }

    public static int process(int kTime, char[][] grid) {
//        表示小明中心位置从起点走到dp[dp.length - 1][dp.length - 1] 所耗费的最小时间数量
        int[][] dp = new int[grid.length - 4][grid.length - 4];
        int flag = 0;
//        上、 下、 左、 右、 原地取最小值
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (dp[i][j] >= kTime && dp[i][j] < 2 * kTime) {
                    flag = 1;
                }
                if (dp[i][j] >= 2 * kTime) {
                    flag = 2;
                }
//                如果没有障碍物的情况下,上下左右四种情况
                if (i - 1 >= 0 && ((flag == 0 && grid[i - 1 + 3][j + 3] == '+' && grid[i - 1 + 3][j + 1 + 3] == '+' && grid[i - 1 + 3][j + 2 + 3] == '+') ||
                        (flag == 1 && grid[i - 1][j] == '+' && grid[i - 1 + 3][j + 1 + 3] == '+') || (flag == 2 && grid[i - 1 + 3][j + 3] == '+'))) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (i + 1 < dp.length && ((flag == 0 && grid[i + 1 + 3][j + 3] == '+' && grid[i + 1 + 3][j + 1 + 3] == '+' && grid[i + 1 + 3][j + 2 + 3] == '+') ||
                        (flag == 1 && grid[i + 1 + 3][j + 3] == '+' && grid[i + 1 + 3][j + 1 + 3] == '+') || (flag == 2 && grid[i + 1 + 3][j + 3] == '+'))) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j + 1 < dp.length && ((flag == 0 && grid[i + 3][j - 1 + 3] == '+' && grid[i + 1 + 3][j - 1 + 3] == '+' && grid[i + 2 + 3][j - 1 + 3] == '+') ||
                        (flag == 1 && grid[i + 3][j + 3] == '+' && grid[i + 1 + 3][j - 1 + 3] == '+') || (flag == 2 && grid[i + 3][j - 1 + 3] == '+'))) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                }
                if (j - 1 >= 0 && ((flag == 0 && grid[i + 3][j + 1 + 3] == '+' && grid[i + 1 + 3][j + 1 + 3] == '+' && grid[i + 2 + 3][j + 1 + 3] == '+') ||
                        (flag == 1 && grid[i + 3][j + 1 + 3] == '+' && grid[i - 1 + 3][j + 1 + 3] == '+') || (flag == 2 && grid[i + 3][j + 1 + 3] == '+'))) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1]);
                }
            }

        }
        return dp[dp.length - 1][dp.length - 1];
    }
}
