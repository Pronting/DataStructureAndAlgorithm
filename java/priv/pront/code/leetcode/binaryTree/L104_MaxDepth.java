package priv.pront.code.leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-09 17:20
 */
public class L104_MaxDepth {

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

    // 使用BFS 查找 1ms
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int res = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            res++;
            for (int i = 0; i < queueSize; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return res;
    }
}
