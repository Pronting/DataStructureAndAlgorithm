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
                ans = Math.max(ans, dfs(i, j));
            }
        }

        System.out.println(ans);
    }

    private static int dfs(int i, int j) {
        if (visited[i][j]) {
            return dist[i][j];
        }

        int maxDist = 0;

        if (i > 0 && chs[i - 1][j] == '1') {
//            上
            maxDist = Math.max(maxDist, dfs(i - 1, j));
        }
        if (i < 29 &&  chs[i + 1][j] == '1') {
//            下
            maxDist = Math.max(maxDist, dfs(i + 1, j));
        }
        if (j > 0 &&  chs[i][j - 1] == '1') {
//            左
            maxDist = Math.max(maxDist, dfs(i, j - 1));
        }
        if (j < 59 && chs[i][j + 1] == '1') {
//            右
            maxDist = Math.max(maxDist, dfs(i, j + 1));
        }
        visited[i][j] = true;
        dist[i][j] = maxDist + 1;
        return dist[i][j];
    }

}
