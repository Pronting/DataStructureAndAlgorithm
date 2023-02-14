package priv.pront.code.algorithm.sort.compareSort;

import priv.pront.utils.ArrayUtils;

/**
 * @Description: 选择排序
 * @Author: pront
 * @Time:2022-10-09 15:52
 */
public class SelectionSort {

    public static int[] selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        int minIndex;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
        return arr;
    }

    public static void swap(int[] arr, int y, int x) {
        if (arr == null || arr.length < 2 || y == x) {
            return;
        }
        arr[y] = arr[x] ^ arr[y];
        arr[x] = arr[x] ^ arr[y];
        arr[y] = arr[x] ^ arr[y];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        int[] arrs = selectSort(arr);
        ArrayUtils.printArray(arrs);
    }
}
