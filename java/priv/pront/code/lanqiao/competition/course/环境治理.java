package priv.pront.code.lanqiao.competition.course;

import java.util.*;

public class 环境治理 {

    public static class Graph {
        public HashMap<Integer, Node> nodes;
        public HashSet<Edge> edges;

        public Graph() {
            this.nodes = new HashMap<>();
            this.edges = new HashSet<>();
        }
    }

    public static class Edge {
        public int weight;
        public Node from;
        public Node to;
        public int xiaxian;

        public Edge(int weight, Node from, Node to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }

    public static class Node {
        public int val;
        public List<Node> next;
        public List<Edge> edges;

        public Node(int val) {
            this.val = val;
            this.next = new ArrayList<>();
            this.edges = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();
        HashSet<Edge> edges = graph.edges;
        HashMap<Integer, Node> nodes = graph.nodes;
        int n = scanner.nextInt(); // 节点的个数
        int Q = scanner.nextInt(); // 预期达到的P指标
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                Node a = new Node(i);
                Node b = new Node(j);
//                无向图
                a.next.add(b);
                b.next.add(a);
                Edge edge = new Edge(scanner.nextInt(), a, b);
                edges.add(edge);
                a.edges.add(edge);
                b.edges.add(edge);
                nodes.put(i, a);
                nodes.put(j, b);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
//                通过图的点集序号查找Node节点
                Node a = nodes.get(i);
                Node b = nodes.get(j);
                Edge g = null;
                for (Edge edge : a.edges) {
                    if (b.edges.contains(edge)) {
                        g = edge;
                        break;
                    }
                }
                g.xiaxian = scanner.nextInt();

            }
        }
    }
}
