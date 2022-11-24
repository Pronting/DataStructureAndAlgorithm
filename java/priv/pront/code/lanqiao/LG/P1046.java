package priv.pront.code.lanqiao.LG;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-11-24 18:07
 */
public class P1046 {

    private static int getMaxApple(int[] apples, int maxHeight) {
        int curHeight = maxHeight + 30;
        int res = 0;
        for (int i = 0; i < apples.length; i++) {
            if (curHeight >= apples[i]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int index = 0;
        int[] arr = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            arr[index++] = scanner.nextInt();
        }
        int s = scanner.nextInt();
        System.out.println(getMaxApple(arr, s));

    }
}
