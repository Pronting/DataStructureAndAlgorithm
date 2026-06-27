package priv.pront.code.od;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class E2024_德州扑克 {

    static class Puke {
        int score;
        char color;

        public Puke(int score, char color) {
            this.score = score;
            this.color = color;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Puke> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String[] s = sc.nextLine().split(" ");
            list.add(new Puke(getScore(s[0]), s[1].charAt(0)));
        }

        list.sort(new Comparator<Puke>() {
            @Override
            public int compare(Puke o1, Puke o2) {
                return o1.score - o2.score;
            }
        });

        if (huase(list) && shunzi(list)) {
            System.out.println(1);
        } else if (sitiao(list)) {
            System.out.println(2);
        } else if (hulu(list)) {
            System.out.println(3);
        } else if (huase(list)) {
            System.out.println(4);
        } else if (shunzi(list)) {
            System.out.println(5);
        } else {
            System.out.println(6);
        }
    }

    public static int getScore(String s) {
        switch (s) {
            case "A":
                return 14;
            case "K":
                return 13;
            case "Q":
                return 12;
            case "J":
                return 11;
            default:
                return Integer.parseInt(s);
        }
    }

    public static boolean huase(List<Puke> list) {
        char c = list.get(0).color;
        for (Puke cur : list) {
            if (cur.color != c) {
                return false;
            }
        }
        return true;
    }

    public static boolean shunzi(List<Puke> list) {

        // 普通顺子
        boolean ok = true;
        for (int i = 1; i < 5; i++) {
            if (list.get(i).score != list.get(i - 1).score + 1) {
                ok = false;
                break;
            }
        }
        if (ok) {
            return true;
        }

        // A2345
        return list.get(0).score == 2
                && list.get(1).score == 3
                && list.get(2).score == 4
                && list.get(3).score == 5
                && list.get(4).score == 14;
    }

    public static boolean sitiao(List<Puke> list) {
        return list.get(0).score == list.get(3).score
                || list.get(1).score == list.get(4).score;
    }

    public static boolean hulu(List<Puke> list) {
        return (list.get(0).score == list.get(2).score
                && list.get(3).score == list.get(4).score)
                || (list.get(0).score == list.get(1).score
                && list.get(2).score == list.get(4).score);
    }

}
