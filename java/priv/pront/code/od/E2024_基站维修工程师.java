package priv.pront.code.od;

import java.util.Scanner;

public class E2024_基站维修工程师 {

    static int n;
    static int[][] dist;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dist = new int[n][n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dist[i][j] = sc.nextInt();
            }
        }

        visited[0] = true;
        dfs(0, 1, 0);
        System.out.println(ans);
    }

    public static void dfs(int cur, int count, int sum){
        if(sum >= ans) return;
        if(count == n){
            ans = Math.min(ans, sum + dist[cur][0]);
            return;
        }
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(i, count + 1, sum + dist[cur][i]);
            visited[i] = false;
        }
    }
}
