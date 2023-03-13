package priv.pront.code.lanqiao.competition.province2021;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-13 15:37
 */

//直接调用库函数即可
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long time = scanner.nextLong() - 1000 * 60 * 60 * 8;
        String res =  new SimpleDateFormat("HH:mm:ss").format(time);
        System.out.println(res);

    }
}
