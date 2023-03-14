package priv.pront.code.lanqiao.competition.province2021;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-14 13:43
 */
public class Main8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bracket = scanner.next();
        int sum = 0;
        int res = 0;
        int[] arr = new int[bracket.length()];
        int index = 0;
        for (int i = 0; i < bracket.length(); i++) {
            if (bracket.charAt(i) == '(') {
                arr[index++] = 1;
                sum++;
            } else if (bracket.charAt(i) == ')') {
                arr[index++] = -1;
                sum--;
            }
        }
        int count = Math.abs(sum);
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                res++;
            }
        }
    }
}
