package priv.pront.code.pretreatment;

import priv.pront.constants.MatrixUtils;

/**
 * @Description: 求01矩阵中边长全为1的最大正方形
 * @Author: pront
 * @Time:2022-11-25 10:53
 */
public class MaxOneBorderSize {
    private static void setBorderMap(int[][] m, int[][] right, int[][] down) {
        int row = m.length;
        int col = m[0].length;
        if (m[row - 1][col - 1] == 1) {
            right[row - 1][col - 1] = 1;
            down[row - 1][col - 1] = 1;
        }
        for (int i = row - 2; i != -1; i--) {
            if (m[i][col - 1] == 1) {
                right[i][col - 1] = 1;
                down[i][col - 1] = down[i + 1][col - 1] + 1;
            }
        }
        for (int i = col - 2; i != -1; i--) {
            if (m[row - 1][i] == 1) {
                right[row - 1][i] = right[row - 1][i + 1] + 1;
                down[row - 1][i] = 1;
            }
        }
        for (int i = row - 2; i != -1; i--) {
            for (int j = col - 2; j != -1; j--) {
                if (m[i][j] == 1) {
                    right[i][j] = right[i][j + 1] + 1;
                    down[i][j] = down[i + 1][j] + 1;
                }
            }
        }
    }

    private static int getMaxSize(int[][] m) {
//    一个小加速 O(N) ---> O(1)
        int[][] right = new int[m.length][m[0].length];
        int[][] down = new int[m.length][m[0].length];
        setBorderMap(m, right, down);
        for (int size = Math.min(m.length, m[0].length); size != 0; size--) {
            if (hasSizeOfBorder(size, right, down)) {
                return size;
            }
        }
        return 0;
    }

    private static boolean hasSizeOfBorder(int size, int[][] right, int[][] down) {
        for (int i = 0; i != right.length - size + 1; i++) {
            for (int j = 0; j != right[0].length - size + 1; j++) {
                if (right[i][j] >= size && down[i][j] >= size
                        && right[i + size - 1][j] >= size
                        && down[i][j + size - 1] >= size) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = MatrixUtils.generateRandom01Matrix(7, 8);
        MatrixUtils.printMatrix(matrix);
        System.err.println(getMaxSize(matrix));
    }

}
