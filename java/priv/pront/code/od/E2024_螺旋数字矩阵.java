package priv.pront.code.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 疫情期间，小明隔离在家，百无聊赖，在纸上写数字玩。他发明了一种写法：
 * 给出数字个数n和行数m（0 < n ≤ 999，0 < m ≤ 999），从左上角的1开始，按照顺时针螺旋向内写方式，依次写出2,3…n，最终形成一个m行矩阵。
 * 小明对这个矩阵有些要求：
 *
 * 每行数字的个数一样多
 * 列的数量尽可能少
 * 填充数字时优先填充外部
 * 数字不够时，使用单个*号占位
 * 输入描述
 * 输入一行，两个整数，空格隔开，依次表示n、m
 *
 * 输出描述
 * 符合要求的唯一矩阵
 */
public class E2024_螺旋数字矩阵 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int col = (n + m - 1) / m; // ceil
        if (col <= 0) col = 1;

        String[][] grid = new String[m][col];

        // 初始化 *
        for (int i = 0; i < m; i++) {
            Arrays.fill(grid[i], "*");
        }

        // 方向：右 下 左 上
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        boolean[][] vis = new boolean[m][col];

        int r = 0, c = 0, dir = 0;

        for (int val = 1; val <= n; val++) {
            grid[r][c] = String.valueOf(val);
            vis[r][c] = true;

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nr >= m || nc < 0 || nc >= col || vis[nr][nc]) {
                dir = (dir + 1) % 4;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }

            r = nr;
            c = nc;
        }

        // 输出
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(grid[i][j]);
                if (j != col - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
