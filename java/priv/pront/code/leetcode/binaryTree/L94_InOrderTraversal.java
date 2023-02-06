package priv.pront.code.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-06 16:05
 */
public class L94_InOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return process(root,list);
    }

    public List<Integer> process(TreeNode node,List<Integer> list){
        if (node == null) {
            return null;
        }
        process(node.left,list);
        list.add(node.val);
        process(node.right,list);
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
