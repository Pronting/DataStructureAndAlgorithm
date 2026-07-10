package priv.pront.code.od;

import java.util.Scanner;

/**
 * 在第一人称射击游戏中，玩家通过键盘的A、S、D、W四个按键控制游戏人物分别向左、向后、向右、向前进行移动，从而完成走位。
 *
 * 假设玩家每按动一次键盘，游戏任务会向某个方向移动一步，如果玩家在操作一定次数的键盘并且各个方向的步数相同时，此时游戏任务必定会回到原点，则称此次走位为完美走位。
 *
 * 现给定玩家的走位（例如：ASDA），请通过更换其中一段连续走位的方式使得原走位能够变成一个完美走位。其中待更换的连续走位可以是相同长度的任何走位。
 *
 * 请返回待更换的连续走位的最小可能长度。
 *
 * 如果原走位本身是一个完美走位，则返回0。
 *
 * 输入描述
 * 输入为由键盘字母表示的走位s，例如：ASDA
 *
 * 输出描述
 * 输出为待更换的连续走位的最小可能长度。
 *
 * 用例1
 * 输入
 * WASDAASD
 * 输出
 * 1
 * 说明
 * 将第二个A替换为W，即可得到完美走位
 */
public class E2024_完美走位 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chs = sc.nextLine().toCharArray();
        int[] cnt = new int[4];
        int len = chs.length;
        for (char ch : chs) {
            cnt[index(ch)]++;
        }
        int target = len / 4;
        if(check(cnt, target)){
            System.out.println(0);
            return;
        }
        int left = 0;
        int ans = Integer.MAX_VALUE;
        for(int right = 0; right < len; right++){
            cnt[index(chs[right])]--;
            while(check(cnt, target)){
                ans = Math.min(ans, right - left + 1);
                cnt[index(chs[left])]++;
                left++;
            }
        }
        System.out.println(ans);

    }

    private static boolean check(int[] cnt, int target){
        for (int i : cnt) {
            if(i > target) return false;
        }
        return true;
    }

    static int index(char c) {

        if(c == 'A')
            return 0;

        if(c == 'S')
            return 1;

        if(c == 'D')
            return 2;

        return 3; // W
    }


}
