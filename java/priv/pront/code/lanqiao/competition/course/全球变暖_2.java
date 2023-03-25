package priv.pront.code.lanqiao.competition.course;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-25 14:55
 */
public class 全球变暖_2 {
    static int[] c = {0, 0, -1, 1};
    static int[] r = {1, -1, 0, 0};
    static boolean[][] visited;
    static char[][] grid;
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        grid = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            grid[i] = scanner.nextLine().toCharArray();
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (grid[i][j] == '#' && !visited[i][j] && dfs(i, j)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean dfs(int row, int col) {
        visited[row][col] = true;
//        上下左右陆地的数量
        int count = 0;
//        当前岛屿是否被淹没
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            int curRow = row + r[i];
            int curCol = col + c[i];
            if (legal(curRow, curCol) && grid[curRow][curCol] == '#') {
                count++;
                if (!visited[curRow][curCol]) {
                    flag |= dfs(curRow, curCol);
                }
            }
        }
        return count == 4 || flag;
    }

    private static boolean legal(int row, int col) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid.length;
    }
}
