package priv.pront.code.leetcode.search.impl;

import java.util.LinkedList;
import java.util.Queue;

public class L200_BFS {

    int ans = 0;
    Queue<int[]> queue = new LinkedList<>();
    int []dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    int row, col;
    boolean[][] st;
    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        st = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1' && !st[i][j]) bfs(i, j, grid);
            }
        }
        return ans;
    }

    private void bfs(int r , int c , char[][] grid){
        queue.add(new int[]{r, c});
        st[r][c] = true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx < 0 || nx >= row || ny < 0 || ny >= col || grid[nx][ny] =='0' || st[nx][ny]) continue;
                st[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
        ans++;
    }
}
