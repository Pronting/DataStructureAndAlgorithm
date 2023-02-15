package priv.pront.code.leetcode.dp.rob;

import priv.pront.code.leetcode.utils.TreeNode;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-15 17:12
 */
public class L337_RobIII {


    public static class Info {
        public int laiMaxHappy;
        public int buMaxHappy;

        public Info(int lai, int bu) {
            laiMaxHappy = lai;
            buMaxHappy = bu;
        }
    }

    public static int rob(TreeNode root) {
        Info info = process(root);
        return Math.max(info.laiMaxHappy, info.buMaxHappy);

    }

    public static Info process(TreeNode x) {
        if (x.left == null && x.right == null) {
            return new Info(x.val, 0);
        }
        int lai = x.val;
        int bu = 0;
        if (x.left != null) {
            Info leftInfo = process(x.left);
            lai += leftInfo.buMaxHappy;
            bu += Math.max(leftInfo.laiMaxHappy, leftInfo.buMaxHappy);
        }
        if (x.right != null) {
            Info rightInfo = process(x.right);
            lai += rightInfo.buMaxHappy;
            bu += Math.max(rightInfo.laiMaxHappy, rightInfo.buMaxHappy);
        }
        return new Info(lai, bu);
    }


    public int rob2(TreeNode root) {
        int[] res = robAction1(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robAction1(TreeNode root) {
        int res[] = new int[2];
        if (root == null)
            return res;

        int[] left = robAction1(root.left);
        int[] right = robAction1(root.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        int rob = rob(root);
        System.out.println(rob);
    }
}
