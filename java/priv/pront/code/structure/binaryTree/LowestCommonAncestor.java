package priv.pront.code.structure.binaryTree;

import  java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * @Description: 两个节点的最低公共祖先
 * @Author: pront
 * @Time:2022-08-15 19:48
 */
public class LowestCommonAncestor {

    public static Node lca(Node head, Node o1, Node o2) {
        HashMap<Node, Node> fatherMap = new HashMap<>();
        fatherMap.put(head, head);
        process(head, fatherMap);
        HashSet<Node> set1 = new HashSet<>();
        Node cur = o1;
        while (cur != fatherMap.get(cur)) {
//            不是head节点
            set1.add(cur);
            cur = fatherMap.get(cur);
        }
        set1.add(head);
        cur = o2;
        while (cur != fatherMap.get(cur)) {
            cur = fatherMap.get(cur);
            for (Node setValue : set1) {
                if (cur.equals(setValue)) {
                    return cur;
                }
            }
        }
        return null;
    }

    public static Node lowestAncestor(Node head, Node o1, Node o2) {
        if (head == null || head == o1 || head == o2) {
//            null:null||o1:o1||o2:o2
            return head;
        }
        Node left = lowestAncestor(head.left, o1, o2);
        Node right = lowestAncestor(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }
//        左右两棵树，并不都有返回值
        return left != null ? left : right;
    }

    public static void process(Node head, HashMap<Node, Node> fatherMap) {
        if (head == null) {
            return;
        }
        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);
        process(head.left, fatherMap);
        process(head.right, fatherMap);
    }

    public static class Node {
        private Node left;
        private Node right;
        public int value;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return value == node.value && Objects.equals(left, node.left) && Objects.equals(right, node.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right, value);
        }



        public Node(int value) {
            this.value = value;
        }
    }
}
