package priv.pront.code.dsu;

/**
 * @Description: 岛问题
 * 【题目】
 * 一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右 四个位置相连，如
 * 果有一片1连在一起，这个部分叫做一个岛，求一个矩阵中有多少个岛?
 * 【举例】
 * 001010
 * 111010
 * 100100
 * 000000
 * 这个矩阵中有三个岛
 * 【进阶】
 * 如何设计一个并行算法解决这个问题
 * @Author: pront
 * @Time:2022-10-13 22：04
 */

public class Islands {

	public static int countIslands(int[][] m) {
		if (m == null || m[0] == null) {
			return 0;
		}
		int N = m.length;
		int M = m[0].length;
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (m[i][j] == 1) {
					res++;
					infect(m, i, j, N, M);
				}
			}
		}
		return res;
	}

	public static void infect(int[][] m, int i, int j, int N, int M) {
		if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
			return;
		}
		m[i][j] = 2;
		infect(m, i + 1, j, N, M);
		infect(m, i - 1, j, N, M);
		infect(m, i, j + 1, N, M);
		infect(m, i, j - 1, N, M);
	}

	public static void main(String[] args) {
		int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				        { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
				        { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
				        { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
				        { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
				        { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
				        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(countIslands(m1));

		int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 1, 1, 1, 1, 1, 1, 1, 0 },
						{ 0, 1, 1, 1, 0, 0, 0, 1, 0 },
						{ 0, 1, 1, 0, 0, 0, 1, 1, 0 },
						{ 0, 0, 0, 0, 0, 1, 1, 0, 0 },
						{ 0, 0, 0, 0, 1, 1, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(countIslands(m2));

	}

}