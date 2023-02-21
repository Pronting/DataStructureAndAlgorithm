package priv.pront.code.leetcode.mStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-21 17:05
 */
public class L239_MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] arr, int w) {

        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
//            装载下标
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public void getMaxNumber(int[] arr, int leftIndex, int rightIndex, int index, int[] res) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = leftIndex; i <= rightIndex; i++) {

            if (stack.isEmpty() || stack.peekLast() > arr[i]) {
                stack.addLast(arr[i]);
                continue;
            }
            while (!stack.isEmpty() && stack.peekLast() < arr[i]) {
                stack.pollLast();
            }
            stack.addLast(arr[i]);
        }

        res[index] = stack.pollFirst();
    }

    public static void main(String[] args) {
        int[] ints = new L239_MaxSlidingWindow().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
