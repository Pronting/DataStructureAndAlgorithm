package priv.pront.code.lanqiao.competition.course;

import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int cur = (i * i) % n;
            if (cur < n / 2.0) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
