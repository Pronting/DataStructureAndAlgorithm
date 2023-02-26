package priv.pront.code.lanqiao.LG.P.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-26 12:50
 */
public class P1443 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int startRowIndex = scanner.nextInt();
        int startColIndex = scanner.nextInt();
        process(row, col, startRowIndex, startColIndex);
    }

    public static void process(int row, int col, int startRowIndex, int startColIndex) {
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], 1000);
        }
        dp[startRowIndex - 1][startColIndex - 1] = 0;
//          最多 5 步
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (dp[j][k] != 1000) {
                        continue;
                    }
//                    左上角2个
                    dp[j][k] = (j - 1 >= 0 && k - 2 >= 0 && dp[j - 1][k - 2] != 1000) ? Math.min(dp[j - 1][k - 2], dp[j][k]) + 1 : dp[j][k];
                    dp[j][k] = (j - 2 >= 0 && k - 1 >= 0 && dp[j - 2][k - 1] != 1000) ? Math.min(dp[j][k], dp[j - 2][k - 1]) + 1 : dp[j][k];
//                  左下角2个
                    dp[j][k] = (j + 1 < row && k - 2 >= 0 && dp[j + 1][k - 2] != 1000) ? Math.min(dp[j][k], dp[j + 1][k - 2]) + 1 : dp[j][k];
                    dp[j][k] = (j + 2 < row && k - 1 >= 0 &&dp[j + 2][k - 1] != 1000) ? Math.min(dp[j][k], dp[j + 2][k - 1]) + 1 : dp[j][k];
//                    右下角2个
                    dp[j][k] = (j + 2 < row && k + 1 < col && dp[j + 2][k + 1] != 1000) ? Math.min(dp[j][k], dp[j + 2][k + 1]) + 1 : dp[j][k];
                    dp[j][k] = (j + 1 < row && k + 2 < col && dp[j + 1][k + 2] != 1000) ? Math.min(dp[j][k], dp[j + 1][k + 2]) + 1 : dp[j][k];
//                    右上角2个
                    dp[j][k] = (j - 1 >= 0 && k + 2 < col && dp[j - 1][k + 2] != 1000) ? Math.min(dp[j][k], dp[j - 1][k + 2]) + 1 : dp[j][k];
                    dp[j][k] = (j - 2 >= 0 && k + 1 < col && dp[j - 2][k + 1] != 1000) ? Math.min(dp[j][k], dp[j - 2][k + 1]) + 1 : dp[j][k];
                }
            }
        }

//        update
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = dp[i][j] == 1000 ? -1 : dp[i][j];
            }
        }

//        print
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();

        }
    }
}
