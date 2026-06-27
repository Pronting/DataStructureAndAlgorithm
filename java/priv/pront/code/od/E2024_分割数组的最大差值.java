package priv.pront.code.od;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

/**
 * 给定一个由若干整数组成的数组nums ，可以在数组内的任意位置进行分割，将该数组分割成两个非空子数组（即左数组和右数组），分别对子数组求和得到两个值，计算这两个值的差值，请输出所有分割方案中，差值最大的值。
 *
 * 输入描述
 * 第一行输入数组中元素个数n，1 < n ≤ 100000
 * 第二行输入数字序列，以空格进行分隔，数字取值为4字节整数
 *
 * 输出描述
 * 输出差值的最大取值
 */
public class E2024_分割数组的最大差值 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int[] pre = new int[n + 1];
        for(int i = 1; i <= n; i++){
            pre[i] = pre[i - 1] + arr[i - 1];
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(Math.abs(pre[i] - (pre[n] - pre[i])), ans);
        }
        System.out.println(ans);
    }
}
