package priv.pront.code.lanqiao.LG.P.dfs;

import java.util.Scanner;

/**
 * @Description: 适用dfs完成全排列问题
 * @Author: pront
 * @Time:2023-01-28 18:01
 */
public class P1706_permutation_ans {

    static int n = 0;
    static int[] used = new int[100];
    static int[] pd = new int[100];

    private static void print() {
        for (int i = 1; i <= n; i++) {
            //保留五位常宽
            System.out.print("    " + used[i]);
        }
        System.out.println();
    }

    /**
     * DFS
     *
     * @param k 当前是第K格
     */
    private static void dfs(int k) {
        if (k == n) {
            print();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (pd[i] != 1) {
                pd[i] = 1;
                used[k + 1] = i;
                dfs(k + 1);
                pd[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        dfs(0);
    }
}
