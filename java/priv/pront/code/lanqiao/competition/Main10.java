package priv.pront.code.lanqiao.competition;

import java.util.Scanner;

/**
 * @Description: 小蓝准备在一个空旷的场地里面滑行，这个场地的高度不一，小蓝用一个 n 行 m 列的矩阵来表示场地，矩阵中的数值表示场地的高度。
 * 　　如果小蓝在某个位置，而他上、下、左、右中有一个位置的高度（严格）低于当前的高度，小蓝就可以滑过去，滑动距离为 1 。
 * 　　如果小蓝在某个位置，而他上、下、左、右中所有位置的高度都大于等于当前的高度，小蓝的滑行就结束了。
 * 　　小蓝不能滑出矩阵所表示的场地。
 * 　　小蓝可以任意选择一个位置开始滑行，请问小蓝最多能滑行多远距离。
 * 输入格式
 * 　　输入第一行包含两个整数 n, m，用一个空格分隔。
 * 　　接下来 n 行，每行包含 m 个整数，相邻整数之间用一个空格分隔，依次表示每个位置的高度。
 * 输出格式
 * 　　输出一行包含一个整数，表示答案。
 * 样例输入
 * 4 5
 * 1 4 6 3 1
 * 11 8 7 3 1
 * 9 4 5 2 1
 * 1 3 2 2 1
 * 样例输出
 * 7
 * 样例说明
 * 　　滑行的位置一次为 (2, 1), (2, 2), (2, 3), (3, 3), (3, 2), (4, 2), (4, 3)。
 * @Author: pront
 * @Time:2023-03-03 11:11
 */
public class Main10 {
    static int maxValue = 0;
    static int value = 0;

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
        backtracking(matrix, 0, 0, Integer.MAX_VALUE);
    }

    public static void backtracking(int[][] matrix, int startRowIndex, int startColumnIndex, int pre) {
        if (matrix[startRowIndex][startColumnIndex] >= pre) {
            return;
        }
        if (matrix[startRowIndex][startColumnIndex] < pre) {
            value++;
            maxValue = Math.max(value, maxValue);
        }
        for (int i = startRowIndex; i < matrix.length; i++) {
            for (int j = startColumnIndex; j < matrix[0].length; j++) {
                if (i - 1 >= 0) {
//                    上
                    backtracking(matrix, i - 1, j, matrix[i][j]);
                    value--;
                }
                if (i + 1 < matrix.length) {
//                    下
                    backtracking(matrix, i + 1, j, matrix[i][j]);
                    value--;
                }
                if (j - 1 >= 0) {
//                    左
                    backtracking(matrix, i, j - 1, matrix[i][j]);
                    value--;
                }
                if (j + 1 < matrix[0].length) {
//                    右
                    backtracking(matrix, i, j + 1, matrix[i][j]);
                    value--;
                }
            }
        }
    }
}
