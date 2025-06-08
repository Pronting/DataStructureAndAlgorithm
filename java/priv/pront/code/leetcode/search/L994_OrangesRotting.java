package priv.pront.code.leetcode.search;
import java.util.*;

public class L994_OrangesRotting {

    int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1 ,0};
    int min;
    Queue<int[]> queue = new LinkedList<>();
    int row, col;

    public int orangesRotting(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int fresh = 0;
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1) fresh ++;
                if(grid[i][j] == 2) queue.add(new int[]{i, j});
            }
        }

        while(fresh > 0 && !queue.isEmpty()){
            min++;
            int n = queue.size();
            for(int j = 0; j < n; j++){
                int[] cur = queue.poll();
                for(int i = 0; i < 4; i++){
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if(nx >= 0 && nx < row && ny >= 0 && ny < col && grid[nx][ny] == 1){
                        queue.add(new int[]{nx, ny});
                        grid[nx][ny] = 2;
                        fresh --;
                    }
                }
            }
        }
        if(fresh > 0) return -1;
        return min;
    }
}
