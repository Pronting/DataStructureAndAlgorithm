package priv.pront.code.lanqiao.LG.P.binarySearch;

import java.util.*;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-01-11 19:31
 */
public class P1873 {


    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int target = scanner.nextInt();
//        int number = scanner.nextInt();
//        int[] arr = new int[number];
//        for (int i = 0; i < number; i++) {
//            arr[i] = scanner.nextInt();
//        }
        int[] arr = {20, 15, 10, 17};
        int target = 7;
        int number = 4;
        Arrays.sort(arr);
//        int height1 = getMaxHeight1(arr, target, arr[number - 1]);
//        System.out.println(height1);


        int height2 = getMaxHeight2(arr, target);
        System.out.println(height2);
    }

    private static int getMaxHeight1(int[] arr, int t, int curMaxHeight) {
        if (curMaxHeight <= 0) {
            return -1;
        }
        int curSum = 0;
        for (int j : arr) {
            curSum += Math.max(0, j - curMaxHeight);
        }
        if (curSum >= t) {
            return curMaxHeight;
        }
        return getMaxHeight1(arr, t, --curMaxHeight);
    }


    private static int getMaxHeight2(int[] arr, int t) {
        int sum = 0;
        int l = arr[0];
        int n = arr.length - 1;
        int r = arr[n];
        while (l <= r) {
            int mid = getMid(l, r);
            for (int j : arr) {
                sum += (Math.max(0, j - mid));
            }
            if (sum > t) {
//            向上找
                l = mid;
            } else if (sum < t) {
//           向下找
                r = --mid;
            } else {
                return mid;
            }
        }
        return l;
    }


    private static int getMid(int l, int r) {
        if (l == 0 || r == 0) {
            return (r + l) / 2;
        }
        return (r - l) / 2 + l;
    }
}
