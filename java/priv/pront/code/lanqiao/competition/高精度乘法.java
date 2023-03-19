package priv.pront.code.lanqiao.competition;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-19 16:23
 */
public class 高精度乘法 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.next();
        BigInteger res = new BigInteger(s).multiply(new BigInteger(t));
        System.out.println(res);
    }
}
