package priv.pront.code.leetcode.algorithm.dfs;

import priv.pront.code.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-08 14:43
 */
public class L129_TreeNodeSumNumbers {

//    回溯 1ms
    public int sumNumbers(TreeNode root) {
        List<String> paths = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        traverse(root, sb, paths);
        int sum = 0;
        for (String path : paths) {
            sum += Integer.parseInt(path);
        }
        return sum;
    }

    private void traverse(TreeNode node, StringBuilder sb, List<String> paths) {
        if (node == null) {
            return;
        }
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            paths.add(sb.toString());
        } else {
            traverse(node.left, sb, paths);
            traverse(node.right, sb, paths);
        }
        sb.deleteCharAt(sb.length() - 1);
    }

//      dfs
    public int sumNumbers2(TreeNode root) {
        if(root.left==null && root.right == null) return root.val;
        int left = 0, right = 0;
        if(root.left != null) {
            left = dfs(root.left, (root.val) * 10);
        }
        if(root.right != null) {
            right = dfs(root.right, (root.val) * 10);
        }
        return left + right;
    }

    public int dfs(TreeNode root, int sum) {
        if(root.left==null && root.right == null) return sum + root.val;
        int left = 0, right = 0;
        if(root.left != null) {
            left = dfs(root.left, (sum+root.val) * 10);
        }
        if(root.right != null) {
            right = dfs(root.right, (sum+root.val) * 10);
        }
        return left + right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(new L129_TreeNodeSumNumbers().sumNumbers(root));
    }
}
