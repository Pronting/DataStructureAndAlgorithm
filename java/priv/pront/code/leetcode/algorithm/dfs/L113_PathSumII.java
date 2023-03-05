package priv.pront.code.leetcode.algorithm.dfs;

import priv.pront.code.leetcode.utils.TreeNode;
import priv.pront.utils.BinaryTreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-03 18:26
 */
public class L113_PathSumII {

    List<Integer> path = new ArrayList<>();
    List<List<Integer>>res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return new ArrayList<>();
        }
        backtracking(root,targetSum,root.val);
        return res;

    }

    public void backtracking(TreeNode root,int targetSum,int sum){
        path.add(root.val);

        if(sum == targetSum && root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
            return;
        }
        if(root.left != null){
            backtracking(root.left,targetSum,sum + root.left.val);
            path.remove(path.size() - 1);
        }
        if(root.right != null){
            backtracking(root.right,targetSum, sum + root.right.val);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.right = new TreeNode(1);
        treeNode.right.right.left = new TreeNode(5);

        TreeNode node = new TreeNode(-2);
        node.right = new TreeNode(-3);
        List<List<Integer>> lists = new L113_PathSumII().pathSum(treeNode, 22);
        System.out.println(lists);
    }
}
