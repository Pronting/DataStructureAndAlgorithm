package priv.pront.code.leetcode.algorithm.slidingWindow;

import java.util.*;

/**
 * @Description: 滑动窗口 + 每个位置的末尾位置数组
 * @Author: pront
 * @Time:2023-02-26 14:06
 */
public class L3_LengthOfLongestSubString {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int index = 0;
        int max = Integer.MIN_VALUE;
        int curMax = 0;

        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        while (index < s.length()) {
            if (!set.contains(s.charAt(index))) {
                curMax++;
                max = Math.max(max, curMax);
            } else {
                index = map.get(s.charAt(index)) + 1;
                curMax = 1;
                map = new HashMap<>();
                set = new HashSet<>();
            }
            map.put(s.charAt(index), index);
            set.add(s.charAt(index));
            index++;
        }
        return max;

    }


    public static int lengthOfLongestSubstring2(String s) {
        int[] last = new int[128];
        Arrays.fill(last, -1);
        int n = s.length();
        int res = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;

    }


    public static int lengthOfLongestSubstring3(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring3(s));
    }
}
