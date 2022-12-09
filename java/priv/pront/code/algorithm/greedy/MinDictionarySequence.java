package priv.pront.code.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description: 给定一个字符串数组，决定一种拼接方式，将每一个字符串都拼接起来
 * 使最后的大字符串拥有的字典序(长度一样化作26进制比较，长度不一样将短的补位0)最小
 * @Author: pront
 * @Time:2022-09-04 16:16
 */
public class MinDictionarySequence {
    public static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }
}
