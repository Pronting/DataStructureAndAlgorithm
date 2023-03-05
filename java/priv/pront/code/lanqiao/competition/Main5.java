package priv.pront.code.lanqiao.competition;

import java.util.Scanner;

/**
 * @Description: 如果从一个标为 1 的位置可以通过上下左右走到另一个标为 1 的位置，
 * 则称两个位置连通。与某一个标为 1 的位置连通的所有位置（包括自己）组成一个连通分块。
 * 　　请问矩阵中最大的连通分块有多大？
 * @Author: pront
 * @Time:2023-03-03 09:53
 */
public class Main5 {

    static char[][] chs;
    static boolean[][] visited;
    static int[][] dist;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        chs = new char[30][60];
        for (int i = 0; i < chs.length; i++) {
            chs[i] = scanner.next().toCharArray();
        }
        visited = new boolean[30][60];
        dist = new int[30][60];


        int ans = 0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 60; j++) {
                if (chs[i][j] =='1' && !visited[i][j]){
                    ans = Math.max(ans, dfs(i, j,0));

                }
            }
        }

        System.out.println(ans);
    }

    private static int dfs(int i, int j,int dist) {
        if (visited[i][j] || chs[i][j] == '0') {
            return dist;
        }

        visited[i][j] = true;
        dist++;
        if (i - 1 >= 0  && chs[i - 1][j] == '1') {
//            上
            dist = dfs(i - 1, j, dist);
        }
        if (i + 1 < chs.length && chs[i + 1][j] == '1') {
//            下
            dist = dfs(i + 1, j, dist);
        }
        if (j - 1 >= 0 && chs[i][j - 1] == '1') {
//            左
            dist =  dfs(i, j - 1, dist);
        }
        if (j + 1 < chs[0].length && chs[i][j + 1] == '1') {
//            右
            dist = dfs(i, j + 1, dist);
        }
        return dist;
    }

}
