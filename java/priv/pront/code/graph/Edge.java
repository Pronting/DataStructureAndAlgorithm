package priv.pront.code.graph;

/**
 * @Description: 边
 * @Author: pront
 * @Time:2022-08-16 10:14
 */
public class Edge {

    /**
     * 距离，权值多重
     */
    public int weight;

    /**
     * 基于有向边
     */
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
