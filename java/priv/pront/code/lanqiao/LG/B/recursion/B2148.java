package priv.pront.code.lanqiao.LG.B.recursion;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-12-31 15:39
 */
public class B2148 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = f(scanner.nextDouble(), scanner.nextInt());
        System.out.printf("%.2f\n", result);
    }

    public static double f(double x, int n) {
        if (n == 1) {
            return x / (1 + x);
        }
        return x / (n + f(x, n - 1));
    }
}
