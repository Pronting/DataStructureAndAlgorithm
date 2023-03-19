package priv.pront.code.lanqiao.competition;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-20 10:54
 */
public class 时间转换 {

    static int second;
    static int minute;
    static int hour;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        hour = t / 3600;
        minute = t % 3600 / 60;
        second = t % 3600 % 60;
        System.out.println(hour + ":" + minute + ":" + second);

    }
}
