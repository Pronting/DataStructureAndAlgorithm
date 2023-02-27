package priv.pront.code.leetcode.str;

import java.util.List;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-27 21:16
 */
public class L139_WordBreak {

//    KMP情况没考虑全，但是思路可行
    public boolean wordBreak(String s, List<String> wordDict) {
        return process(s, wordDict, 0);
    }

    public boolean process(String s, List<String> wordDict, int index) {
        if (s.length() == 0) {
            return true;
        }
        for (int i = index; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            int startIndex = getIndexOf(s, word);
            if (startIndex == 0) {
                // 从匹配成功的位置继续向后匹配
                if (process(s.substring(word.length()), wordDict, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    public int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            if (ms[i - 1] == ms[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

//      dp
    public boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        // dp[i] 表示 s 的前 i 个字符是否可以拆分成字典中的单词
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && s.substring(i - len, i).equals(word)) {
                    dp[i] |= dp[i - len];
                }
            }
        }

        return dp[n];
    }


}
