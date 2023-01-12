package priv.pront.code.lanqiao.LG.P.binarySearch;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-01-12 16:01
 */
public class P2249_ans {


    static int[] arr;
    static int res;
    static int n;
    static int m;

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        arr = new int[n + 1];
        arr[0] = -1;//有可能会要查找等于0的数,所以把第一个改成-1
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 1; i <= m; i++) {
            res = binary(scanner.nextInt());
            System.out.print(res + " ");
        }
    }


    public static int binary(int dest) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= dest) {// 如果中间值大于等于目标值就继续往左边找
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (arr[l] == dest) {
            return l;
        } else {
            return -1;
        }
    }
}
