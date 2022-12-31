package priv.pront.code.lanqiao.LG.P;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-11-23 18:46
 */
public class P1463 {
    static int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 21, 23};
    static int cnt = 0;
    static int res = 0;
    static int n = 0;

    private static void dfs(int u, int last, int p, int s) {
        if (cnt < s || cnt == s && p > res) {
            cnt = s;
            res = p;
        }
        if (u == 9) {
            return;
        }
        for (int i = 1; i < last; i++) {
            if (p * prime[u] > n) {
                break;
            }
            p *= prime[u];
            dfs(u + 1, i, p, s * (i + 1));
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int ys = scan.nextInt();
        int xiaobiao = scan.nextInt();
        int zhishu = scan.nextInt();
        dfs(m, ys, xiaobiao, zhishu);
    }

}
