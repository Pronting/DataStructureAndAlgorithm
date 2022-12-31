package priv.pront.code.lanqiao.LG.B.recursion;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-12-31 15:47
 */
public class B2143 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(convertToBaseM(scanner.nextInt(), scanner.nextInt()));

    }
    public static String convertToBaseM(int x, int m) {
        if (x == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            int remainder = x % m;
            sb.append(intToChar(remainder));
            x = x / m;
        }
        return sb.reverse().toString();
    }

    private static char intToChar(int i) {
        if (i < 10) {
            return (char)(i + '0');
        } else {
            return (char)(i - 10 + 'A');
        }
    }
}
