package priv.pront.code.lanqiao.competition.course;

import java.util.Scanner;

public class 特别数的和 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            String j = i + "";
            if (j.contains("2") || j.contains("0") || j.contains("1") || j.contains("9")) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
