package priv.pront.code.od;

import java.util.Scanner;

public class E2024_关联子串 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        String s1 = split[0];
        String s2 = split[1];
        if(s1.length() > s2.length()){
            System.out.println(-1);
            return;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i = 0; i < s1.length(); i++) count1[s1.charAt(i) -'a'] ++;
        int l = 0;
        int r = 0;
        while(r < s2.length()){
            count2[s2.charAt(r) - 'a'] ++;
            if(r - l + 1 == s1.length()){
                if(check(count1, count2)){
                    System.out.println(l);
                    return;
                }
                count2[s2.charAt(l++) -'a'] --;
            }
            r++;
        }
        System.out.println(-1);
    }

    private static boolean check(int[] cnt1, int[] cnt2){
        for(int i = 0; i < 26; i++){
            if(cnt1[i] == 0) continue;
            if(cnt1[i] == cnt2[i]) return false;
        }
        return true;
    }
}
