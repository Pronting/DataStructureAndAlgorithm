package priv.pront.code.leetcode.binaryTree;

import priv.pront.code.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-27 14:38
 */
public class L98_IsValidBST {


    static List<Integer> list = new ArrayList<>();

    public static boolean isValidBST3(TreeNode root) {
        if(root.left == null && root.right == null){
            return true;
        }
        traverse(root);
        List<Integer> preList = new ArrayList<>();
        for(int cur : list){
            preList.add(cur);
        }
        Collections.sort(list);
        for(int i = 1; i < list.size(); i++){
            if((list.get(i - 1) >= list.get(i)) && list.get(i) != preList.get(i)){
                return false;
            }
        }
        return true;
    }

    public static void traverse(TreeNode curNode){
        if(curNode == null){
            return;
        }
        traverse(curNode.left);
        list.add(curNode.val);
        traverse(curNode.right);
    }

    public static class TreeNodeInfo {
        boolean isValid;
        int minValue;
        int maxValue;

        public TreeNodeInfo(boolean isValid, int minValue, int maxValue) {
            this.isValid = isValid;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return isValid(root).isValid;
    }

    public static TreeNodeInfo isValid(TreeNode curNode) {
        if (curNode.left == null && curNode.right == null) {
            return new TreeNodeInfo(true, curNode.val, curNode.val);
        }
        int minValue = curNode.left == null ? curNode.val : isValid(curNode.left).minValue;
        int maxValue = curNode.right == null ? curNode.val : isValid(curNode.right).maxValue;
        if ((curNode.left != null && !isValid(curNode.left).isValid) ||
                (curNode.right != null && !isValid(curNode.right).isValid) ||
                (curNode.left != null && isValid(curNode.left).maxValue >= curNode.val) ||
                (curNode.right != null && isValid(curNode.right).minValue <= curNode.val)) {
            return new TreeNodeInfo(false, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        return new TreeNodeInfo(true, minValue, maxValue);
    }

    public static  boolean isValidBST2(TreeNode root) {
        return isValid(root, null, null);
    }

    private static boolean isValid(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(-1);
//        root1.right = new TreeNode(2);

        System.out.println(isValidBST3(root));
    }

}
