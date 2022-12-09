package priv.pront.code.algorithm.watchdog;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 给定一个有序数组arr，代表数轴上从左到右有n个点arr[0]、arr[1]...arr[n－1]， 给定一个正数L，代表一根长度为L的绳子，求绳子最多能覆盖其中的几个点。
 * @Author: pront
 * @Time:2022-11-18 18:47
 */
public class CordCoverMaxPoint {

//    FIXME 对数器 OOOPS!
    /**
     * 二分法查找
     * @param arr
     * @param L
     * @return
     */
    private static int maxPoint1(int[] arr, int L) {
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int nearest = nearestIndex(arr, i, arr[i] - L);
            res = Math.max(res, i - nearest + 1);
        }
        return res;
    }

    /**
     * 滑动窗口
     * 在arr[0..R]范围上，找满足>=value的最左位置
     *
     * @param arr
     * @param R
     * @param value
     * @return
     */
    private static int nearestIndex(int[] arr, int R, int value) {
        int L = 0;
        int index = R;
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }


    private static int maxPoint2(int[] arr, int length) {
        Map<Integer, Integer> pointMap = getPointMap(arr, length);
        return getMaxPoint(pointMap);

    }

    private static Map<Integer, Integer> getPointMap(int[] arr, int length) {
        int L = arr[0];
        int R;
        Map<Integer, Integer> nodeCount = new HashMap<>();
        while (L <= arr.length - 1) {
            int count = 0;
            R = L;
            while (arr[R] - arr[L] <= length) {
                if (R + 1 <= arr.length - 1 && length >= arr[R + 1] - arr[L]) {
                    count++;
                    R++;
                } else {
                    break;
                }
            }
            nodeCount.put(arr[L], count);
            L++;
        }
        return nodeCount;
    }


    private static int getMaxPoint(Map<Integer, Integer> nodeMap) {
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> node : nodeMap.entrySet()) {
            max = Math.max(max, node.getValue());
        }
        return max;
    }


    private static int generateRandomLength(int max) {
        return (int) (Math.random() * max);
    }

    private static int[] generateRandomArr(int length) {
        int[] arr = new int[length];
        arr[0] = 0;
        for (int i = 1; i < length; i++) {
            arr[i] = arr[i - 1] + (int) (Math.random() * 8);
        }
        return arr;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            int length = generateRandomLength(10);
            int[] arr = generateRandomArr(20);
            if (maxPoint1(arr, length) != maxPoint2(arr, length)) {
                System.out.println("ooops!");
                break;
            }
        }
    }
}
