package priv.pront.code.lanqiao.LG.B.recursion;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-12-31 15:28
 */
public class B2147 {

//    FIXME
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double res = f(scanner.nextDouble(), scanner.nextInt());
        System.out.printf("%.2f\n", res);
    }

    private static double f(double x, int n) {
        if (n == 1) {
            return x;
        }
        return Math.sqrt(n + f(x, n - 1));
    }
}
