package priv.pront.code.structure.graph;



import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description: 图
 * @Author: pront
 * @Time:2022-08-16 10:02
 */
public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }


}
