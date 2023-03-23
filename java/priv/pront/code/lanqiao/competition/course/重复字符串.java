package priv.pront.code.lanqiao.competition.course;

import java.util.Scanner;

public class 重复字符串 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        String S = scanner.next();

//        输出-1的情况
        if (S.length() == 1 || S.length() % K != 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(process(K, S));
    }

    private static int process(int k, String s) {
        int ans = 0;
        int split = s.length() / k;
        String[] strArr = new String[k];
        String temp = s;
        for (int i = 0; i < k; i++) {
            strArr[i] = temp.substring(0, split);
            temp = temp.substring(split);
        }
//        遍历拆分后的数组字符串的每一个位置
        for (int i = 0; i < split; i++) {
        int[] arr = new int[26];
            int max = Integer.MIN_VALUE;
//            每一个位置所对应的词频
            for (int j = 0; j < strArr.length; j++) {
//                遍历数组中的每一个字符位置，统计词频
                arr[strArr[j].charAt(i) - 'a']++;
//                更新max
                max = Math.max(max, arr[strArr[j].charAt(i) - 'a']);
            }
            ans += strArr.length - max;
        }
        return ans;
    }

}
