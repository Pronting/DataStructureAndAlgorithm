package priv.pront.utils;

/**
 * @Description: 数组工具类
 * @Author: pront
 * @Time:2022-08-10 20:05
 */
public class ArrayUtils {
    public static int[] getAppointArray(int arraySize, int min, int max) {
        if (arraySize < 2) {
            return null;
        }
        int[] arr = new int[arraySize];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = (int) ((Math.random()) * max + min);
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
