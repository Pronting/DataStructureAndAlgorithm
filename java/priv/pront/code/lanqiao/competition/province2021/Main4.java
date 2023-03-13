package priv.pront.code.lanqiao.competition.province2021;

import java.util.*;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-13 16:36
 */
//dfs
public class Main4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>(); // k:父节点 v:子节点
        for (int i = 2; i <= N; i++) {
            int x = scan.nextInt();
            map.putIfAbsent(x, new ArrayList<>());
            map.get(x).add(i);
        }
        int ans = dfs(1, map);
        System.out.println(ans);
    }

    private static int dfs(int i, Map<Integer, List<Integer>> map) {
        if (!map.containsKey(i)) {
            return 0; // 递归终止条件，当该节点没有子节点，高度为0
        }

        List<Integer> children = map.get(i);
        int size = children.size();
        int max = 0; // 子节点的最大高度
        for (Integer child : children) {
            max = Math.max(dfs(child, map), max);
        }
        return size + max;
    }
}
