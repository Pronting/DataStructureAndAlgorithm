package priv.pront.code.graph;

import java.util.*;

/**
 * @Description: 拓扑排序(基于有向图和无环基础上的排序算法)
 * @Author: pront
 * @Time:2022-08-16 16:10
 */
public class TopologySort {
    /**
     * directed graph and no loop
     *
     * @param graph 图
     * @return
     */
    public static List<Node> sortedTopology(Graph graph) {
//        key:某一个Node;value:剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();
//        入度为0的点，才能进队列
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
//        拓扑排序的结果依次加入result
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
