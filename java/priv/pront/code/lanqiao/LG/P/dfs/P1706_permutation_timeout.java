package priv.pront.code.lanqiao.LG.P.dfs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description: 适用dfs完成全排列问题
 * @Author: pront
 * @Time:2023-01-28 18:01
 */
// FIXME timeout
public class P1706_permutation_timeout {
    public static int[] res, is;
    public static List<Integer> l = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        res = new int[n + 1];
        is = new int[n + 1];
        dfs(0, n);
    }

    public static void dfs(int k, int n) {
        if (k == n) {
            p(n);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (is[i] != 1) {
                is[i] = 1;
                res[k + 1] = i;
                dfs(k + 1, n);
                is[i] = 0;
            }
        }
    }

    public static void p(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.printf("%5d", res[i]);
        }
        System.out.println();
    }
}
