package priv.pront.code.leetcode.utils;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-06 17:56
 */
public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
}
