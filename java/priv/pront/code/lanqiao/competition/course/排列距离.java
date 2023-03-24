package priv.pront.code.lanqiao.competition.course;

import java.util.Set;
import java.util.TreeSet;

public class 排列距离 {
    //    abcdefghijklnopqr
    static Set<String> set = new TreeSet<>();
    public static void main(String[] args) {
        char[] chs = "abcdefghijklnopqr".toCharArray();
        process(chs, 0);

    }

    private static void process(char[] chs, int level) {
        if (level == chs.length) {
            set.add(new String(chs));
        }
        for (int i = level; i < chs.length; i++) {
            swap(chs, i, level);
            process(chs, level + 1);
            swap(chs, i, level);
        }
    }

    private static void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}
