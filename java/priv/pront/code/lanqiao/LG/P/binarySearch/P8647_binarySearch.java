package priv.pront.code.lanqiao.LG.P.binarySearch;

import java.util.Scanner;

/**
 * @Description: 分巧克力
 * @Author: pront
 * @Time:2023-01-12 13:35
 */
public class P8647_binarySearch {

    private static int n, k;
    private static int[] w = new int[100001];
    private static int[] h = new int[100001];
    private static int N = 100001;

    //和是否满足k个小朋友分
    public static int getSum(int border) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + (w[i] / border) * (h[i] / border);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            h[i] = sc.nextInt();
        }
        int left = 0;
        int right = N;
        //进行二分查找
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (getSum(mid) >= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }
}
