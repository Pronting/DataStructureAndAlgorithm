package priv.pront.code.leetcode.mStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

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


    public int largestRectangleArea2(int[] heights) {
        if (heights.length == 1) {
            return heights[0];
        }
        int len = heights.length;
        int[] l = new int[len];
        int[] r= new int[len];
        int ans = -1;
        Arrays.fill(l, -1);
        Arrays.fill(r, len);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int idx = stack.peek();
                stack.pop();
                r[idx] = i;
            }
            if(!stack.isEmpty()){
                l[i] = stack.peek();
            }
            stack.push(i);
        }
        for(int i = 0; i < len; i++){
            int width = r[i] - l[i] - 1;
            int area = width * heights[i];
            ans = Math.max(ans, area);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        L84_LargestRectangleArea l84 = new L84_LargestRectangleArea();
        int res = l84.largestRectangleArea2(heights);
        System.out.println(res);
    }
}
