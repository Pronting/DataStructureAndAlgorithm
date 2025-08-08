package priv.pront.code.leetcode.matrix;

public class L36_IsValidSuduKu {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] matrix = new boolean[10][10];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                int num = board[i][j] - 48;
                int t = (i / 3) * 3 + j / 3;
                if(row[i][num] || col[j][num] || matrix[t][num]) return false;
                row[i][num] = true;
                col[j][num] = true;
                matrix[t][num] = true;
            }
        }
        return true;

    }
}
