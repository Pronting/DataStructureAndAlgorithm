package priv.pront.code.leetcode.algorithm.backtrack;

import priv.pront.code.leetcode.utils.TreeNode;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-10 18:21
 */
public class L437_PathSumIII {

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

    public static void main(String[] args) {
//        [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]
//0
        TreeNode root = new TreeNode(1000000000);
        root.left = new TreeNode(1000000000);
        root.left.left = new TreeNode(294967296);
        root.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left.left = new TreeNode(1000000000);

        System.out.println(new L437_PathSumIII().pathSum(root, 0));
    }
}
