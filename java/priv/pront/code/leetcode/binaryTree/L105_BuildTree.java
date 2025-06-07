package priv.pront.code.leetcode.binaryTree;

import priv.pront.code.leetcode.utils.TreeNode;

import java.util.*;

public class L105_BuildTree {

    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(inorder[i], i);
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int prel, int prer, int inl, int inr){
        if(prel > prer) return null;
        int rootval = preorder[prel];
        int head = map.get(rootval);
        TreeNode root = new TreeNode(rootval);
        int left_sub = head - inl;
        root.left = build(preorder, inorder, prel + 1, prel + left_sub, inl, head - 1);
        root.right = build(preorder, inorder, prel + left_sub + 1, prer, head + 1, inr);
        return root;

    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        L105_BuildTree buildTree = new L105_BuildTree();
        TreeNode treeNode = buildTree.buildTree(preorder, inorder);
    }
}
