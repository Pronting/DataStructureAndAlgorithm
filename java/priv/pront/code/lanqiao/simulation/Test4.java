package priv.pront.code.lanqiao.simulation;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-12-03 15:04
 */
public class Test4 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String mainf = mainf(str);
        System.out.println(mainf);
    }


    private static String mainf(String str) {
        if (!isPalindrome(str)) {

        }
        return str;
    }

    private static Boolean isPalindrome(String str) {
        char[] chars1 = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars1.length; i++) {
            stack.push(chars1[i]);
        }
        int index = 0;
        while (!stack.isEmpty()) {
            if (stack.pop() != chars1[index++]) {
                return false;
            }
        }
        return true;
    }
}
