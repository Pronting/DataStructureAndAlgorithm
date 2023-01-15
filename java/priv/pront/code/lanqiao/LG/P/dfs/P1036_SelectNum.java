package priv.pront.code.lanqiao.LG.P.dfs;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-01-15 10:47
 */
public class P1036_SelectNum {

    public static int k;
    public static int n;
    public static int[] nums;
    public static long res = 0;

    public static void main(String[] rags) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        //数组是从1开始存了，所以这里的第三个参数设置为1
        dfs(0, 0, 1);
        System.out.println(res);
    }

    /**
     * @param m     当前是第m个数
     * @param sum   1~m个数的和
     * @param index 当前开始的下标（从哪个数开始加）
     */
    public static void dfs(int m, int sum, int index) {
        if (m == k) {
            if (isPrime(sum)) {
                res++;
            }
            return;
        }
        for (int i = index; i <= n; i++) {
            dfs(m + 1, sum + nums[i], i + 1);
        }
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
