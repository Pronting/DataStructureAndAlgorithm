package priv.pront.code.lanqiao.LG.P.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-01-16 10:35
 */
public class P1102_ABSubtraction {
//10 3
//        10 4 7 5 10 4 5 8 5 7
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int C = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int res = getNumPair(C, arr);
        System.out.println(res);
    }

    private static int getNumPair(int target, int[] arr) {
        int res = 0;
        for (int p2 = arr.length - 1; p2 >= 1; p2--) {
            int p3 = p2;
            int p1 = 0;
            while (p1 < p2) {
                if (arr[p2] - arr[p1] > target) {
                    p1++;
                } else if (arr[p2] - arr[p1] < target) {
                    p2--;
                } else {
                    res++;
                    p1++;
                }
            }
            p2 = p3;
        }
        return res;
    }

}
