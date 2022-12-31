package priv.pront.code.lanqiao.LG.P;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-12-01 21:11
 */
public class P1739 {


    private static boolean isValid(String value) {
        char[] str = value.toCharArray();
        int status = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ')' && --status < 0) {
                return false;
            }
            if (str[i] == '(') {
                status++;
            }
        }
        return status == 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String value = scan.nextLine();
        boolean lawful = isValid(value);
        System.out.println(lawful ? "YES" : "NO");
    }
}
