package priv.pront.code.leetcode.algorithm.doublePointer;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-12 14:47
 */
public class L151_ReverseWords {

    public static String reverseWords(String s) {
        String[] str = s.trim().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (!str[i].equals("")) {
                builder.append(str[i] + " ");
            }
        }
        return builder.toString().trim();
    }

    public static void main(String[] args) {
        String s = " the         sky     is blue    ";
        System.out.println(reverseWords(s));
    }
}
