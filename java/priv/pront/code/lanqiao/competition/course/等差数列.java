package priv.pront.code.lanqiao.competition.course;

import java.util.Arrays;
import java.util.Scanner;

public class 等差数列 {

    public static void main(String[] args) {
        int min = Integer.MAX_VALUE;
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(min, arr[i + 1] - arr[i]);
        }
        System.out.println(((arr[arr.length - 1] - arr[0]) / min) + 1);
    }
}
