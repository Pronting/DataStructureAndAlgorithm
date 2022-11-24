package priv.pront.code.lanqiao.LG;

import java.util.Scanner;

/**
 * @Description: P1146 硬币反转
 * @Author: pront
 * @Time:2022-11-24 19:52
 */
public class P1146 {
    static int k = 0;

    private static char[] init(int k) {
        char[] chs = new char[k];
        for (int i = 0; i < chs.length; i++) {
            chs[i] = '1';
        }
        return chs;
    }

    private static void process(char[]chs,int curCoin) {
        if (curCoin >= chs.length) {
            return;
        }
        for (int i = curCoin; i < chs.length; i++) {
            chs[i] = '0';
        }
        for (int i = 0; i < chs.length; i++) {
            System.out.print(chs[i] + " ");
        }
        System.out.println();
        process(chs, curCoin + 1);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        char[] chs = init(k);
        process(chs, 1);
    }
}
