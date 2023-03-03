package priv.pront.code.lanqiao.competition;
import java.util.Scanner;
/**
 * @Description: 10 题目的dfs
 * @Author: pront
 * @Time:2023-03-03 11:43
 */
public class Main10_2 {

        static int n, m;
        static int[][] matrix;
        static boolean[][] visited;
        static int[][] dist;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            m = scanner.nextInt();
            matrix = new int[n][m];
            visited = new boolean[n][m];
            dist = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            if(n == 1 && m == 1){
                System.out.println(0);
                return;
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
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

            if (i > 0 && matrix[i - 1][j] < matrix[i][j]) {
                maxDist = Math.max(maxDist, dfs(i - 1, j));
            }
            if (i < n - 1 && matrix[i + 1][j] < matrix[i][j]) {
                maxDist = Math.max(maxDist, dfs(i + 1, j));
            }
            if (j > 0 && matrix[i][j - 1] < matrix[i][j]) {
                maxDist = Math.max(maxDist, dfs(i, j - 1));
            }
            if (j < m - 1 && matrix[i][j + 1] < matrix[i][j]) {
                maxDist = Math.max(maxDist, dfs(i, j + 1));
            }

            visited[i][j] = true;
            dist[i][j] = maxDist + 1;
            return dist[i][j];
        }
    }

