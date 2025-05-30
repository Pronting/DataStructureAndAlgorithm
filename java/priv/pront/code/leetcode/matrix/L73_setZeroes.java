package priv.pront.code.leetcode.matrix;

public class L73_setZeroes {

    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        boolean[][] st = new boolean[r][c];


        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(matrix[i][j] == 0) st[i][j] = true;
            }
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(st[i][j]){
                    for(int k = 0; k < c; k++) matrix[i][k] = 0;
                    for(int k = 0; k < r; k++) matrix[k][j] = 0;
                }
            }
        }

    }
}
