package priv.pront.code.od;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
 * 一个有N个选手参加比赛，选手编号为1~N（3<=N<=100），有M（3<=M<=10）个评委对选手进行打分。
 *
 * 打分规则为每个评委对选手打分，最高分10分，最低分1分。
 *
 * 请计算得分最多的3位选手的编号。 如果得分相同，则得分高分值最多的选手排名靠前
 *
 * (10分数量相同，则比较9分的数量，以此类推，用例中不会出现多个选手得分完全相同的情况)。
 *
 * 输入描述
 * 第一行为半角逗号分割的两个正整数，第一个数字表示M（3<=M<=10）个评委，第二个数字表示N（3<=N<=100）个选手。
 *
 * 第2到M+1行是半角逗号分割的整数序列，表示评委为每个选手的打分，0号下标数字表示1号选手分数，1号下标数字表示2号选手分数，依次类推。
 *
 * 输出描述
 * 选手前3名的编号。
 *
 * 注：若输入异常，输出-1，如M、N、打分不在范围内。
 */
public class E2024_MN_Score {

    static class Player {
        int id;
        int[] cnt = new int[11]; // 1~10分

        public Player(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] first = sc.nextLine().split(",");
        int m = Integer.parseInt(first[0]);
        int n = Integer.parseInt(first[1]);

        if (m < 3 || m > 10 || n < 3 || n > 100) {
            System.out.println(-1);
            return;
        }

        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            players[i] = new Player(i + 1);
        }

        for (int i = 0; i < m; i++) {
            String[] scores = sc.nextLine().split(",");
            if (scores.length != n) {
                System.out.println(-1);
                return;
            }

            for (int j = 0; j < n; j++) {
                int score = Integer.parseInt(scores[j]);
                if (score < 1 || score > 10) {
                    System.out.println(-1);
                    return;
                }
                players[j].cnt[score]++;
            }
        }

        Arrays.sort(players, (a, b) -> {
            for (int i = 10; i >= 1; i--) {
                if (a.cnt[i] != b.cnt[i]) {
                    return b.cnt[i] - a.cnt[i]; // 多的排前
                }
            }
            return a.id - b.id;
        });

        System.out.println(players[0].id + "," +
                players[1].id + "," +
                players[2].id);
    }
}
