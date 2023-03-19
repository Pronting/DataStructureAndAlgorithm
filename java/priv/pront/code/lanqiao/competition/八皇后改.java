package priv.pront.code.lanqiao.competition;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-19 17:30
 */
public class 八皇后改 {

    static int max = 8;
    static int maxSum = 0;
    static int[] arr = new int[max];
    static int[][] grid = new int[8][8];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        putQueen(0);
        System.out.println(maxSum);
    }

    private static  void putQueen(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)) {
                putQueen(n + 1);
            }
        }
    }

    private static boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[i] - arr[n])) {
                return false;
            }
        }
        return true;
    }

    private static void print() {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += grid[i][arr[i]];
        }
        maxSum = Math.max(maxSum, sum);
    }
}
