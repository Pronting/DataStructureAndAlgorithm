package priv.pront.code.dp.recursion;

/**
 * @Description: 二叉树的最大路径
 * @Author: pront
 * @Time:2022-12-01 19:01
 */
public class MaxSumInTree {

    public static class Node {
        public Node left;
        public Node right;
        public Integer value;

        public Node(Integer value) {
            this.value = value;
        }
    }

    public static int maxSum = Integer.MIN_VALUE;

    private static void maxPath(Node head) {
        if (head == null) {
            return;
        }
        process(head, 0);
    }

    private static void process(Node x, int pre) {
        if (x.left == null && x.right == null) {
//            当前节点是叶节点
            maxSum = Math.max(maxSum, pre + x.value);
        }
        if (x.left != null) {
            process(x.left, pre + x.value);
        }
        if (x.right != null) {
            process(x.right, pre + x.value);
        }
    }

//    以head为头的树最大路径是多少？
    private static int maxDits(Node head) {
        if (head.left != null && head.right != null) {
            maxSum = head.value;
        }
        int next = Integer.MIN_VALUE;

        if (head.left != null) {
            next = maxDits(head.left);
        }
        if (head.right != null) {
            next = Math.max(next, maxDits(head.right));
        }
        return head.value + next;
    }
}
