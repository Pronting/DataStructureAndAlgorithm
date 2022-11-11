package priv.pront.code.lanqiao;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Description: ..
 * @Author: pront
 * @Time:2022-10-18 16:13
 */
public class Xiaoming {

    public static class TreeNode{
        Set<TreeNode> nexts;

        public TreeNode(){
            nexts = new HashSet<>();
        }
    }

    private static int xiaoming(int n) {
        if (n == 0) {
            return 0;
        }
        TreeNode treeNode = new TreeNode();
        Set<TreeNode> selectedNode = new HashSet<>();
        selectedNode.add(treeNode);
        int[][] matrix = init(n);

        TreeNode index = treeNode;
        TreeNode cur;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n && matrix[i][j + 1] == 0) {
                    cur = new TreeNode();
                    index.nexts.add(cur);
                    index = cur;
                }

                if (j - 1 > 0 && matrix[i][j - 1] == 0) {
                    cur = new TreeNode();
                    index.nexts.add(cur);
                    index = cur;
                }
            }
        }
        return DFS(treeNode);
    }

    private static int[][] init(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = (int) (Math.random() * 2);
        }
        matrix[0][0] = 1;
        matrix[n - 1][n - 1] = 3;
        return matrix;
    }

    private static boolean unSelected(Set<TreeNode> selectedSet,TreeNode cur) {
        if (selectedSet == null) {
            return true;
        }
        for (TreeNode curNode : selectedSet) {
            if (cur == curNode) {
                return false;
            }
        }
        return true;
    }


    private static int DFS(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> set = new HashSet<>();
        stack.add(treeNode);
        set.add(treeNode);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            for (TreeNode next : cur.nexts) {
                stack.push(cur);
                stack.push(next);
                set.add(next);
//                这个位置进行处理
                break;
            }
        }
        return 0;
    }
}
