package priv.pront.code.algorithm.sort.compareSort;

import priv.pront.constants.ArrayUtils;

/**
 * @Description: 冒泡排序
 * 每一趟只能确定将一个数归位。即第一趟只能确定将末位上的数归位，
 * 第二趟只能将倒数第 2 位上的数归位，依次类推下去。
 * 如果有 n 个数进行排序，只需将 n-1 个数归位，也就是要进行 n-1 趟操作。
 *
 * 而 “每一趟 ” 都需要从第一位开始进行相邻的两个数的比较，将较大的数放后面，
 * 比较完毕之后向后挪一位继续比较下面两个相邻的两个数大小关系，重复此步骤，直到最后一个还没归位的数。
 * @Author: pront
 * @Time:2022-10-08 18:37
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 共n-1躺
        for (int i = 0; i < arr.length-1; i++) {
//            由于每轮确定一个数字，所以j<arr.length-i(确定的一个位置)
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if (arr == null || i == j) {
            return;
        }
        arr[j] = arr[j] ^ arr[i];
        arr[i] = arr[j] ^ arr[i];
        arr[j] = arr[j] ^ arr[i];
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.getAppointArray(10, 0, 20);
        bubbleSort(arr);
        ArrayUtils.printArray(arr);

    }
}
