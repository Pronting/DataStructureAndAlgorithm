package priv.pront.code.leetcode.competition;

import priv.pront.code.leetcode.utils.TreeNode;

import java.util.*;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-05 10:51
 */
public class L6308_KthLargestLevelSum {

    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Long> list = new ArrayList<>();
        queue.add(root);
        long curLevelSum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            curLevelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                curLevelSum += cur.val;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            list.add(curLevelSum);
        }

        Collections.sort(list);
        if (k > list.size()) {
            return -1;
        } else {
            return list.get(list.size() - k);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(9);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(3);


        System.out.println(new L6308_KthLargestLevelSum().kthLargestLevelSum(root, 2));
    }
}
