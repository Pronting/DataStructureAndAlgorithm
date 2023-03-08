package priv.pront.code.leetcode.algorithm.dfs;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-08 15:50
 */
public class L329_LongestIncreasingPath {

//     错误的dfs
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 1 && matrix[0].length == 1){
            return 1;
        }
        int res = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                res = Math.max(dfs(matrix,i,j,visited,0,0),res);
            }
        }
        return res;
    }

    public int dfs(int[][] matrix, int curRowIndex, int curColIndex,boolean[][] visited,int length,int pre){
        if(curRowIndex < 0 || curColIndex < 0 || curRowIndex >= matrix.length || curColIndex >= matrix[0].length || visited[curRowIndex][curColIndex] == true ||  matrix[curRowIndex][curColIndex] <= pre){
            return length;
        }
        length++;
        visited[curRowIndex][curColIndex] = true;
        dfs(matrix, curRowIndex + 1, curColIndex, visited, length, matrix[curRowIndex][curColIndex]);
        dfs(matrix, curRowIndex - 1, curColIndex, visited, length, matrix[curRowIndex][curColIndex]);
        dfs(matrix, curRowIndex, curColIndex - 1, visited, length, matrix[curRowIndex][curColIndex]);
        dfs(matrix, curRowIndex, curColIndex + 1 ,visited, length, matrix[curRowIndex][curColIndex]);
        return length;
    }




//    正确的dfs
    public int longestIncreasingPath2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] memo = new int[row][col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res = Math.max(res, dfs2(matrix, i, j, memo));
            }
        }
        return res;
    }

    private int dfs2(int[][] matrix, int curRowIndex, int curColIndex, int[][] memo) {
        if (memo[curRowIndex][curColIndex] != 0) {
            return memo[curRowIndex][curColIndex];
        }
        int maxLen = 1;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int newRow = curRowIndex + dx[i];
            int newCol = curColIndex + dy[i];
            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length && matrix[newRow][newCol] > matrix[curRowIndex][curColIndex]) {
                int len = 1 + dfs2(matrix, newRow, newCol, memo);
                maxLen = Math.max(maxLen, len);
            }
        }
        memo[curRowIndex][curColIndex] = maxLen;
        return maxLen;
    }


    public int longestIncreasingPath3(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = 1;
        for(int i = 1; i < col; i++){
            // dp[0][i] = dp[0][i - 1] + matrix[0][i] > matri[0][i + 1] ? 1 : 0;
            dp[0][i] = matrix[0][i] > matrix[0][i - 1] ? dp[0][i - 1] + 1 : dp[0][i - 1];
        }

        for(int i = 1; i < row; i++){
            dp[i][0] = matrix[i][0] > matrix[i - 1][0] ? dp[i - 1][0] + 1 : dp[i - 1][0];
        }
        return 1;
    }

    public static void main(String[] args) {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        new L329_LongestIncreasingPath().longestIncreasingPath3(matrix);
//        System.out.println(new L329_LongestIncreasingPath().longestIncreasingPath(matrix));

    }
}
