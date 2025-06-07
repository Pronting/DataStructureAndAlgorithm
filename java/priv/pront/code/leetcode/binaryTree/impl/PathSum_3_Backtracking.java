package priv.pront.code.leetcode.binaryTree.impl;

import priv.pront.code.leetcode.binaryTree.L437_PathSumI_3;
import priv.pront.code.leetcode.utils.TreeNode;

public class PathSum_3_Backtracking implements L437_PathSumI_3 {

    @Override
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        return backtracking(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int backtracking(TreeNode node, long targetSum){
        if(node == null){
            return 0;
        }
        int count = node.val == targetSum ? 1 : 0;
        count += backtracking(node.left, targetSum - node.val) + backtracking(node.right, targetSum - node.val);
        return count;
    }
}
