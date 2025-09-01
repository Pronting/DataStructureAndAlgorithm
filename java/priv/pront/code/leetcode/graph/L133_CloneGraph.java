package priv.pront.code.leetcode.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L133_CloneGraph {

    private HashMap<Node, Node> st = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) return node;
        if(st.containsKey(node)) return st.get(node);
        Node cloneNode = new Node(node.val, new ArrayList<>());
        st.put(node, cloneNode);
        for(Node cur: node.neighbors){
            cloneNode.neighbors.add(cloneGraph(cur));
        }
        return cloneNode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
