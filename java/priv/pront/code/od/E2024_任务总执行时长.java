package priv.pront.code.od;

import java.util.Arrays;
import java.util.Scanner;

public class E2024_任务总执行时长 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sp = sc.nextLine().split(",");
        int taska = Integer.parseInt(sp[0]);
        int taskb = Integer.parseInt(sp[1]);
        int target = Integer.parseInt(sp[2]);
        int min = Math.min(taska, taskb);
        int max = Math.max(taska, taskb);
        int[] arr = new int[target];
        Arrays.fill(arr, min);
        int[] ans = new int[target + 1];
        int sum = target * min;

        ans[0] = sum;
        for(int idx = 1 ; idx <= target; idx ++) {
            ans[idx] = ans[idx - 1] + (max - min);
        }
        System.out.print("[");
        for (int i = 0; i <= target; i++) {
            if(i != 0) System.out.print(",");
            System.out.print(ans[i]);
        }
        System.out.print("]");
    }
}
