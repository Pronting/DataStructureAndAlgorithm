package priv.pront.code.leetcode.binaryTree;

import priv.pront.code.leetcode.utils.TreeNode;

public class L543_DiameterOfBinaryTree {

    int ans = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans - 1;
    }

    private int dfs(TreeNode node){
        if(node == null) return 0;
        int l = dfs(node.left);
        int r = dfs(node.right);
        ans = Math.max(ans, l + r + 1);
        return Math.max(l, r) + 1;
    }
}
