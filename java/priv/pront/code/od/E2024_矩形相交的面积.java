package priv.pront.code.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给出3组点坐标(x, y, w, h)，-1000<x,y<1000，w,h为正整数。
 *
 * (x, y, w, h)表示平面直角坐标系中的一个矩形：
 *
 * x, y为矩形左上角坐标点，w, h向右w，向下h。
 *
 * (x, y, w, h)表示x轴(x, x+w)和y轴(y, y-h)围成的矩形区域；
 *
 * (0, 0, 2, 2)表示 x轴(0, 2)和y 轴(0, -2)围成的矩形区域；
 *
 * (3, 5, 4, 6)表示x轴(3, 7)和y轴(5, -1)围成的矩形区域；
 *
 * 求3组坐标构成的矩形区域重合部分的面积。
 *
 * 输入描述
 * 3行输入分别为3个矩形的位置，分别代表“左上角x坐标”，“左上角y坐标”，“矩形宽”，“矩形高” -1000 <= x,y < 1000
 *
 * 输出描述
 * 输出3个矩形相交的面积，不相交的输出0。
 */
public class E2024_矩形相交的面积 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int weight = sc.nextInt();
            int height = sc.nextInt();
            int x2 = x1 + weight;
            int y2 = y1 - height;
            list.add(new int[]{x1, y1, x2, y2});
        }
        int[] matrix1 = list.get(0);
        int[] matrix2 = list.get(1);
        int[] matrix3 = list.get(2);
        int m1x1 = matrix1[0];
        int m1y1 = matrix1[1];
        int m1x2 = matrix1[2];
        int m1y2 = matrix1[3];
        int m2x1 = matrix2[0];
        int m2y1 = matrix2[1];
        int m2x2 = matrix2[2];
        int m2y2 = matrix2[3];
        int m3x1 = matrix3[0];
        int m3y1 = matrix3[1];
        int m3x2 = matrix3[2];
        int m3y2 = matrix3[3];
        // 判断是否不存在
//        if(m1x2 < m2x1 || m1x2 < m3x1 || m1y2 >m2y1 || m1y2 > m3y1 ||
//           m2x2 < m1x1 || m2x2 < m3x1 || m2y2 > m1y1 || m2y2 > m3y1 ||
//           m3x2 < m1x1 || m3x2 < m2x1 || m3y2 > m1y1 || m3y2 > m2y1) {
//            System.out.println(-1);
//            return;
//        }

        int lefttopx = Math.max(Math.max(m1x1, m2x1), m3x1);
        int lefttopy = Math.min(Math.min(m1y1, m2y1), m3y1);
        int rightbottmx = Math.min(Math.min(m1x2, m2x2), m3x2);
        int rightbottmy = Math.max(Math.max(m1y2, m2y2), m3y2);
        System.out.println((rightbottmx - lefttopx) * (lefttopy - rightbottmy));


    }
}
