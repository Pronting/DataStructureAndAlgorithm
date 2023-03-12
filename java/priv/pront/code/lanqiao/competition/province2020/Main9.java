package priv.pront.code.lanqiao.competition.province2020;

import java.util.Scanner;

/**
 * @Description: 小明发明了一种给由全大写字母组成的字符串编码的方法。对于每一个大
 * 写字母，小明将它转换成它在 26 个英文字母中序号，即 A → 1, B → 2, … Z →
 * 26。
 * 这样一个字符串就能被转化成一个数字序列：
 * 比如 ABCXYZ → 123242526。
 * 现在给定一个转换后的数字序列，小明想还原出原本的字符串。当然这样
 * 的还原有可能存在多个符合条件的字符串。小明希望找出其中字典序最大的字
 * 符串。
 *
 * @Author: pront
 * @Time:2023-03-12 15:02
 */
public class Main9 {

    public static void main(String[] args) {
        String[] arr = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        char[] chs = number.toCharArray();
        StringBuilder builder = new StringBuilder();
        int index = 0;
        int point = 0;
        while (index < chs.length) {
//            首字母为1，2的情况下，可以考虑下一位
            if ((chs[index] == '2' && index + 1 < chs.length && chs[index + 1] - '0' <= 6) || (chs[index] == '1' && index + 1 < chs.length)) {
                point = (chs[index]- '0') * 10 + chs[index + 1] - '0';
                builder.append(arr[point - 1]);
                index += 2;
            } else {
//                剩下的只能考虑一位了
                point = chs[index] - '0';
                builder.append(arr[point - 1]);
                index++;
            }
        }
        System.out.println(builder);
    }
}
