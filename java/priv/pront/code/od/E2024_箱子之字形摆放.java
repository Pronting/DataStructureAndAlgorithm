package priv.pront.code.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有一批箱子（形式为字符串，设为str），要求将这批箱子按从上到下以之字形的顺序摆放在宽度为 n 的空地，请输出箱子的摆放位置。例如：箱子ABCDEFG，空地宽度为3，摆放结果如图：
 *
 *
 *
 * 则输出结果为：
 * AFG
 * BE
 * CD
 *
 * 输入描述
 */
public class E2024_箱子之字形摆放 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        String str = split[0];
        int weight = Integer.parseInt(split[1]);
        int len = str.length();
        int height = (int)Math.ceil(len / (weight * 1.0));
        char[][] arr = new char[height][weight];
        for (char[] chars : arr) {
            Arrays.fill(chars, '0');
        }
        int[] dx = new int[]{1, 0, -1};
        int[] dy = new int[]{0, 1, 0};
        int x = 0, y = 0;
        int idx = 0;
        boolean flag = false;
        for(int i = 0; i <= len; i++){
            arr[x][y] = str.charAt(i);
            if(idx == 1) flag = true;
            y = y + dy[idx];
            x = x + dx[idx];
            if(x < 0 || x >= height || flag){
                y = y - dy[idx];
                x = x - dx[idx];
                idx = (idx + 1) % 3;
                y = y + dy[idx];
                x = x + dx[idx];
                flag = false;
            }
        }

        for(int i = 0; i < height; i ++){
            if(i != 0) System.out.println();
            for(int j = 0; j < weight; j ++){
                if(j != 0) System.out.print(" ");
                if(arr[i][j] == '0') continue;
                System.out.print(arr[i][j]);
            }
        }
    }
}
