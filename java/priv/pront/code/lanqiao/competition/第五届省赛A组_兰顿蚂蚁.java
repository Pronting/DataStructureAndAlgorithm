package priv.pront.code.lanqiao.competition;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-17 18:46
 */
public class 第五届省赛A组_兰顿蚂蚁 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        int[][] grid = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        int x = scanner.nextInt();  //蚂蚁所在的行号
        int y = scanner.nextInt();  // 蚂蚁所在的列号
        String s = scanner.next(); // 蚂蚁头的朝向
        int k = scanner.nextInt();  // 蚂蚁走的步数
        int d = getD(s);
        int step = 0;
        while (step != k) {
            if (grid[x][y] == 1) {
                grid[x][y] = 0;
                d = d % 4 + 1;
            } else {
                d--;
                if (d == 0) d = 4;
                grid[x][y] = 1;
            }
            if (d == 1) x--;
            if (d == 2) y++;
            if (d == 3) x++;
            if (d == 4) y--;
            step++;
        }
        System.out.println(x + " " + y);
    }

    public static int getD(String s) {
        switch (s) {
            case "U":
                return 1;
            case "R":
                return 2;
            case "D":
                return 3;
            case "L":
                return 4;
            default:
                return -1;
        }
    }
}
