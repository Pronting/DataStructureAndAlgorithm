package priv.pront.code.lanqiao.LG.P.binarySearch;

import java.util.Scanner;

/**
 * @Description: 木材加工
 * @Author: pront
 * @Time:2023-01-12 14:24
 */
public class P2440 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(getMaxTreeHeight(n, k, arr));
    }

    private static int getMaxTreeHeight(int n, int k, int[] arr) {
        int l = 0;
        int r = (int) Math.pow(10, 8);

        while (l < r) {
            int mid = getMid(l, r);
            if (getSum(arr, n, mid) >= k) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l < 1 ? 0 : l;
    }

    private static int getSum(int[] arr, int n, int height) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i] / height;
        }
        return sum;
    }

    private static int getMid(int l, int r) {
        return l == 0 ? r / 2 : l + (r - l + 1) / 2;
    }
}
