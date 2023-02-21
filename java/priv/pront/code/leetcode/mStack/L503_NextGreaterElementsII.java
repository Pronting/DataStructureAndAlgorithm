package priv.pront.code.leetcode.mStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-21 18:15
 */
public class L503_NextGreaterElementsII {


    public static int[] nextGreaterElements(int[] nums) {


        int[] res = new int[nums.length];

        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        boolean flag = true;
        while (index < nums.length) {

            if (flag && index == nums.length - 1) {
                stack.addLast(index);
                flag = false;
                index = 0;
            }

            if (flag && (stack.isEmpty() || nums[stack.peekLast()] >= nums[index])) {
                stack.addLast(index++);
                continue;
            }

            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[index]) {
                res[stack.peekLast()] = nums[index];
                stack.pollLast();
            }
            stack.addLast(index++);

        }

        return res;

    }

    public static void main(String[] args) {
        int[] ints = nextGreaterElements(new int[]{1, 2, 1});
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
