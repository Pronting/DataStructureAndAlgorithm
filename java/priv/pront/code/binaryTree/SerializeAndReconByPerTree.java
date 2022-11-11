package priv.pront.code.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 二叉树的序列化和反序列化
 * @Author: pront
 * @Time:2022-08-16 09:06
 */
public class SerializeAndReconByPerTree {

    public static String serialByPer(Node head) {
        if (head == null) {
            return "#_";
        }
        String res = head.value + "_";
        res += serialByPer(head.left);
        res += serialByPer(head.right);
        return res;
    }

    public static Node reconByPerString(String perStr) {
        String[] values = perStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.add(values[i]);
        }
        return reconPerOrder(queue);
    }

    public static Node reconPerOrder(Queue<String> queue) {
        String value = queue.poll();
        if ("#".equals(value)) {
            return null;
        }
        Node head = new Node(Integer.parseInt(value));
        head.left = reconPerOrder(queue);
        head.right = reconPerOrder(queue);
        return head;
    }


    public static class Node {
        public final int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
