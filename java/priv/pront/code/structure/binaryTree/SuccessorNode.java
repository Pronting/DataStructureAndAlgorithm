package priv.pront.code.structure.binaryTree;

/**
 * @Description: 给定一个父指针，优化后继节点的求解
 * @Author: pront
 * @Time:2022-08-15 20:54
 */
public class SuccessorNode {


    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        }else{
//            无右树
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
//                当前节点是父节点的右子节点
                node = parent;
                parent = node.parent;
            }
        return parent;
        }
    }

    public static Node getLeftMost(Node node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static class Node {
        private Node left;
        private Node right;
        private Node parent;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
