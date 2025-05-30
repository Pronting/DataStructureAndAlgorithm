package priv.pront.code.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class L54_SpiralOrder {

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        int r = 0;
        int c = 0;
        int dir = 0;
        for (int i = 0; i < m * n; i++) {
            ans.add(matrix[r][c]);
            visited[r][c] = true;
            int nextR = r + dx[dir];
            int nextC = c + dy[dir];
            if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || visited[nextR][nextC]) {
                dir = (dir + 1) % 4;
            }
            r += dx[dir];
            c += dy[dir];
        }

        return ans;
    }
}
