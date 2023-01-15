package priv.pront.code.lanqiao.LG.P.dfs;

import java.util.Scanner;

/**
 * @Description: 单词矩阵jizhong
 * @Author: pront
 * @Time:2023-01-15 09:48
 */
public class P1101_WordMatrix_Yizhong {
//      正下、正上、正左、正右、左下、右下、右上、左上
    public static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1}, dy = {0, 0, -1, 1, -1, 1, 1, -1};
    public static char[] s = {'y', 'i', 'z', 'h', 'o', 'n', 'g'};
    public static int[][] rec;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        rec = new int[n][n];
        sc.nextLine();
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            map[i] = s.toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'y') {
                    for (int k = 0; k < 8; k++) {
                        dfs(i, j, k, 1, map);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rec[i][j] != 0) {
                    System.out.print(s[rec[i][j] - 1]);
                } else {
                    System.out.print('*');
                }
            }
            System.out.println();
        }
    }

    /**
     *
     * @param curInRow  current row
     * @param curInCol current column
     * @param dir 8个位置方向
     * @param cur current location
     * @param map matrix
     */
    public static void dfs(int curInRow, int curInCol, int dir, int cur, char[][] map) {
        int n = map.length;
        if (curInRow < 0 || curInCol < 0 || curInRow == n || curInCol == n || map[curInRow][curInCol] != s[cur - 1]) {
            return;
        }
        if (cur == 7 && map[curInRow][curInCol] == 'g') {
            int j = 1;
            for (int i = 6; i >= 0; i--) {
                rec[curInRow - i * dx[dir]][curInCol - i * dy[dir]] = j;
                j++;
            }
            return;
        }
        dfs(curInRow + dx[dir], curInCol + dy[dir], dir, cur + 1, map);
    }
}
