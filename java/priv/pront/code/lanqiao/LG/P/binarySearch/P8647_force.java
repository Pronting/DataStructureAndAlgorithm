package priv.pront.code.lanqiao.LG.P.binarySearch;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-01-12 14:17
 */
public class P8647_force {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] chocInfo = new int[n][2];
        int size = 1;
        for (int i = 0; i < n; i++) {
            chocInfo[i][0] = in.nextInt();
            chocInfo[i][1] = in.nextInt();
        }
        int flag, sum;
        while (true) {
            sum = 0;
            flag = 0;
            for (int i = 0; i < n; i++) {
                int height = chocInfo[i][0];
                int width = chocInfo[i][1];
                sum += (height / size) * (width / size);
                if (sum >= k) {
                    size++;
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                break;
            }
        }
//        n-1
        System.out.print(size - 1);
    }
}
