package priv.pront.code.leetcode.matrix;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-01 19:15
 */
public class L2373_LargestLocal {

    public static int[][] largestLocal(int[][] grid) {
        int[][] res = new int[grid.length - 2][grid.length - 2];
        for(int i = 0 ; i < res.length ; i++){
            for(int j = 0; i < res.length ;j++){
                int max = Integer.MIN_VALUE;
                for(int k = i ; k < i + 3 && k < grid.length; k++){
                    for(int m = j; m < j + 3 && m < grid.length; m++){
                        max = Math.max(max,grid[k][m]);
                    }
                }
                res[i][j] = max;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}};
        int[][] ints = largestLocal(arr);
    }


}
