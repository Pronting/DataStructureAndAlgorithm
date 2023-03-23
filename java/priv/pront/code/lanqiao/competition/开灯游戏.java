package priv.pront.code.lanqiao.competition;

import java.util.*;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-22 14:22
 */
public class 开灯游戏 {
    static final int TARGET = 4;
    static Map<Integer, List<Integer>> beamMap = new HashMap<>();
    static Set<String> set = new TreeSet<>();

    public static void main(String[] args) {
     boolean[] beam = new boolean[9];
        StringBuilder sb = new StringBuilder();
        List<Integer> child = new ArrayList<>();
        child.add(2);
        child.add(4);
        beamMap.put(1, child);
        child = new ArrayList<>();
        child.add(1);
        child.add(3);
        child.add(5);
        beamMap.put(2, child);
        child = new ArrayList<>();
        child.add(2);
        child.add(6);
        beamMap.put(3, child);
        child = new ArrayList<>();
        child.add(1);
        child.add(5);
        child.add(7);
        beamMap.put(4, child);
        child = new ArrayList<>();
        child.add(2);
        child.add(4);
        child.add(6);
        child.add(8);
        beamMap.put(5, child);
        child = new ArrayList<>();
        child.add(3);
        child.add(5);
        child.add(9);
        beamMap.put(6, child);
        child = new ArrayList<>();
        child.add(4);
        child.add(8);
        beamMap.put(7, child);
        child = new ArrayList<>();
        child.add(5);
        child.add(7);
        child.add(9);
        beamMap.put(8, child);
        child = new ArrayList<>();
        child.add(6);
        child.add(8);
        beamMap.put(9, child);
        process(sb, 0, beam);
        for (String s : set) {
            System.out.println(s);
        }
    }

    private static void process(StringBuilder sb, int index, boolean[] beam) {
        if (index == 10) {
            check(sb,beam);
            return;
        }
//        打开就处理
        if (sb.length() != 0 && sb.charAt(sb.length() - 1) == '1') {
            int curLen = sb.length();
            List<Integer> list = beamMap.get(curLen);
            for (Integer integer : list) {
                beam[integer - 1] = !beam[integer - 1];
            }

        }
//        每一次选和不选两种状态
        process(sb.append("1"), index + 1, beam);
        sb.deleteCharAt(sb.length() - 1);
        process(sb.append("0"), index + 1, beam);
        sb.deleteCharAt(sb.length() - 1);

    }

    private static void check(StringBuilder sb,boolean[] beam) {
        int count = 0;
        for (boolean b : beam) {
            count = b ? count + 1 : count;
        }
        if (count == TARGET) {
            set.add(sb.toString());
        }
    }
}
