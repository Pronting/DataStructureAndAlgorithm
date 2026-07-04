package priv.pront.code.od;

import java.util.Scanner;

public class E2024_求字符串中所有整数的最小和 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int ans = 0;
        int i = 0;
        while(i < str.length()){
            char c = str.charAt(i);
            if(c == '-'){
                int sum = 0;
                i++;
                c = str.charAt(i);
                if(Character.isDigit(c)){
                    while(Character.isDigit(c)){
                        sum = sum * 10 + (c - '0');
                        if(i + 1 >= str.length()) break;
                        i++;
                        c = str.charAt(i);
                    }
                    ans -= sum;
                }

            }else if(Character.isDigit(c)){
                while(Character.isDigit(c)){
                    ans += c - '0';
                    i++;
                    c = str.charAt(i);
                }
            }else{
                i++;
            }

        }
        System.out.println(ans);
    }
}
