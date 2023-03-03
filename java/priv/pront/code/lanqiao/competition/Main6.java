package priv.pront.code.lanqiao.competition;

import java.util.Scanner;

/**
 * @Description: 给定一天是一周中的哪天，请问 n 天后是一周中的哪天？
 * 输入格式
 * 　　输入第一行包含一个整数 w，表示给定的天是一周中的哪天，w 为 1 到 6 分别表示周一到周六，w 为 7 表示周日。
 * 　　第二行包含一个整数 n。
 * 输出格式
 * 　　输出一行包含一个整数，表示 n 天后是一周中的哪天，1 到 6 分别表示周一到周六，7 表示周日。
 * 样例输入
 * 6
 * 10
 * 样例输出
 * 2
 * @Author: pront
 * @Time:2023-03-03 10:07
 */
public class Main6 {

    static int[] arr = {1, 2, 3, 4, 5, 6, 7};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int howDay = scanner.nextInt();
        int days = scanner.nextInt();
        System.out.println(process(howDay, days));

    }


    public static int process(int howDay, int days) {
        int index = howDay - 1;
        int helpDay = days % arr.length;
        while (helpDay != 0) {
            helpDay--;
            if (index + 1 == arr.length) {
                index = 0;
            } else {
                index++;
            }
        }
        return arr[index];
    }
}
