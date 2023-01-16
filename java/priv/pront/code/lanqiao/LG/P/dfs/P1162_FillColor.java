package priv.pront.code.lanqiao.LG.P.dfs;

import java.util.*;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-01-15 12:42
 */
//FIXME 以下数据答案异常
public class P1162_FillColor {

    public static Map<Integer, List<Integer>> preRowMap = new HashMap<>();
    public static Map<Integer, List<Integer>> preColMap = new HashMap<>();
    public static int[] dRow = {-1, 1, 0, 0};
    public static int[] dCol = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        int[][] matrix = {
//                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
//                {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0},
//                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
//                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
//                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1},
//                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
//                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1},
//                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
//                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0},
//        };
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] =scanner.nextInt();
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        dfs(i, j, k, matrix);
                    }
                }
            }
        }
        print(preRowMap, matrix);

    }

    private static void dfs(int curRow, int curCol, int dir, int[][] matrix) {
        if (curRow < 0 || curCol < 0 || curRow == matrix.length || curCol == matrix[0].length || matrix[curRow][curCol] != 1) {
            return;
        }

        if (!preColMap.containsKey(curCol)) {
            List<Integer> list = new ArrayList<>();
            list.add(curRow);
            preColMap.put(curCol, list);
        } else {
            List<Integer> list = preColMap.get(curCol);
            if (!list.contains(curRow)) {
                list.add(curRow);
                preColMap.put(curCol, list);
            }
        }

//        将所有1的点信息存储到map里面
        if (!preRowMap.containsKey(curRow)) {
//            表里面没记录
            List<Integer> list = new ArrayList<>();
            list.add(curCol);
            preRowMap.put(curRow, list);
        } else {
//            之前已经存过
            List<Integer> list = preRowMap.get(curRow);
            if (!list.contains(curCol)) {
                list.add(curCol);
                preRowMap.put(curRow, list);
            }
        }
        dfs(curRow + dRow[dir], curCol + dCol[dir], dir, matrix);
    }

    private static void print(Map<Integer, List<Integer>> map, int[][] matrix) {

//        排序
        for (Map.Entry<Integer, List<Integer>> value : preColMap.entrySet()) {
            List<Integer> list = value.getValue();
            Collections.sort(list);
            preColMap.put(value.getKey(), list);
        }

        for (Map.Entry<Integer, List<Integer>> value : map.entrySet()) {
            List<Integer> list = value.getValue();
            Collections.sort(list);
            map.put(value.getKey(), list);
            for (int i = list.get(0); i <= list.get(list.size() - 1); i++) {
                if (rangeInDefined(i, list.get(0), list.get(list.size() - 1))) {
                    List<Integer> rowList = preColMap.get(i);
                    if (rangeInDefined(value.getKey(), rowList.get(0), rowList.get(rowList.size() - 1))) {
                        matrix[value.getKey()][i] = matrix[value.getKey()][i] == 0 ? 2 : 1;
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean rangeInDefined(int current, int min, int max) {
        return Math.max(min, current) == Math.min(current, max);
    }
}
