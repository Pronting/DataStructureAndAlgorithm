package priv.pront.code.od;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 题目描述
 * 疫情过后，希望小学终于又重新开学了，三年二班开学第一天的任务是将后面的黑板报重新制作。
 *
 * 黑板上已经写上了N个正整数，同学们需要给这每个数分别上一种颜色。
 *
 * 为了让黑板报既美观又有学习意义，老师要求同种颜色的所有数都可以被这种颜色中最小的那个数整除。
 *
 * 现在请你帮帮小朋友们，算算最少需要多少种颜色才能给这N个数进行上色。
 *
 * 输入描述
 * 第一行有一个正整数N，其中。
 *
 * 第二行有N个int型数(保证输入数据在[1,100]范围中)，表示黑板上各个正整数的值。
 *
 * 输出描述
 * 输出只有一个整数，为最少需要的颜色种数
 */
public class E2024_数字涂色 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            set.add(arr[i]);
        }
        Arrays.sort(arr);
        int ans = 0;
        for(int i = 0; i < n; i++){
            int cur = arr[i];
            int idx = 1;
            if(set.contains(cur)){
                ans++;
                while(cur <= 100){
                    set.remove(cur);
                    cur = arr[i] * (++idx);
                }
            }
        }
        System.out.println(ans);

    }
}
