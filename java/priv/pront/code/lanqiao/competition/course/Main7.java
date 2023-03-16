package priv.pront.code.lanqiao.competition.course;

import java.util.Scanner;

public class Main7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long S = 0;
        int n = scanner.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                S += arr[i] * arr[j];
            }
        }
        System.out.println(S);
    }
}
