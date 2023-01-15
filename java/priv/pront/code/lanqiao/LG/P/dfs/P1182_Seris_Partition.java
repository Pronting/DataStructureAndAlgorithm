package priv.pront.code.lanqiao.LG.P.dfs;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-01-15 15:06
 */
public class P1182_Seris_Partition {

    public static int [] arr;
    public static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        arr = new int[N];
        int M = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(dfs(M, 0, 0));
    }

    private static int dfs(int part,int index,int sum) {
        if (part == 0) {
            return 0;
        }
        int maxValue = 0;
        for (int i = index; i < arr.length; i++) {
//            得到所有段的最大值
            maxValue = Math.max(maxValue, dfs(part - 1, i + 1, sum + arr[i]));
            res = Math.min(maxValue, res);
        }
        return sum;
    }
}
