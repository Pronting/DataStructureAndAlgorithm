package priv.pront.code.leetcode.binaryTree;

import priv.pront.code.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L530_GetMinimumDifference {

    List<Integer> list = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i++){
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }

    private void dfs(TreeNode root){
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }


    public static void main(String[] args) {
        L530_GetMinimumDifference getMinimumDifference = new L530_GetMinimumDifference();
        TreeNode testTreeNode = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
        System.out.println(getMinimumDifference.getMinimumDifference(testTreeNode));
    }
}
