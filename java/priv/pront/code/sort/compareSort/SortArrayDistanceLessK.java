package priv.pront.code.sort.compareSort;

import java.util.PriorityQueue;

/**
 * 如果把数组排好顺序，每个元素移动的距离不超过k，并且k相当于数组来说比较小
 * 原理就是，先将前k-1个数字放入小根堆中，然后将剩余的数放入小根堆中，同时做弹出的操作
 * 放入小根堆进行heapInsert过程中最大的长度便是(K+1)-1+1=k个长度
 */
public class SortArrayDistanceLessK {
    /**
     * 几乎有序问题的解决
     * @param arr
     * @param k   数组中每一个数排序过后下标变化的最大值
     */
    public static void sortedArrDistanceLessK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        //防止用户传递不切实际的k
        for (; index < Math.min(arr.length, k); index++) {
            //放入堆
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 3, 74, 6, 8, 1, 9, 1, 813, 92, 4, 812};
        sortedArrDistanceLessK(arr, 2);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
