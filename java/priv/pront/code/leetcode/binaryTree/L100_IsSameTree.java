package priv.pront.code.leetcode.binaryTree;

import priv.pront.code.leetcode.utils.TreeNode;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-06 18:19
 */
public class L100_IsSameTree {

    public static void main(String[] args) {

//        TreeNode p1 = new TreeNode(1);
//        TreeNode p2 = new TreeNode(1);
//        p1.left = new TreeNode(2);
//        p2.left = null;
//        p2.right = new TreeNode(2);
        System.out.println(isSameTree(null, null));

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if ((p != null && q == null) || (p == null && q != null) || p.val != q.val ) {
            return false;
        }

        boolean rleft = true;
        boolean rright = true;
        if (p.left != null && p.left != null) {
            rleft = isSameTree(p.left, q.left);
        } else if (p.left == null && q.left == null) {
            rleft = true;
        }
        if (p.right != null && q.right != null) {
            rright = isSameTree(p.right, q.right);
        } else if (p.right == null && q.right == null) {
            rright = true;
        }
        return rleft && rright;
    }
}


