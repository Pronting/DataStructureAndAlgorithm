package priv.pront.code.od;

import java.util.Scanner;

/**
 * 喊7是一个传统的聚会游戏，N个人围成一圈，按顺时针从1到N编号。
 *
 * 编号为1的人从1开始喊数，下一个人喊的数字为上一个人的数字加1，但是当将要喊出来的数字是7的倍数或者数字本身含有7的话，不能把这个数字直接喊出来，而是要喊”过”。
 *
 * 假定玩这个游戏的N个人都没有失误地在正确的时机喊了”过”，当喊到数字K时，可以统计每个人喊”过”的次数。
 *
 * 现给定一个长度为N的数组，存储了打乱顺序的每个人喊”过”的次数，请把它还原成正确的顺序，即数组的第i个元素存储编号i的人喊”过”的次数。
 *
 * 输入描述
 * 输入为一行，为空格分隔的喊”过”的次数，注意K并不提供，K不超过200，而数字的个数即为N。
 *
 * 输出描述
 * 输出为一行，为顺序正确的喊”过”的次数，也由空格分隔。
 */
public class E2024_喊7的数字重排 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int k = 0;
        int n = split.length;
        for (String s : split) k += Integer.parseInt(s);
        int[] arr = new int[n];
        int idx = 0;
        int count = 0;
        int num = 1;
        while(count < k){
            if(num % 7 == 0 || (num + "").contains("7")){
                count++;
                arr[idx]++;
                idx = (idx + 1) % n;
                num++;
                continue;
            }
            idx = (idx + 1) % n;
            num++;
        }
        for(int i = 0; i  < n ;i++) System.out.print(arr[i] + " ");
    }
}
