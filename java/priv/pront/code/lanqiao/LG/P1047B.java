package priv.pront.code.lanqiao.LG;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-11-24 18:59
 */
public class P1047B {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int l = scan.nextInt();
        int[] arr = new int[l];
        int count = 0;
        int m = scan.nextInt();
        for (int i = 0; i < m; i++) {
            int begin = scan.nextInt();
            int end = scan.nextInt();
            for (int j = begin; j <= end; j++) {
                arr[j] = 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }

        System.out.println(count + 1);
    }
}
