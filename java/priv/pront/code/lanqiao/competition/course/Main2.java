package priv.pront.code.lanqiao.competition.course;

import java.util.HashMap;
import java.util.Map;

public class Main2 {

    public static Map<String, Boolean> SG = new HashMap<>();

    public static void main(String[] args) {
        String[] s = new String[]{"XOOOOOOO", "XXOOOOOO", "OXOOOOOO", "OXXOOOOO"};
        StringBuilder sb = new StringBuilder();
        int n = s.length;
        for (int i = 0; i < n; i++) {
            if (put(s[i])) {
                sb.append("L");
            } else {
                sb.append("V");
            }
        }
        System.out.println(sb);
    }

    public static boolean check(String s) {
        int count = 0;
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0; i < n && count <= 1; i++) {
            if (cs[i] == 'O') {
                count++;
            }
        }
        return count == 1;
    }

    public static boolean put(String s) {
        if (SG.containsKey(s)) {
            return SG.get(s);
        }
        if (check(s)) {
            SG.put(s, false);
            return false;
        }
        char[] cs = s.toCharArray();
        int n = cs.length;
        // 放一个
        for (int i = 0; i < n; i++) {
            if (cs[i] == 'O') {
                StringBuilder sb = new StringBuilder(s);
                sb.replace(i, i + 1, "X");
                // 可以转移为必败态 必为必胜
                if (!put(sb.toString())) {
                    SG.put(s, true);
                    return true;
                }
            }
        }
        // 放两个连续的
        for (int i = 0; i < n - 1; i++) {
            if (cs[i] == 'O' && cs[i + 1] == 'O' && i != 3) {
                StringBuilder sb = new StringBuilder(s);
                sb.replace(i, i + 2, "XX");
                if (!put(sb.toString())) {
                    SG.put(s, true);
                    return true;
                }
            }
        }
        // 不能转移到必败态，所以自己必败
        SG.put(s, false);
        return false;
    }
}
