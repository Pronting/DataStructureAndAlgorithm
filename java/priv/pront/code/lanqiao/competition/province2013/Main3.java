package priv.pront.code.lanqiao.competition.province2013;

import java.util.Scanner;

/**
 * @Description: 减格子
 * @Author: pront
 * @Time:2023-03-15 16:27
 */
public class Main3 {

    static int ans = Integer.MAX_VALUE;
    static int target;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int col = scanner.nextInt();
        int row = scanner.nextInt();
        int sum = 0;
        int[][] grid = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int val = scanner.nextInt();
                sum += val;
                grid[i][j] = val;
            }
        }
        if (sum % 2 != 0) {
            System.out.println(0);
            return;
        }
//        能够找到解的情况
        target = sum / 2;
        dfs(grid, 0, 0, new boolean[row][col], 0, 0);
        System.out.println(ans);
    }

    private static void dfs(int[][] grid, int curRowIndex, int curColIndex, boolean[][] visited, int sum, int steps) {
        if (curRowIndex < 0 || curColIndex < 0 || curRowIndex == grid.length || curColIndex == grid[0].length || visited[curRowIndex][curColIndex] || sum > target) {
            return;
        }
        if (sum == target) {
            ans = Math.min(ans, steps);
            return;
        }
        steps++;
        visited[curRowIndex][curColIndex] = true;
        sum += grid[curRowIndex][curColIndex];
        dfs(grid, curRowIndex - 1, curColIndex, visited, sum, steps);
        dfs(grid, curRowIndex + 1, curColIndex, visited, sum, steps);
        dfs(grid, curRowIndex, curColIndex - 1, visited, sum, steps);
        dfs(grid, curRowIndex, curColIndex + 1, visited, sum, steps);
        visited[curRowIndex][curColIndex] = false;
    }
}
