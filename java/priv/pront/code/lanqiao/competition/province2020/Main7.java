package priv.pront.code.lanqiao.competition.province2020;

import java.util.Scanner;

/**
 * @Description: 有一个序列，序列的第一个数是 n，后面的每个数是前一个数整除 2，请输
 * 出这个序列中值为正数的项。
 * @Author: pront
 * @Time:2023-03-12 14:50
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        while (n > 0) {
            System.out.println(n);
            n /= 2;
        }
    }
}
