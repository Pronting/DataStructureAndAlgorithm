package priv.pront.code.leetcode.algorithm.dfs;

import java.util.*;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-04 13:51
 */
public class L210_CoursesII {

//    不完善，已过 39/45
    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> nextMap = new HashMap<>();
        Map<Integer, Integer> nextNumMap = new HashMap<>();

        // 只有next数组长度位0的点，才能进入队列
        Queue<Integer> zeroInQueue = new LinkedList<>();


        for (int[] cur : prerequisites) {
            if (!nextMap.containsKey(cur[0])) {

                for (Map.Entry<Integer, List<Integer>> val : nextMap.entrySet()) {
                    List<Integer> value = val.getValue();
                    if (cur[1] == val.getKey() && value.contains(cur[0])) {
                        return new int[]{};
                    }
                }

                List<Integer> list = new ArrayList<>();
                list.add(cur[1]);
                nextMap.put(cur[0], list);
                nextNumMap.put(cur[0], 1);
            } else {
                List<Integer> list = nextMap.get(cur[0]);
                list.add(cur[1]);
                nextMap.put(cur[0], list);
                nextNumMap.put(cur[0], nextNumMap.get(cur[0]) + 1);
            }
        }

        for (int i = 0; i < numCourses; i++) {
//            被依赖的点
            if (!nextMap.containsKey(i)) {
                zeroInQueue.add(i);
            }
        }

        // 拓扑排序的结果依次放入result
        int[] result = new int[numCourses];
        int index = 0;
        while (!zeroInQueue.isEmpty() && index < numCourses) {
            int cur = zeroInQueue.poll();
            result[index++] = cur;
            for (Map.Entry<Integer, List<Integer>> val : nextMap.entrySet()) {
                if (val.getValue().contains(cur)) {
                    nextNumMap.put(val.getKey(), nextNumMap.get(val.getKey()) - 1);
                }
                if (nextNumMap.get(val.getKey()) == 0) {
                    zeroInQueue.add(val.getKey());
                }
            }
            for(Map.Entry<Integer,Integer> val : nextNumMap.entrySet()){
                if(val.getValue() == 0){
                    nextMap.remove(val.getKey());
                }
            }
        }
        return result;
    }

//      构建有向图，方法正确
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];

        // 构建有向图
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            inDegree[to]++;
        }

        // 拓扑排序
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int from = queue.poll();
            result[index++] = from;
            if (graph.containsKey(from)) {
                for (int to : graph.get(from)) {
                    inDegree[to]--;
                    if (inDegree[to] == 0) {
                        queue.offer(to);
                    }
                }
            }
        }

        // 判断是否存在环路
        if (index != numCourses) {
            return new int[0];
        }

        return result;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, boolean[] visited, boolean[] onStack, int from) {
        visited[from] = true;
        onStack[from] = true;
        if (graph.containsKey(from)) {
            for (int to : graph.get(from)) {
                if (!visited[to]) {
                    if (hasCycle(graph, visited, onStack, to)) {
                        return true;
                    }
                } else if (onStack[to]) {
                    return true;
                }
            }
        }
        onStack[from] = false;
        return false;
    }


    public static void main(String[] args) {
        int[][] arr = {{1,0},{1,2},{0,1}};
        for (int i : findOrder(3, arr)) {
            System.out.println(i);
        }
    }
}
