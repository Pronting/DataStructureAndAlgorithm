package priv.pront.code.leetcode.matrix;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-02 18:28
 */
public class L240_SearchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }
        int rowIndex = 0;
        int colIndex = 0;

        while (rowIndex < matrix.length && colIndex < matrix[0].length) {
            if (matrix[rowIndex][colIndex] == target) {
                return true;
            }

            while (colIndex + 1 < matrix[0].length && matrix[rowIndex][colIndex] < target) {
                colIndex++;
            }

            if (rowIndex + 1 < matrix.length) {
                rowIndex++;
            }

            while (colIndex - 1 >= 0 && matrix[rowIndex][colIndex] > target) {
                colIndex--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {  {1, 4, 7, 11, 15},
                            {2, 5, 8, 12, 19},
                            {3, 6, 9, 16, 22},
                            {10, 13, 14, 17, 24},
                            {18, 21, 23, 26, 30}};
        int target = 20;
        searchMatrix(matrix, target);
    }

}
