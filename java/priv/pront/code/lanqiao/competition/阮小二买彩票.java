package priv.pront.code.lanqiao.competition;

import java.util.*;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-22 09:47
 */
public class 阮小二买彩票 {

    static Set<String> set = new TreeSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.nextLine();
        char[] chs = N.toCharArray();
        process(chs, 0);
        for (String s : set) {
            System.out.println(s);
        }
    }

    private static void process(char[] chs, int index) {
        if (index == chs.length) {
            set.add(new String(chs));
            return;
        }

        for (int i = index; i < chs.length; i++) {
            swap(chs, index, i);
            process(chs, index + 1);
            swap(chs, index, i);
        }
    }

    private static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
