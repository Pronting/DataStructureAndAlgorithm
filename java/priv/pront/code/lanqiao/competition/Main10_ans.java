package priv.pront.code.lanqiao.competition;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-03 17:52
 */
public class Main10_ans {

    static int maxValue = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if (n == 1 && m == 1) {
            System.out.println(0);
            return;
        }
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                backtracking(matrix, visited, i, j, Integer.MAX_VALUE, 0);
            }
        }
        System.out.println(maxValue);
    }

    public static void backtracking(int[][] matrix, boolean[][] visited, int rowIndex, int columnIndex, int pre, int value) {
        if (visited[rowIndex][columnIndex] || matrix[rowIndex][columnIndex] >= pre) {
            maxValue = Math.max(value, maxValue);
            return;
        }
        visited[rowIndex][columnIndex] = true;
        value++;
        if (matrix[rowIndex][columnIndex] < pre) {
            pre = matrix[rowIndex][columnIndex];
        }
        if (rowIndex - 1 >= 0) {
            backtracking(matrix, visited, rowIndex - 1, columnIndex, pre, value);
        }
        if (rowIndex + 1 < matrix.length) {
            backtracking(matrix, visited, rowIndex + 1, columnIndex, pre, value);
        }
        if (columnIndex - 1 >= 0) {
            backtracking(matrix, visited, rowIndex, columnIndex - 1, pre, value);
        }
        if (columnIndex + 1 < matrix[0].length) {
            backtracking(matrix, visited, rowIndex, columnIndex + 1, pre, value);
        }
        visited[rowIndex][columnIndex] = false;
    }
}
