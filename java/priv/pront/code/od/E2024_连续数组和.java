package priv.pront.code.od;

import java.util.Scanner;

public class E2024_连续数组和 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int l = 0, r = 0;
        long sum = 0;
        long ans = 0;

        while (l < n) {

            // 扩大右边界直到满足条件
            while (r < n && sum < x) {
                sum += arr[r++];
            }

            // 当前以及后面的右端点都满足
            if (sum >= x) {
                ans += n - r + 1;
            }

            // 左端点右移
            sum -= arr[l++];
        }

        System.out.println(ans);
    }
}
