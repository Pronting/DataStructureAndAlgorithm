package priv.pront.code.structure.matrix;

import java.util.List;

/**
 * @Description: 在左侧都是1右侧全是0的矩阵中统计最多1的行
 * @Author: pront
 * @Time:2022-12-08 18:46
 */
// TODO
public class FindMaxRowIn01Matrix {

    private static List<Integer> rowList;


    private static List<Integer> getMaxRow(int[][] matrix) {
        int row = 0;
        int col = matrix[0].length - 1;
        int count = 0;
        while (row < matrix.length - 1 && col >= 0) {
            if (matrix[row][col] == 0 && rowList.size() == 0) {
                rowList.add(row);
                row++;
            }

            if (matrix[row][col] == 0 && rowList.size() != 0) {
                int cur = rowList.get(0);
                if(cur < count){}
            }

            if (matrix[row][col] == 1) {
                col--;
                count++;
            }
        }
        return rowList;
    }
}
