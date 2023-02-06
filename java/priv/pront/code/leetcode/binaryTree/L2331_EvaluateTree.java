package priv.pront.code.leetcode.binaryTree;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-06 17:38
 */
public class L2331_EvaluateTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
