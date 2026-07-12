package priv.pront.code.od;

import java.util.Scanner;

/**
 * 英雄联盟是一款十分火热的对战类游戏。每一场对战有10位玩家参与，分为两组，每组5人。每位玩家都有一个战斗力，代表着这位玩家的厉害程度。为了对战尽可能精彩，我们需要把玩家们分为实力尽量相等的两组。一组的实力可以表示为这一组5位玩家的战斗力和。现在，给你10位玩家的战斗力，请你把他们分为实力尽量相等的两组。请你输出这两组的实力差。
 */
public class E2024_游戏分组王者荣耀 {
    static int ans, sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        ans = sum;
        boolean[] vis = new boolean[10];
        dfs(arr, vis, 0,0, 0);
        System.out.println(ans);
    }

    private static void dfs(int[] arr, boolean[] vis, int start, int count, int total){
        if(count == 5) {
            ans = Math.min(Math.abs(total - (sum - total)), ans);
            return;
        }
        for(int i = start; i < arr.length; i ++){
            if(vis[i]) continue;
            vis[i] = true;
            dfs(arr, vis, i + 1,count + 1, total + arr[i]);
            vis[i] = false;
        }
    }
}
