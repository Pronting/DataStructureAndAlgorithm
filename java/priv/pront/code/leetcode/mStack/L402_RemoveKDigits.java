package priv.pront.code.leetcode.mStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-19 10:55
 */
public class L402_RemoveKDigits {


//    10001 2 测试点没过
    public static String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        int index = 0;
        int len = num.length();
        int count = num.length() - k;
        if (count == 0) {
            return "0";

        }
        while (index < len) {
            while (index < len && (stack.isEmpty() || stack.peekLast() <= num.charAt(index))) {
                stack.addLast(num.charAt(index++));
            }

            if (index == len) {

                break;
            }

            while (!stack.isEmpty() && stack.peekLast() > num.charAt(index) && stack.size() + len - index - 1 >= count) {
                stack.removeLast();
            }
            stack.add(num.charAt(index++));
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty() && stack.peekFirst() == '0'){
            stack.removeFirst();

        }

        if(stack.isEmpty()){
            return "0";

        }

        index = 0;
        while (!stack.isEmpty() && index < count) {
            sb.append(stack.removeFirst());
            index++;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(removeKdigits("10001", 4));
    }
}
