package priv.pront.code.leetcode.binaryTree;

import priv.pront.code.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-01 20:45
 */
public class L226_InvertTree {

    public TreeNode invertTree(TreeNode root) {
        // 层次遍历--直接左右交换即可
        if (root == null) {
            return null;

        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode rightTree = node.right;
            node.right = node.left;
            node.left = rightTree;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}
