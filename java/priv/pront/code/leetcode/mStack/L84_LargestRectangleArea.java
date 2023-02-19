package priv.pront.code.leetcode.mStack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-19 12:25
 */
public class L84_LargestRectangleArea {


    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1) {
            return heights[0];
        }
        int len = heights.length;

        int[] arr = new int[len + 2];
        for (int i = 0; i < len; i++) {
            arr[i + 1] = heights[i];
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int index = 1;

        //    边界处理
        stack.addLast(0);


        int res = 0;
        while (index < len) {
            // 单调递增
            while (index < arr.length && (stack.isEmpty() || arr[stack.peekLast()] <= arr[index])) {
                stack.addLast(index++);
            }

            while (index < arr.length && arr[stack.peekLast()] > arr[index]) {
                int curIndex = stack.pollLast();
                int width = index - stack.peekLast() - 1;
                int height = arr[curIndex];
                res = Math.max(res, width * height);
            }

            stack.addLast(index++);
        }
        return res;

    }
}
