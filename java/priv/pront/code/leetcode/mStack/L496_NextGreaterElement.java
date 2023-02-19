package priv.pront.code.leetcode.mStack;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-19 15:29
 */
public class L496_NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Deque<Integer> stack = new ArrayDeque<>();

        int[] ans = new int[nums1.length];
        int ansIndex = 0;
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums1.length; i++) {
            int index = 0;
            while (index < nums2.length) {
                stack.addLast(nums2[index++]);
                while (index < nums2.length && stack.peekLast() == nums1[i]) {
                    if (stack.peekLast() < nums2[index++]) {
                        ans[ansIndex] = nums2[index - 1];
                        break;
                    }
                }
            }
            ansIndex++;
            while(!stack.isEmpty()){
                stack.removeLast();
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        for (int i : new L496_NextGreaterElement().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})) {
            System.out.print(i + " ");
        }
    }
}
