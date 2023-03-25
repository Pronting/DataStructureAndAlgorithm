package priv.pront.code.lanqiao.competition;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: 记忆化搜索
 * @Author: pront
 * @Time:2023-03-25 16:51
 */
public class 第五届省赛C组_地宫取宝 {
    static int n, m, k;
    static int[][] grid;
    static long[][][][] cache = new long[50][50][14][13];
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                for (int l = 0; l < 14; l++) {
                    Arrays.fill(cache[i][j][l], -1);
                }
            }
        }
        System.out.println(dfs(0, 0, -1, 0));
    }

    private static long dfs(int x, int y, int max, int nums) {
        if (x == n || y == m || nums > k) {
            return 0;
        }
        if (cache[x][y][max + 1][nums] != -1) {
            return cache[x][y][max + 1][nums];
        }
        int cur = grid[x][y];
//        已经走到了最后一个格子
        if (x == n - 1 && y == m - 1) {
//            不拿和拿两种选择
            if (nums == k || (nums == k - 1 && cur > max)) {
                return cache[x][y][cur][nums] = 1;
            } else {
                return cache[x][y][max + 1][nums] = 0;
            }
        }

        long ans = 0;
        if (x < n - 1) {
            if (max < cur) {
                ans += dfs(x + 1, y, cur, nums + 1);
            }
            ans += dfs(x + 1, y, max, nums);
            ans %= MOD;
        }

        if (y < m - 1) {
            if (max < cur) {
                ans += dfs(x, y + 1, cur, nums + 1);
            }
            ans += dfs(x, y + 1, max, nums);
            ans %= MOD;
        }
        cache[x][y][max + 1][nums] = ans;
        return cache[x][y][max + 1][nums];
    }
}
