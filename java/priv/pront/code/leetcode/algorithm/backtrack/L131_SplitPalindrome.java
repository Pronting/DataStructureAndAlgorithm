package priv.pront.code.leetcode.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-08 20:43
 */
// FIXME 待优化
public class L131_SplitPalindrome {

    public static List<List<String>> res = new ArrayList<>();
    public static List<String> path = new ArrayList<>();

    public static List<List<String>> splitPalindrome(String s) {
        backtracking(s, 0);
        return res;
    }

//    并未进行剪枝优化 7ms
    public static void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
//                substring的取值范围是左闭右开
                path.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            backtracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    private static boolean isPalindrome(String s, int startIndex, int endIndex) {
        for (int i = startIndex, j = endIndex; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String word = "aab";
        System.out.println(splitPalindrome(word));

    }
}
