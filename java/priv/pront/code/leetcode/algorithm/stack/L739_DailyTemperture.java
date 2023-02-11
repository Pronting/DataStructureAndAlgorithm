package priv.pront.code.leetcode.algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-11 15:42
 */
public class L739_DailyTemperture {

    // 暴力解法 timeout
    public int[] dailyTemperatures1(int[] temperatures) {
        if (temperatures.length == 0) {
            return new int[]{0};
        }
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int index = 0;
            for (int j = i; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    answer[i] = index;
                    break;
                }
                index++;
            }
        }
        return answer;
    }

//    !普通的单调栈，无优化
    public static int[] dailyTemperatures2(int[] temperatures) {
        if (temperatures.length == 0) {
            return new int[]{0};
        }
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int preIndex = 0;
        while (stack.peek() < temperatures.length - 1) {
            if (stack.isEmpty() || temperatures[stack.peek()] >= temperatures[stack.peek() + 1]) {
                stack.push(stack.peek() + 1);
            } else {
                int curIndex = stack.peek() + 1;
                while (!stack.isEmpty() && temperatures[curIndex] > temperatures[stack.peek()]) {
                    preIndex = stack.pop();
                    answer[preIndex] = curIndex - preIndex;
                }
                stack.push(curIndex);
            }
        }

        return answer;
    }

    //! 优化后的单调栈
    public int[] dailyTemperatures3(int[] temperatures) {
        int lens = temperatures.length;
        int[] res = new int[lens];

        /*
         ?如果当前遍历的元素 大于栈顶元素，表示 栈顶元素的 右边的最大的元素就是 当前遍历的元素，
         ?所以弹出 栈顶元素，并记录
         ?如果栈不空的话，还要考虑新的栈顶与当前元素的大小关系
         ?否则的话，可以直接入栈。
         ?注意，单调栈里 加入的元素是 下标。
         */
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < lens; i++) {

            if (temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return res;
    }


    //  !实例代码 最快的方法
    public int[] dailyTemperatures4(int[] temperatures) {
        int pointer = temperatures.length - 1;
        int[] res = new int[temperatures.length];
        res[pointer--] = 0;
        for (; pointer >= 0; pointer--) {
            int ptr = pointer + 1;
            while (temperatures[ptr] <= temperatures[pointer]) {
                if (res[ptr] == 0) {
                    break;
                }
                ptr += res[ptr];
            }
            if (temperatures[ptr] > temperatures[pointer]) {
                res[pointer] = ptr - pointer;

            } else {
                res[pointer] = 0;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] temperatrue = {73, 74, 75, 71, 69, 72, 76, 73};
        for (int i : dailyTemperatures2(temperatrue)) {
            System.out.print(i + " ");
        }


    }
}


