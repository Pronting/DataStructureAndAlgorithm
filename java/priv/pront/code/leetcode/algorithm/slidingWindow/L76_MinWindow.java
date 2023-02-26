package priv.pront.code.leetcode.algorithm.slidingWindow;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-26 19:35
 */
public class L76_MinWindow {

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        // 定义两个指针和一个计数器
        int left = 0, right = 0, count = t.length();
        // 定义一个计数器，用于记录 t 中每个字符出现的次数
        int[] tCount = new int[256];
        for (char c : t.toCharArray()) {
            tCount[c]++;
        }
        // 定义一个最小子串的起始位置和长度
        int minLeft = 0, minLen = Integer.MAX_VALUE;
        // 移动 right 指针
        while (right < s.length()) {
            char c = s.charAt(right);
            if (tCount[c] > 0) {
                // 如果当前字符在 t 中出现过，则计数器减一
                count--;
            }
            // 在计数器中减少当前字符的计数
            tCount[c]--;
            right++;
            // 当窗口中包含 t 中的所有字符时，移动 left 指针
            while (count == 0) {
                // 如果当前子串比最小子串更短，则更新最小子串的起始位置和长度
                if (right - left < minLen) {
                    minLen = right - left;
                    minLeft = left;
                }
                // 移动左指针
                char d = s.charAt(left);
                if (tCount[d] == 0) {
                    // 如果当前字符在 t 中出现过，则计数器加一
                    count++;
                }
                // 在计数器中增加当前字符的计数
                tCount[d]++;
                left++;
            }
        }
        // 如果没有找到符合要求的子串，则返回空字符串
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        // 返回最短的子串
        return s.substring(minLeft, minLeft + minLen);
    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        minWindow(s, t);
    }
}
