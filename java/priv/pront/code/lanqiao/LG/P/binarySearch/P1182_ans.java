package priv.pront.code.lanqiao.LG.P.binarySearch;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-01-15 15:31
 */
public class P1182_ans {

    public static int[] arr;
    public static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        int l = 0, r = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            r = r + arr[i];//r取arr的总和
            l = l < arr[i] ? arr[i] : l;//l取arr[]里的最大值
        }
        //对arr最大的数l和arr的总和r进行二分,因为分成不同段后的最大值的最小值肯定大于l,即处在l和r之间,进行二分即可
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid)) {//如果能分成的段大于M,说明mid比较小,这时就说明目标比mid大所以在mid右边
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        System.out.println(l);
    }

    public static boolean check(int mid) {
        int sum = 0, d = 1;// sum代表每一段的和,d代表有几段
        for (int i = 0; i < N; i++) {//看看能分成几段
            if (sum + arr[i] <= mid) {
                sum = sum + arr[i];
            } else {
                sum = arr[i];
                d++;
            }
        }
        return d > M;
    }
}
