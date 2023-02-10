package priv.pront.code.leetcode.binaryTree;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-10 11:57
 */
public class L110_IsBalansed {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftLevel = getLevel(root.left);
        int rightLevel = getLevel(root.right);
        if (Math.abs(leftLevel - rightLevel) <= 1) {
            return true;
        } else {
            return false;
        }

    }

    public int getLevel(TreeNode root) {
        int res = 0;
        TreeNode pre = root;
        while (pre != null) {
            res++;
            pre = pre.left;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);


    }
}
