package priv.pront.code.od;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class E2024_寻找密码 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        Set<String> set = new HashSet<>();
        for (String s : split) {
            set.add(s);
        }
        String ans = "";
        for (String word : split) {
           int len = word.length();
           boolean ok = true;
           for(int i = 0; i < word.length(); i++){
               String newStr = word.substring(0, len - i);
               if(!set.contains(newStr)){
                   ok = false;
                   break;
               }
           }
           if(ok){
               if(ans.length() < len){
                   ans = word;
               }else if(ans.length() == len){
                   if(ans.compareTo(word) < 0) ans = word;
               }
           }
        }
        System.out.println(ans);
    }
}
