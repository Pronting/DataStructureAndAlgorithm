package priv.pront.code.lanqiao.competition.course;

import java.util.*;

public class 环境治理 {
//    城市的个数、每个城市的指标
    static int n,Q;
    static List<List<Integer>> node = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        Q = scanner.nextInt();
//        初始化邻接表
        for (int i = 0; i < node.size(); i++) {
            node.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int weight = scanner.nextInt();
                if (i == j) {
                    continue;
                }
//                无向图
                node.get(i).add(j);
                node.get(j).add(i);



            }
        }




    }
}
