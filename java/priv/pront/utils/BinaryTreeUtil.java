package priv.pront.utils;

import priv.pront.code.leetcode.utils.TreeNode;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-03 18:33
 */
public class BinaryTreeUtil {

    public static TreeNode buildTree(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTreeHelper(nums, 0);
    }

    public static TreeNode buildTreeHelper(Integer[] nums, int index) {
        if (index >= nums.length || nums[index] == null) {
            return null;
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = buildTreeHelper(nums, 2 * index + 1);
        root.right = buildTreeHelper(nums, 2 * index + 2);
        return root;
    }
}
