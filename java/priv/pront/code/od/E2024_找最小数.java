package priv.pront.code.od;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class E2024_找最小数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine().trim();
        int k = Integer.parseInt(sc.nextLine().trim());
        Deque<Character> deque = new ArrayDeque<>();
        // 单调栈
        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        // 如果还需要删除，从后面删
        while (k > 0) {
            deque.pollLast();
            k--;
        }
        // 去除前导0
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char c = deque.pollFirst();
            if (leadingZero && c == '0') {
                continue;
            }
            leadingZero = false;
            sb.append(c);
        }
        if (sb.length() == 0) {
            System.out.println("0");
        } else {
            System.out.println(sb);
        }
    }
}
