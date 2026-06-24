package priv.pront.code.od;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 题目描述
 * 近些年来，我国防沙治沙取得显著成果。某沙漠新种植N棵胡杨（编号1-N），排成一排。
 *
 * 一个月后，有M棵胡杨未能成活。
 *
 * 现可补种胡杨K棵，请问如何补种（只能补种，不能新种），可以得到最多的连续胡杨树？
 *
 * 输入描述
 * N 总种植数量，1 <= N <= 100000
 *
 * M 未成活胡杨数量，M 个空格分隔的数，按编号从小到大排列，1 <= M <= N
 *
 * K 最多可以补种的数量，0 <= K <= M
 *
 * 输出描述
 * 最多的连续胡杨棵树
 */
public class E2024_LongestOnes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < M; i++) set.add(sc.nextInt());
        int K = sc.nextInt();
        int[] arr = new int[N + 1];
        Arrays.fill(arr, 1);
        for(int i = 1; i <= N; i++){
            if(set.contains(i)) arr[i] = 0;
        }
        int l = 1;
        int zero = 0;
        int ans = 0;
        for(int i = 1; i <= N; i++){
            if(arr[i] == 0) zero ++;
            while(zero > K){
                if(arr[l] == 0) zero--;
                l++;
            }
            ans = Math.max(ans, i - l + 1);
        }
        System.out.println(ans);
    }
}
