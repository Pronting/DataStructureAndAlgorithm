package priv.pront.code.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 服务之间交换的接口成功率作为服务调用关键质量特性，某个时间段内的接口失败率使用一个数组表示，
 *
 * 数组中每个元素都是单位时间内失败率数值，数组中的数值为0~100的整数，
 *
 * 给定一个数值(minAverageLost)表示某个时间段内平均失败率容忍值，即平均失败率小于等于minAverageLost，
 *
 * 找出数组中最长时间段，如果未找到则直接返回NULL。
 *
 * 输入描述
 * 输入有两行内容，第一行为{minAverageLost}，第二行为{数组}，数组元素通过空格(” “)分隔，
 *
 * minAverageLost及数组中元素取值范围为0~100的整数，数组元素的个数不会超过100个。
 *
 * 输出描述
 * 找出平均值小于等于minAverageLost的最长时间段，输出数组下标对，格式{beginIndex}-{endIndx}(下标从0开始)，
 *
 * 如果同时存在多个最长时间段，则输出多个下标对且下标对之间使用空格(” “)拼接，多个下标对按下标从小到大排序。
 */
public class E2024_ScanInterface {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        String[] s = sc.nextLine().split(" ");
        int n  = s.length;
        int[] arr = new int[n];
        int[] pre = new int[n + 1];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]) - k;
        }
        for(int i = 1; i <= n; i++){
            pre[i] = pre[i - 1] + arr[i - 1];
        }

        int maxLen = 0;
        List<int[]> ans = new ArrayList<>();
        for(int r = 1; r <= n; r++){
            for(int l = 0; l < r; l++){
                int sum = pre[r] - pre[l];
                if(sum <= 0){
                    int len = r - l;
                    if(len > maxLen){
                        maxLen = len;
                        ans.clear();
                        ans.add(new int[]{l, r - 1});
                    }else if(len == maxLen){
                        ans.add(new int[]{l, r - 1});
                    }
                }
            }
        }
        if(ans.isEmpty()){
            System.out.println("NULL");
            return;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i)[0])
                    .append("-")
                    .append(ans.get(i)[1]);

            if (i != ans.size() - 1) sb.append(" ");
        }

        System.out.println(sb);


    }
}
