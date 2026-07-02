package priv.pront.code.od;

import java.util.Arrays;
import java.util.Scanner;

public class E2024_恢复数字序列 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sp = sc.nextLine().split(" ");
        String str = sp[0];
        int n = Integer.parseInt(sp[1]);
        int[] cnt = new int[10];
        for(int i = 0; i < str.length(); i++) cnt[str.charAt(i) - '0']++;

        for(int i = 0; i <= 1000; i ++){
            int start = i;
            int[] cnt1 = Arrays.copyOf(cnt, 10);
            int count = 0;
            while(count < n){
                String s = start + "";
                int len = s.length();
                boolean f = true;
                for(int k = 0; k < len; k++){
                    if(cnt1[s.charAt(k) - '0'] - 1 < 0){
                        f = false;
                        break;
                    }
                    cnt1[s.charAt(k) - '0']--;
                }
                if(!f) break;
                start ++;
                count++;
            }
            if(count == n){
                boolean flag = true;
                for (int c : cnt1) {
                    if(c > 0){
                        flag = false;
                        break;
                    }
                }
                if(flag) System.out.println(i);
            }
        }
    }
}
