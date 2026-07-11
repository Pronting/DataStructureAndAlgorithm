package priv.pront.code.od;

import java.util.*;

public class E2024_寻找最大价值的矿堆 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (str.isEmpty()) {
                break;
            }
            list.add(str);
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int row = list.size();
        int col = list.get(0).length();
        boolean[][] vis = new boolean[row][col];
        int ans = 0;
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            String str = list.get(i);
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(str.substring(j, j + 1));
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] != 0 && !vis[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    vis[i][j] = true;
                    int sum = arr[i][j];
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = cur[0] + dx[k];
                            int ny = cur[1] + dy[k];
                            if (nx < 0 || nx >= row || ny < 0 || ny >= col || vis[nx][ny] || arr[nx][ny] == 0) continue;
                            vis[nx][ny] = true;
                            sum += arr[nx][ny];
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                    System.out.println(ans);
                }
            }
        }
    }
}
