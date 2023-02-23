package priv.pront.code.leetcode.str;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-23 20:17
 */
public class L214_ShortestPalindrome {

    // KMP
    public static String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String rev = new StringBuilder(s).reverse().toString();
        String str = s + "#" + rev;
        int n = str.length();
        int[] next = new int[n];

        // 计算next数组
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = next[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        int len = next[n - 1]; // 最长回文前缀的长度
        String prefix = s.substring(len); // 原字符串需要添加的部分
        String suffix = new StringBuilder(prefix).reverse().toString(); // 逆序后缀
        return suffix + s;
    }

    public static void main(String[] args) {
        String s = "aacecaaa";
        System.out.println(shortestPalindrome(s));

    }
}
