package priv.pront.code.lanqiao.LG.B.recursion;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-12-31 18:17
 */
public class B2144 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(akm(scanner.nextInt(), scanner.nextInt()));
    }

    private static int akm(int m, int n) {
        if (m == 0) {
            return n + 1;
        }
        if (m > 0 && n == 0) {
            return akm(m - 1, 1);
        }
        return akm(m - 1, akm(m, n - 1));

    }
}
