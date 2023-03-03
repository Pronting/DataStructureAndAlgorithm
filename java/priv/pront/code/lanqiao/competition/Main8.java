package priv.pront.code.lanqiao.competition;

import java.util.Scanner;

/**
 * @Description: 　输入一个字符串，请判断这个字符串是否正好是 lanqiao 。
 * 在输入时如果只是大小写不同也算作相同。
 * 输入格式 　　输入一行包含一个字符串。 输出格式 　
 * 　如果是 lanqiao ，输出全小写的字符串 yes ，否则输出全小写的字符串 no 。
 * @Author: pront
 * @Time:2023-03-03 10:49
 */
public class Main8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String res;
        if ("lanqiao".equalsIgnoreCase(word)) {
            res = "yes";
        }else{
            res = "no";
        }
        System.out.println(res);
    }
}
