package priv.pront.code.lanqiao.competition.course;

import java.util.Scanner;
//暴力
public class Main6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 2; i <= N; i++) {
            double sqrt = Math.sqrt(N * i);
            if (sqrt % 1 == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
