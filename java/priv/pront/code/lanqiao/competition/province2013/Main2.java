package priv.pront.code.lanqiao.competition.province2013;

import java.util.Scanner;

/**
 * @Description: 带分数
 * @Author: pront
 * @Time:2023-03-15 14:37
 */
public class Main2 {

    static int ans = 0;
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        f(arr, 0,N);
        System.out.println(ans);
    }

    private static void f(int[] arr, int k,int N) {
        if (k == 9) {
//            全部确认
            check(arr, N);
            return;
        }
        for (int i = k; i < arr.length; i++) {
            int t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;

//            移交下一层去确认k + 1位
            f(arr, k + 1, N);

            t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;
        }
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i +" ");
        }
        System.out.println();
    }

    private static int check(int[] arr, int N) {
//        加号前面的字符数量
        for (int i = 1; i <= 7; i++) {
            int num1 = parseInt(arr, 0, i);
            if (num1 >= N) {
                continue;
            }
//            除号前面的字符数量
            for (int j = 1; j <= 8 - i; j++) {
                int num2 = parseInt(arr, i, j);
                int num3 = parseInt(arr, i + j, 9 - i - j);
                if (num2 % num3 == 0 && num1 + num2 / num3 == N) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private static int parseInt(int[] arr, int startIndex, int length) {
        int res = 0;
        int i = 1;
        for (int j = startIndex + length - 1; j >= startIndex; j--) {
            res += i * arr[j];
            i *= 10;
        }
        return res;
    }
}
