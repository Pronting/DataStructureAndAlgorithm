package priv.pront.code.lanqiao.competition.course;

import java.util.Scanner;

public class 特殊年份 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        for (int i = 0; i < 5; i++) {
            int n = scanner.nextInt();
            int qian = n / 1000;
            int shi = n % 1000 % 100 / 10;
            int bai = n % 1000 / 100;
            int ge = n % 1000 % 100 % 10;
            if(qian == shi && ge == bai + 1){
                count++;
            }
        }
        System.out.println(count);

    }
}
