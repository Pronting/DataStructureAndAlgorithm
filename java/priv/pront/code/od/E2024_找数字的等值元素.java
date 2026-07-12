package priv.pront.code.od;

import java.util.*;

public class E2024_找数字的等值元素 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] arr = new int[row][col];
        // value -> 所有坐标
        Map<Integer, List<int[]>> map = new HashMap<>();
        // 第一遍读取，同时保存坐标
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
                map.computeIfAbsent(arr[i][j], k -> new ArrayList<>())
                        .add(new int[]{i, j});
            }
        }

        // 输出格式
        System.out.print("[");
        for (int i = 0; i < row; i++) {
            if (i != 0) {
                System.out.print(",");
            }
            System.out.print("[");
            for (int j = 0; j < col; j++) {
                if (j != 0) {
                    System.out.print(",");
                }
                List<int[]> list = map.get(arr[i][j]);
                if (list.size() == 1) {
                    System.out.print(-1);
                    continue;
                }
                int ans = Integer.MAX_VALUE;
                for (int[] p : list) {
                    // 自己跳过
                    if (p[0] == i && p[1] == j) {
                        continue;
                    }
                    int dis = Math.abs(i - p[0]) + Math.abs(j - p[1]);
                    ans = Math.min(ans, dis);
                }
                System.out.print(ans);
            }
            System.out.print("]");
        }
        System.out.print("]");
    }
}
