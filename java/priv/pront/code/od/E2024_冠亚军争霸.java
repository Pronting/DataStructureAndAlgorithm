package priv.pront.code.od;

import java.util.*;

/**
 * 题目描述
 * 有N（3 ≤ N < 10000）个运动员，他们的id为0到N-1,他们的实力由一组整数表示。他们之间进行比赛，需要决出冠亚军。比赛的规则是0号和1号比赛，2号和3号比赛，以此类推，每一轮，相邻的运动员进行比赛，获胜的进入下一轮；实力值大的获胜，实力值相等的情况，id小的情况下获胜；轮空的直接进入下一轮。
 *
 * 输入描述
 * 输入一行N个数字代表N的运动员的实力值(0<=实力值<=10000000000)。
 *
 * 输出描述
 * 输出冠亚季军的id，用空格隔开。
 *
 * 用例1
 * 输入
 * 2 3 4 5
 *
 *
 * 输出
 * 3 1 2
 */
public class E2024_冠亚军争霸 {
        // 运动员类
        static class Sport {
            int id;
            long strength;

            public Sport(int id, long strength) {
                this.id = id;
                this.strength = strength;
            }
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().trim().split(" ");
        long[] strength = new long[s.length];

        for (int i = 0; i < s.length; i++) {
            strength[i] = Long.parseLong(s[i]);
        }

        System.out.println(getResult(strength));
    }

    public static String getResult(long[] strength) {

        LinkedList<ArrayList<Sport>> ans = new LinkedList<>();

        ArrayList<Sport> sports = new ArrayList<>();
        for (int i = 0; i < strength.length; i++) {
            sports.add(new Sport(i, strength[i]));
        }

        // 第一轮晋级
        promote(sports, ans);

        // 一直打到冠军产生
        while (ans.getFirst().size() > 1) {
            promote(ans.removeFirst(), ans);
        }

        // ===== 冠军 =====
        int first = ans.get(0).get(0).id;

        // ===== 亚军 =====
        int second = ans.get(1).get(0).id;

        // ===== 季军 =====
        ArrayList<Sport> thirdList = ans.get(2);

        thirdList.sort((a, b) -> {
            if (a.strength != b.strength) {
                return Long.compare(b.strength, a.strength);
            }
            return Integer.compare(a.id, b.id);
        });

        int third = thirdList.get(0).id;

        return first + " " + second + " " + third;
    }

    public static void promote(ArrayList<Sport> sports, LinkedList<ArrayList<Sport>> ans) {

        ArrayList<Sport> win = new ArrayList<>();
        ArrayList<Sport> fail = new ArrayList<>();

        for (int i = 1; i < sports.size(); i += 2) {

            Sport major = sports.get(i);
            Sport minor = sports.get(i - 1);

            if (major.strength > minor.strength) {
                win.add(major);
                fail.add(minor);
            } else {
                win.add(minor);
                fail.add(major);
            }
        }

        // 奇数个，最后一个轮空
        if (sports.size() % 2 != 0) {
            win.add(sports.get(sports.size() - 1));
        }

        // 压入历史层（关键：fail在前，win在后）
        ans.addFirst(fail);
        ans.addFirst(win);

        // 只保留最近3层（冠亚季军相关）
        while (ans.size() > 3) {
            ans.removeLast();
        }
    }
}
