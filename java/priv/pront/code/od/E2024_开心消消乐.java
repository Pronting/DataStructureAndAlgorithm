package priv.pront.code.od;

import java.util.Scanner;

/**
 * 给定一个N行M列的二维矩阵，矩阵中每个位置的数字取值为0或1。矩阵示例如：
 *
 * 1 1 0 0
 * 0 0 0 1
 * 0 0 1 1
 * 1 1 1 1
 * 1
 * 2
 * 3
 * 4
 * 现需要将矩阵中所有的1进行反转为0，规则如下：
 *
 * 当点击一个1时，该1便被反转为0，同时相邻的上、下、左、右，以及左上、左下、右上、右下8 个方向的1（如果存在1）均会自动反转为0；
 * 进一步地，一个位置上的1被反转为0时，与其相邻的8个方向的1（如果存在1）均会自动反转为0；
 * 按照上述规则示例中的矩阵只最少需要点击2次后，所有值均为0。
 *
 * 请问，给定一个矩阵，最少需要点击几次后，所有数字均为0？
 *
 * 输入描述
 * 第一行为两个整数，分别表示句子的行数 N 和列数 M，取值范围均为 [1, 100]
 *
 * 接下来 N 行表示矩阵的初始值，每行均为 M 个数，取值范围 [0, 1]
 *
 * 输出描述
 * 输出一个整数，表示最少需要点击的次数
 */
public class E2024_开心消消乐 {

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] arr;
    static int N;
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];

        for(int i = 0; i < N; i ++)
            for(int j = 0; j < M; j++)
                arr[i][j] = sc.nextInt();



        int ans = 0;
        for(int i  = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 1){
                    ans++;
                    arr[i][j] = 2;
                    dfs(i, j);
                }
            }
        }
        System.out.println(ans);


    }
    public static void dfs(int row, int col){
        for(int i = 0; i < 8; i++){
            int nr = row + dx[i];
            int nc = col + dy[i];
            if(nr < 0 || nr >= N || nc < 0 || nc >= M || arr[nr][nc] != 1) continue;
            arr[nr][nc] = 2;
            dfs(nr, nc);
        }
    }
}
