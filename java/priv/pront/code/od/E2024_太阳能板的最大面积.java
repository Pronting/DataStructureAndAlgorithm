package priv.pront.code.od;

import java.util.Scanner;

/**
 * 给航天器一侧加装长方形或正方形的太阳能板（图中的红色斜线区域），需要先安装两个支柱（图中的黑色竖条），再在支柱的中间部分固定太阳能板。但航天器不同位置的支柱长度不同，太阳能板的安装面积受限于最短一侧的那根支柱长度。如图：
 *
 *
 * 现提供一组整形数组的支柱高度数据，假设每根支柱间距离相等为1个单位长度，计算如何选择两根支柱可以使太阳能板的面积最大
 *
 * 输入描述
 * 10,9,8,7,6,5,4,3,2,1
 *
 * 注：支柱至少有2根，最多10000根，能支持的高度范围1~10^9的整数。柱子的高度是无序的，例子中递减只是巧合
 */
public class E2024_太阳能板的最大面积 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        int n = split.length;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(split[i]);
        int l = 0, r = n - 1;
        int ans = 0;
        while(l < r){
            ans = Math.max(ans, Math.min(arr[l], arr[r]) * (r - l));
            if(arr[l] < arr[r]) l++;
            else r--;
        }
        System.out.println(ans);
    }
}
