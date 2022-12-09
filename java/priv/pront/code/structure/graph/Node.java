package priv.pront.code.structure.graph;

import java.util.ArrayList;

/**
 * @Description: 点集
 * @Author: pront
 * @Time:2022-08-16 10:05
 */
public class Node {

    public int value;

    /**
     * 点的入度
     */
    public int in;

    /**
     * 点的出度
     */
    public int out;

    /**
     * 由这个点发散出去的直接邻居
     */
    public ArrayList<Node> nexts;

    /**
     * 属于这个点的边
     */
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
