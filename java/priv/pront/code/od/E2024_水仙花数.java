package priv.pront.code.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 所谓水仙花数，是指一个n位的正整数，其各位数字的n次方和等于该数本身。
 *
 * 例如153是水仙花数，153是一个3位数，并且153 = 1^3 + 5^3 + 3^3。
 *
 * 输入描述
 * 第一行输入一个整数n，表示一个n位的正整数。n在3到7之间，包含3和7。
 *
 * 第二行输入一个正整数m，表示需要返回第m个水仙花数。
 *
 * 输出描述
 * 返回长度是n的第m个水仙花数。个数从0开始编号。
 *
 * 若m大于水仙花数的个数，返回最后一个水仙花数和m的乘积。
 *
 * 若输入不合法，返回-1。
 */
public class E2024_水仙花数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int digit = sc.nextInt();
        int idx = sc.nextInt();
        int n = (int) Math.pow(10, digit) - 1;
        List<Integer> ans = new ArrayList<>();
        for(int i = (int) Math.pow(10, digit - 1); i < n; i++){
            if(isShuixianhua(i)) ans.add(i);
        }
        System.out.println(ans.get(idx));
    }

    private static boolean isShuixianhua(int num){
        int sum = 0;
        int copy = num;
        while(copy != 0){
            int ge = copy % 10;
            sum += ge * ge * ge;
            copy /= 10;
        }
        return sum == num;
    }
}
