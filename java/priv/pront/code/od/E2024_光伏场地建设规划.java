package priv.pront.code.od;

import java.util.Scanner;

public class E2024_光伏场地建设规划 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();   // 行
        int n = sc.nextInt();   // 列
        int len = sc.nextInt(); // 正方形边长
        int target = sc.nextInt(); // 最低发电量

        int[][] pre = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                int val = sc.nextInt();
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + val;
            }
        }

        int ans = 0;
        for(int i = len; i <= m; i++){
            for(int j = len; j <= n; j++){
                int sum = pre[i][j] - pre[i - len][j] - pre[i][j - len] + pre[i - len][j - len];
                if(sum >= target) ans ++;
            }
        }
        System.out.println(ans);
    }
}
