package priv.pront.code.od;

import java.util.Scanner;

/**
 * 题目描述
 * 小明每周上班都会拿到自己的工作清单，工作清单内包含 n 项工作，每项工作都有对应的耗时时间（单位 h）和报酬，工作的总报酬为所有已完成工作的报酬之和，那么请你帮小明安排一下工作，保证小明在指定的工作时间内工作收入最大化。
 *
 * 输入描述
 * 输入的第一行为两个正整数 T，n。T 代表工作时长（单位 h， 0 < T < 1000000）， n 代表工作数量（ 1 < n ≤ 3000）。
 * 接下来是 n 行，每行包含两个整数 t，w。t 代表该工作消耗的时长（单位 h， t > 0），w 代表该项工作的报酬。
 *
 *
 * 输出描述
 * 输出小明指定工作时长内工作可获得的最大报酬。
 */
public class E2024_工作安排 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 总时间
        int n = sc.nextInt(); // 工作数量

        int[] dp = new int[T + 1];

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt(); // 时间
            int w = sc.nextInt(); // 收益

            // 0/1 背包：必须倒序
            for (int j = T; j >= t; j--) {
                dp[j] = Math.max(dp[j], dp[j - t] + w);
            }
        }

        System.out.println(dp[T]);
    }
}
