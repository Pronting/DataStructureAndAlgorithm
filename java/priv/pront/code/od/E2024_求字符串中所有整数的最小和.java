package priv.pront.code.od;

import java.util.Scanner;

/**
 * 输入字符串s，输出s中包含所有整数的最小和。
 *
 * 字符串s，只包含 a-z A-Z ± ；
 *
 * 合法的整数包括
 *
 * 正整数 一个或者多个0-9组成，如 0 2 3 002 102
 * 负整数 负号 – 开头，数字部分由一个或者多个0-9组成，如 -0 -012 -23 -00023
 * 输入描述
 * 包含数字的字符串
 *
 * 输出描述
 * 所有整数的最小和
 *
 * 用例1
 * 输入
 * bb1234aa
 * 输出
 * 10
 */
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
