package priv.pront.code.lanqiao.LG.B.recursion;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-12-31 15:21
 */
public class B2142 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getSumProcess(n));
    }

    private static int getSumProcess(int maxNum) {
        if (maxNum == 0) {
            return 0;
        }
        return maxNum + getSumProcess(maxNum - 1);
    }
}
