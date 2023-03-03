package priv.pront.code.lanqiao.competition;

import java.util.Scanner;

/**
 * @Description: 小蓝负责一块区域的信号塔安装，整块区域是一个长方形区域，
 * 建立坐标轴后，西南角坐标为 (0, 0)， 东南角坐标为 (W, 0)， 西北角坐标为 (0, H)， 东北角坐标为 (W, H)。其中 W, H 都是整数。
 * 　　他在 n 个位置设置了信号塔，每个信号塔可以覆盖以自己为圆心，半径为 R 的圆形（包括边缘）。
 * 　　为了对信号覆盖的情况进行检查，小蓝打算在区域内的所有横纵坐标为整数的点进行测试，
 * 检查信号状态。其中横坐标范围为 0 到 W，纵坐标范围为 0 到 H，总共测试 (W+1) * (H+1) 个点。
 * 　　给定信号塔的位置，请问这 (W+1)*(H+1) 个点中有多少个点被信号覆盖。
 * @Author: pront
 * @Time:2023-03-03 10:28
 */
public class Main7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int H = sc.nextInt();
        int n = sc.nextInt();
        int R = sc.nextInt();

        // 定义一个二维数组，用来表示网格
        int[][] grid = new int[W + 1][H + 1];

        // 循环读入信号塔的坐标，并将覆盖区域内的网格标记为 1
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int j = Math.max(0, x - R); j <= Math.min(W, x + R); j++) {
                for (int k = Math.max(0, y - R); k <= Math.min(H, y + R); k++) {
                    if (Math.pow(j - x, 2) + Math.pow(k - y, 2) <= Math.pow(R, 2)) {
                        grid[j][k] = 1;
                    }
                }
            }
        }

        // 统计被覆盖的点的数量
        int count = 0;
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j <= H; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
