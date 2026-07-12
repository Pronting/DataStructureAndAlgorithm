package priv.pront.code.od;

import java.util.Scanner;

public class E2024_找终点 {

    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int len = split.length;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) arr[i] = Integer.parseInt(split[i]);
        for (int i = 0; i < len / 2; i++) {
            int v = parse(i, arr);
            if (v == -1) continue;
            ans = Math.min(ans, v);
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    public static int parse(int start, int[] arr) {
        int ans = 1;
        int idx = start;
        while (idx < arr.length) {
            if (idx + arr[idx] < arr.length) {
                idx += arr[idx];
                ans++;
            }else{
                break;
            }
        }
        if(idx >= arr.length) return -1;
        return ans;
    }
}
