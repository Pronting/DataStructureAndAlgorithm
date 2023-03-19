package priv.pront.code.lanqiao.competition;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-20 11:05
 */
public class 瓷砖铺放 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int N = scanner.nextInt();
        int[] dp = new int[N];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[N - 1]);
    }
}
