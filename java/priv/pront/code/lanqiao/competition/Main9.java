package priv.pront.code.lanqiao.competition;

import java.util.Scanner;

/**
 * @Description: 　
 * 小蓝有一个 n * m 大小的矩形水域，
 * 小蓝将这个水域划分为 n 行 m 列，行数从 1 到 n 标号，
 * 列数从 1 到 m 标号。每行和每列的宽度都是单位 1 。
 * 　　现在，这个水域长满了水草，小蓝要清理水草。
 * 　　每次，小蓝可以清理一块矩形的区域，从第 r1 行（含）到第 r2 行（含）的第 c1 列（含）到 c2 列（含）。
 * 　　经过一段时间清理后，请问还有多少地方没有被清理过。
 * 输入格式
 * 　　输入第一行包含两个整数 n, m，用一个空格分隔。
 * 　　第二行包含一个整数 t ，表示清理的次数。
 * 　　接下来 t 行，每行四个整数 r1, c1, r2, c2，相邻整数之间用一个空格分隔，表示一次清理。请注意输入的顺序。
 * 输出格式
 * 　　输出一行包含一个整数，表示没有被清理过的面积。
 * 样例输入
 * 2 3
 * 2
 * 1 1 1 3
 * 1 2 2 2
 * 样例输出
 * 2
 * 样例输入
 * 30 20
 * 2
 * 5 5 10 15
 * 6 7 15 9
 * 样例输出
 * 519
 * @Author: pront
 * @Time:2023-03-03 10:52
 */
public class Main9 {

    public static void main(String[] args) {
        int cleanSquare = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int r1 = scanner.nextInt();
            int c1 = scanner.nextInt();
            int r2 = scanner.nextInt();
            int c2 = scanner.nextInt();
            cleanSquare +=process(r1, c1, r2, c2,matrix);
        }

        System.out.println(n * m - cleanSquare);


    }

    public static int process( int startRowIndex, int startColumnIndex, int endRowIndex, int endColumnIndex,int[][] matrix) {
        int ans = 0;
        for (int i = startRowIndex - 1; i < endRowIndex; i++) {
            for (int j = startColumnIndex - 1; j < endColumnIndex; j++) {
                if(matrix[i][j] == 1){
                    continue;
                }
                matrix[i][j] = 1;
                ans++;
            }
        }
        return ans;
    }
}
