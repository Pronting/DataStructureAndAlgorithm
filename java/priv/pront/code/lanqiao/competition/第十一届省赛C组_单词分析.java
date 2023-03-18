package priv.pront.code.lanqiao.competition;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-17 17:03
 */
public class 第十一届省赛C组_单词分析 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char maxChar = 'a';
        int max = 0;
        String s = scanner.nextLine();
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            if (max < arr[s.charAt(i) - 'a']) {
                max = arr[s.charAt(i) - 'a'];
                maxChar = s.charAt(i);
            } else if (max == arr[s.charAt(i) - 'a']) {
                maxChar = maxChar < s.charAt(i) ? maxChar : s.charAt(i);
            }
        }
        Arrays.sort(arr);
        System.out.println(maxChar);
        System.out.println(arr[arr.length - 1]);

    }
}
