package priv.pront.code.lanqiao.competition.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-25 13:34
 */
public class 网络寻路2 {

    static int sum = 0;
    static int start = 0;
    static boolean[] visited;
    static List<List<Integer>>list =new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        visited = new boolean[n + 1];
        if(m <= 1){
            System.out.println(0);
            return;
        }
//        邻接表法
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            list.get(from - 1).add(to);
            list.get(to - 1).add(from);
        }
        for (int i = 0; i < list.size(); i++) {
            visited[i + 1] = true;
            start = i + 1;
            dfs(1, list.get(i));
            visited[i + 1] = false;
        }
        System.out.println(sum);
    }

    private static void dfs(int forwardNum, List<Integer> node) {
        if (forwardNum == 3) {
            for (int vertex : node) {
                if (!visited[vertex] || vertex == start) {
                    sum++;
                }
            }
            return;
        }
        for (int vertex : node) {
            if (visited[vertex]) {
                continue;
            }
            List<Integer> next = list.get(vertex - 1);
            visited[vertex] = true;
            dfs(forwardNum + 1, next);
            visited[vertex] = false;
        }
    }
}
