package priv.pront.code.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 用数组代表每个人的能力，一个比赛活动要求参赛团队的最低能力值为N，每个团队可以由1人或者2人组成，且1个人只能参加1个团队，计算出最多可以派出多少只符合要求的团队
 *
 * 输入描述
 * 第一行代表总人数，范围1-500000 第二行数组代表每个人的能力 数组大小，范围1-500000 元素取值，范围1-500000 第三行数值为团队要求的最低能力值，范围1-500000
 *
 * 输出描述
 * 最多可以派出的团队数量
 */
public class E2024_最多可以派出多少团队 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int target = sc.nextInt();
        Arrays.sort(arr);
        int l = 0, r = n - 1;
        int ans = 0;
        while(l < r){
            if(arr[r] >= target){
                r--;
                ans++;
            }else if(arr[r] + arr[l] >= target){
                r--;
                l++;
                ans++;
            }else{
                break;
            }
        }
        System.out.println(ans);
    }
}
