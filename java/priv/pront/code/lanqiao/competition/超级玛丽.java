package priv.pront.code.lanqiao.competition;

import java.util.*;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-19 16:39
 */
public class 超级玛丽 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();// 长度为n
        int m = scanner.nextInt(); // 有m个陷阱
        List<Integer> trap = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            trap.add(scanner.nextInt());
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
//            走不动的情况下(两格都有陷阱)
            if (trap.contains(i) && trap.contains(i - 1) ) {
                System.out.println(0);
                return;
            } else if (trap.contains(i)) {
//            有陷阱
                dp[i] = 0;
            } else {
//            没有陷阱的情况下
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        System.out.println(dp[n]);
    }
}

/**
 * public static void main(String[] args) {
 *         Scanner sc = new Scanner(System.in);
 *         int n = sc.nextInt();
 *         int m = sc.nextInt();
 *         int[] a = new int[n + 1];// 记录陷阱的位置
 *         int[] dp = new int[n + 1];// 记录步数
 *         if (n >= 2) {
 *             dp[1] = dp[2] = 1;
 *         }
 *
 *         for (int i = 0; i < m; i++) {
 *             int x = sc.nextInt();
 *             if (x <= n) {
 *                 a[x] = 1;
 *                 dp[x] = 0;
 *             }
 *         }
 *         for (int i = 3; i <= n; i++) {
 *             if (a[i] != 1) {
 *                 dp[i] = dp[i - 1] + dp[i - 2];
 *             }
 *         }
 *         System.out.println(dp[n]);
 *     }
 *
 */
