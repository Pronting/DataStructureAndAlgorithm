package priv.pront.code.od;

import java.util.Scanner;

/**
 * 题目描述
 * Linux操作系统有多个发行版，distrowatch.com提供了各个发行版的资料。这些发行版互相存在关联，例如Ubuntu基于Debian开发，而Mint又基于Ubuntu开发，那么我们认为Mint同Debian也存在关联。
 *
 * 发行版集是一个或多个相关存在关联的操作系统发行版，集合内不包含没有关联的发行版。
 *
 * 给你一个 n * n 的矩阵 isConnected，其中 isConnected[i][j] = 1 表示第 i 个发行版和第 j 个发行版直接关联，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回最大的发行版集中发行版的数量。
 *
 * 输入描述
 * 第一行输入发行版的总数量N，1<= N <= 200
 *
 * 之后每行表示各发行版间是否直接相关.
 *
 * 输出描述
 * 输出最大的发行版集中发行版的数量
 *
 *
 *
 * 用例1
 * 输入
 * 4
 * 1 1 0 0
 * 1 1 1 0
 * 0 1 1 0
 * 0 0 0 1
 * 输出
 * 3
 * 说明
 * Debian(1)和Unbuntu(2)相关
 *
 * Mint(3)和Ubuntu(2)相关，
 *
 * EeulerOS(4)和另外三个都不相关，
 *
 * 所以存在两个发行版集，发行版集中发行版的数量分别是3和1，所以输出3。
 */
public class E2024_Graph {

    static int n;
    static boolean[] vis;
    static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new int[n][n];
        vis = new boolean[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) graph[i][j] = sc.nextInt();
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                int size = dfs(i);
                max = Math.max(size, max);
            }
        }
        System.out.println(max);
    }

    public static int dfs(int node){
        vis[node] = true;
        int size = 1;
        for(int next = 0; next < n; next ++){
            if(!vis[next] && graph[node][next] == 1){
                size += dfs(next);
            }
        }
        return size;
    }

}
