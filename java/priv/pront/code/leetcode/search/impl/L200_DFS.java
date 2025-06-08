package priv.pront.code.leetcode.search.impl;

import priv.pront.code.leetcode.search.L200_NumIslands;

public class L200_DFS implements L200_NumIslands {

    int []dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    int row, col;
    boolean[][] st;
    int ans = 0;
    @Override
    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        st = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1' && !st[i][j]){
                    ans ++;
                    dfs(i, j, grid);
                }
            }
        }
        return ans;
    }

    private void dfs(int r, int c, char[][] grid){
        st[r][c] = true;
        for(int i = 0; i < 4; i++){
            int nx = r + dx[i];
            int ny = c + dy[i];
            if(nx < 0 || nx >= row || ny < 0 || ny >= col || grid[nx][ny] =='0' || st[nx][ny]) continue;
            dfs(nx, ny, grid);
        }
    }

}
