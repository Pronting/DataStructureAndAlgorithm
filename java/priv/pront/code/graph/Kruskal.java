package priv.pront.code.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description: kruskal算法，生成图的最小权重，以边的角度出发
 * @Author: pront
 * @Time:2022-08-16 16:35
 */
public class Kruskal {

    public static class MySets {

        public  HashMap<Node, List<Node>> setMap;

        public MySets(List<Node> nodes) {
            List<Node>set;
            for (Node cur : nodes) {
                set = new ArrayList<>();
                set.add(cur);
                setMap.put(cur, set);
            }
        }

        public boolean isSameSet(Node from,Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        public void union(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);

            for (Node toNode : toSet) {
                fromSet.add(toNode);
                setMap.put(toNode, fromSet);
            }
        }
    }
}
