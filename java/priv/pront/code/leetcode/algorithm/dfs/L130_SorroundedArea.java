package priv.pront.code.leetcode.algorithm.dfs;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-04 15:47
 */
public class L130_SorroundedArea {

    boolean[][] visited;

    public void solve(char[][] board) {
        visited = new boolean[board.length][board[0].length];
        for(int i =  0; i < board.length; i++){
            dfs(board,i,0);
            dfs(board,i,board[0].length - 1);
        }
        for(int j = 0; j < board[0].length; j++){
            dfs(board,0,j);
            dfs(board,board.length - 1 ,j);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int rowIndex, int colIndex){
        if(board[rowIndex][colIndex] == 'X' || visited[rowIndex][colIndex]){
            return;
        }
        visited[rowIndex][colIndex] = true;
        if(rowIndex - 1 >= 0){
            dfs(board,rowIndex - 1, colIndex);
        }
        if(rowIndex + 1 < board.length){
            dfs(board,rowIndex + 1, colIndex);
        }
        if(colIndex - 1 >= 0){
            dfs(board,rowIndex,colIndex - 1);
        }
        if(colIndex + 1 < board[0].length){
            dfs(board,rowIndex,colIndex + 1);
        }

    }
}
