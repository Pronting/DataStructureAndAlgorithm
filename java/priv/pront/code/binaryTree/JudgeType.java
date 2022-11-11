package priv.pront.code.binaryTree;

import priv.pront.code.sort.compareSort.GetMax;

import java.util.*;

/**
 * @Description: 如何判断树的种类
 * @Author: pront
 * @Time:2022-08-14 11:41
 */
public class JudgeType {
    public static int perValue = Integer.MIN_VALUE;

    public static boolean checkBST(Node head) {
        if (head == null) {
            return true;
        }
        boolean isLeftBst = checkBST(head.left);
        if (!isLeftBst) {
            return false;
        }
        if (head.value <= perValue) {
            return false;
        } else {
            perValue = head.value;
        }
        return checkBST(head.right);
    }

    public static boolean checkBST2(Node head) {
        if (head == null) {
            return true;
        }
        List<Node> inOrderList = new ArrayList<>();
        process2(head, inOrderList);
//       对集合中的节点判断是否为升序
        for (int i = 1; i < inOrderList.size(); i++) {
            if (inOrderList.get(i).value < inOrderList.get(i - 1).value) {
                return false;
            }
        }
        return true;
    }

    public static void process2(Node head, List<Node> inOrderList) {
        if (head == null) {
            return;
        }
        process2(head.left, inOrderList);
        inOrderList.add(head);
        process2(head.right, inOrderList);

    }

    /**
     * 非递归方式
     *
     * @param head
     * @return
     */
    public static boolean checkBST3(Node head) {
        if (head != null) {
            int perValue = Integer.MIN_VALUE;
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    if (head.value <= perValue) {
                        return false;
                    } else {
                        perValue = head.value;
                    }
                    head = head.right;
                }
            }
        }
        return true;
    }

    public static boolean isRurBST(Node head) {
        return process3(head).isBST;
    }

    public static class ReturnData {
        public ReturnData(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }

        public boolean isBST;
        public int max;
        public int min;

    }

    public static ReturnData process3(Node x) {
        if (x == null) {
            return null;
        }
        ReturnData leftData = process3(x.left);
        ReturnData rightData = process3(x.right);

        boolean isBST = true;
        int min = x.value;
        int max = x.value;
        if (leftData != null) {
            min = Math.min(min, leftData.min);
        }
        if (rightData != null) {
            max = Math.max(max, rightData.max);
        }
        if (leftData != null && (!leftData.isBST || leftData.max >= x.value)) {
            isBST = false;
        }
        if (rightData != null && (!rightData.isBST || rightData.min <= x.value)) {
            isBST = false;
        }
        return new ReturnData(isBST, min, max);
    }

    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
//       leaf: 是否与遇到过左右两个孩子不双全的节点
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && !(l == null && r == null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }

    public static boolean isBalanced(Node head) {
        return process(head).isBalanced;
    }

    public static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    private static ReturnType process(Node x) {
        if (x == null) {
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);
//            子树+父节点(1)
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced, height);
    }

    public static boolean isF(Node head) {
        if (head == null) {
            return true;
        }
        Info data = process4(head);
//        判读是否为2^l-1

        return data.nodes == ((1 << data.height) - 1);
    }

    public static Info process4(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftData = process4(x.left);
        Info rightData = process4(x.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;

        return new Info(height, nodes);
    }

    public static class Info {
        public int height;
        public int nodes;

        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    public static class Node {
        private Node left;
        private Node right;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
