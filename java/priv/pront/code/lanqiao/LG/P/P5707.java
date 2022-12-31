package priv.pront.code.lanqiao.LG.P;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @Description: 洛谷算法中心p5707
 * @Author: pront
 * @Time:2022-10-30 20:58
 */
public class P5707 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int s = scan.nextInt();
        int v = scan.nextInt();

        final int endHour = 8;
        final int endTimeMinimum = 0;
        final int allDay = 24;
        boolean isUpDigit = false;


//        basic time
        int tm = s % v == 0 ? (s / v + 10) : (s / v) + 11;

        int th = endTimeMinimum - tm / 60;

        tm %= 60;

        if (th > endHour + allDay) {
            return;
        }


        if (endTimeMinimum - tm < 0 && th > 0) {
            th -= 1;
        }

        if (endTimeMinimum - tm < 0) {
            tm = (60 - Math.abs(endTimeMinimum - tm));
            isUpDigit = true;
        } else {
            tm = (endTimeMinimum - tm);
        }


        th = th > 8 ? 24 - (Math.abs(endHour - th)) : (endHour - th);
        th = isUpDigit ? th - 1 : th;


        System.out.print(th > 9 ? th : "0" + th);
        System.out.print(":");
        System.out.println(tm > 9 ? tm : "0" + tm);
    }







    private static void getBeginTime(int s, int v) {
        final int endHour = 8;
        final int endTimeMinimum = 0;
        final int allDay = 24;
        boolean isUpDigit = false;


//        basic time
        int tm = s % v == 0 ? (s / v + 10) : (s / v) + 11;

        int th = endTimeMinimum - tm / 60;

        tm %= 60;

        if (th > endHour + allDay) {
            return;
        }


        if (endTimeMinimum - tm < 0 && th > 0) {
            th -= 1;
        }


        if (endTimeMinimum - tm < 0) {
            tm = (60 - Math.abs(endTimeMinimum - tm));
            isUpDigit = true;
        } else {
            tm = (endTimeMinimum - tm);
        }


        th = th > 8 ? 24 - (Math.abs(endHour - th)) : (endHour - th);
        th = isUpDigit ? th - 1 : th;


        System.out.print(th > 9 ? th : "0" + th);
        System.out.print(":");
        System.out.println(tm > 9 ? tm : "0" + tm);
    }


}
