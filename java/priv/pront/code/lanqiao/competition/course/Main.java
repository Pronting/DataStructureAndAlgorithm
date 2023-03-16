package priv.pront.code.lanqiao.competition.course;

import java.util.Scanner;
import java.lang.Math;
/**
 * @Description: 砍竹子
 * @Author: pront
 * @Time:2023-03-16 16:39
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[200000];
        int num = 0, max = 0;
        for(int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        for(int i = 0; i < n; i++) { // 求最大值
            if(a[i] >= max) {
                max = a[i];
            }
        }
        while(max != 1) {
            for(int i = 0; i < n; i++) { // 求最大值
                if(a[i] >= max) {
                    max = a[i];
                }
            }
            /* 魔法只在相邻位生效 */
            for(int i = 0; i < n; i++) { // 最大值全部替换
                if(a[i] == max && a[i + 1] == max) {
                    a[i] = (int) Math.floor(Math.sqrt(max / 2 + 1));
                }
                if(a[i] == max && a[i + 1] != max) {
                    a[i] = (int) Math.floor(Math.sqrt(max / 2 + 1));
                    break;
                }
            }
            max = 0;
            for(int i = 0; i < n; i++) { // 求最大值
                if(a[i] >= max) {
                    max = a[i];
                }
            }
            num++;
        }
        System.out.println(num);
    }
}

