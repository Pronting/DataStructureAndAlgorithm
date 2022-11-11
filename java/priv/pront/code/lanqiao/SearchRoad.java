package priv.pront.code.lanqiao;

import java.util.*;

/**
 * @Description: 小明寻路
 * @Author: pront
 * @Time:2022-10-18 14:05
 */
public class SearchRoad {

    private static class Pointer {
        public Integer width;
        public Integer height;

        @Override
        public boolean equals(Object o) {

            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pointer pointer = (Pointer) o;
            return Objects.equals(width, pointer.width) && Objects.equals(height, pointer.height);
        }

        public Pointer() {
            width = 0;
            height = 0;
        }

        public Pointer(Integer width, Integer height) {
            this.width = width;
            this.height = height;
        }
    }

    private static int searchRoad(int n) {
        if (n == 0) {
            return -1;
        }
        int[][] matrix = init(n);
        Map<String, Integer> typeMap = new HashMap<>();
        Set<Pointer> selectedPointer = new HashSet<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Pointer pointer = new Pointer();
        int steps = 0;
//        最初1这个点位不能走了
        selectedPointer.add(pointer);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < n; j++) {
//                行级别中的有路并且不越界
                if (j + 1 < n && matrix[i][j + 1] == 0) {
                    boolean flag = addStepAndUnSelectedPointer(selectedPointer, i, j + 1);
                    if (flag) {
                        steps++;
                        selectedPointer.add(new Pointer(j + 1, i));
                        j = j + 1;
                    }
                } else if (j - 1 > 0 && matrix[i][j - 1] == 0) {
                    boolean flag = addStepAndUnSelectedPointer(selectedPointer, i, j + 1);
                    if (flag) {
                        steps++;
                        selectedPointer.add(new Pointer(j + 1, i));
                        j = j - 1;
                    }
//                    列级别的不越界并且有路
                } else if (i - 1 > 0 && matrix[i][j] == 0) {
                    boolean flag = addStepAndUnSelectedPointer(selectedPointer, i - 1, j);
                    if (flag) {
                        steps++;
                        selectedPointer.add(new Pointer(j, i - 1));
                        i = i - 1;
                    }
                }else if (i + 1 < matrix.length && matrix[i + 1][j] == 0) {
                    boolean flag = addStepAndUnSelectedPointer(selectedPointer, i + 1, j);
                    if (flag) {
                        steps++;
                        selectedPointer.add(new Pointer(j, i + 1));
                        i = i + 1;
                    }
                }


            }
        }
        return -1;
    }


    private static boolean addStepAndUnSelectedPointer(Set<Pointer> selectedPointer, int height, int width) {
        for (Pointer pointer : selectedPointer) {
            if (pointer.height == height && pointer.width == width) {
                return false;
            }
        }
        return true;
    }

    private static int[][] init(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = (int) (Math.random() * 2);
        }
        matrix[0][0] = 1;
        matrix[n - 1][n - 1] = 3;
        return matrix;
    }
}
