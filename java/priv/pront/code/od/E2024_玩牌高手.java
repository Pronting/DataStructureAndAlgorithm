package priv.pront.code.od;

import java.util.Scanner;

public class E2024_玩牌高手 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        int len = split.length;
        int[] arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = Integer.parseInt(split[i]);
        }
        int[] dp = new int[len];
        dp[0] = Math.max(arr[0], 0);
        for(int i = 1; i < len; i ++){
            int pre;
            if(i < 3){
                pre = 0;
            }else{
                pre = dp[i - 3];
            }
            dp[i] = Math.max(dp[i - 1] + arr[i], pre);
        }
        System.out.println(dp[len - 1]);
    }
}
