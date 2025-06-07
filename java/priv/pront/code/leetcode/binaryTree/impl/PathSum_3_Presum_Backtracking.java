package priv.pront.code.leetcode.binaryTree.impl;

import priv.pront.code.leetcode.binaryTree.L437_PathSumI_3;
import priv.pront.code.leetcode.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum_3_Presum_Backtracking implements L437_PathSumI_3 {

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> preSums = new HashMap<>();
        preSums.put(0L, 1);
        return dfs(root, 0, preSums, targetSum);
    }
    public int dfs(TreeNode node, long curSum, Map<Long, Integer> preSums, int targetSum) {
        if (node == null) return 0;
        curSum += node.val;
        int ret = preSums.getOrDefault(curSum - targetSum, 0);
        preSums.put(curSum, preSums.getOrDefault(curSum, 0) + 1);
        ret += dfs(node.left, curSum, preSums, targetSum) + dfs(node.right, curSum, preSums, targetSum);
        preSums.put(curSum, preSums.getOrDefault(curSum, 0) - 1);
        return ret;
    }
}
