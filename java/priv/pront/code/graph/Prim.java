package priv.pront.code.graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Description: prim算法, 从点的方向去解决
 * @Author: pront
 * @Time:2022-08-16 16:42
 */
public class Prim {
    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> primMST(Graph graph) {
//        解锁的边进入小跟堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        HashSet<Node> set = new HashSet<>();
//        依次挑选的边放在result里
        Set<Edge> result = new HashSet<>();
//        为了处理森林的问题
        for (Node node : graph.nodes.values()) {
//            随便挑选一个点
//            node是开始点
            if (!set.contains(node)) {
                set.add(node);
                for (Edge edge : node.edges) {
//                    由一个点解锁所有相连的边
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()) {
//                    弹出解锁的边中，最小的边
                    Edge edge = priorityQueue.poll();
//                    可能的一个新的点
                    Node toNode = edge.to;
                    if (!set.contains(toNode)) {
//                        不含有的时候，就是新的点
                        set.add(toNode);
                        result.add(edge);
                        for (Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
//        重复的边集合，但是不影响结果，会直接跳过，如果向优化常数时间，可以设置一个边的集合，对边进行去重操作
        return result;
    }
}
