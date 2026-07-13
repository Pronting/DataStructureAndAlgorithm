package priv.pront.code.od;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class E2024_转盘寿司 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int n = split.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(split[i]);
        int[] ans = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 2 * n - 1; i >= 0; i --){
            int idx = i % n;
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[idx]){
                stack.pop();
            }
            ans[idx] = arr[idx];
            if (!stack.isEmpty()) {
                ans[idx] += arr[stack.peek()];
            }
            stack.push(idx);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(" ");
            sb.append(ans[i]);
        }

        System.out.println(sb);
    }
}
