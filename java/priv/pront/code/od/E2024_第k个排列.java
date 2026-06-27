package priv.pront.code.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给定参数n，从1到n会有n个整数：1,2,3,…,n,这n个数字共有n!种排列。
 *
 * 按大小顺序升序列出所有排列的情况，并一一标记，
 *
 * 当n=3时,所有排列如下:
 *
 * “123” “132” “213” “231” “312” “321”
 *
 * 给定n和k，返回第k个排列。
 *
 * 输入描述
 * 输入两行，第一行为n，第二行为k，
 * 给定n的范围是[1,9],给定k的范围是[1,n!]。
 * 输出描述
 * 输出排在第k位置的数字。
 */
public class E2024_第k个排列 {

    static List<String> list = new ArrayList<>();
    static boolean[] st;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int k = sc.nextInt();
        st = new boolean[num + 1];
        dfs(num, new StringBuilder());
        System.out.println(list.get(k - 1));
    }

    public static void dfs(int num, StringBuilder sb){
        if(sb.length() == num){
            list.add(sb.toString());
            return;
        }
        for(int i = 1; i <= num; i ++){
            if(!st[i]){
                sb.append(i);
                st[i] = true;
                dfs(num, sb);
                st[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }
}
