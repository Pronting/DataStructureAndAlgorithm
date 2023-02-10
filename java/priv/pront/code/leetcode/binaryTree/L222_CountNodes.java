package priv.pront.code.leetcode.binaryTree;

import java.util.*;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-10 11:13
 */
public class L222_CountNodes {

    public static class TreeNode {
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

//    !层序遍历解法 7ms
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        while(!queue.isEmpty()){
            level++;
            int queueSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < queueSize;i++){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            map.put(1,list);
        }

        return(int)(Math.pow(2,level))  -1 + map.get(1).size();

    }


//    !完全二叉树的性质求解 0ms
    public static int countNodes2(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftLevel = getLevel(root.left);
        int rightLevel = getLevel(root.right);
        if(leftLevel == rightLevel){
            return countNodes2(root.right) + (1 << leftLevel);
        }else{
            return countNodes2(root.left) + (1 << rightLevel);
        }
    }

    public static int getLevel(TreeNode root){
        int res = 0;
        TreeNode pre = root;
        while(pre != null){
            res++;
            pre = pre.left;
        }
        return res;
    }


//    FIXME 二分查找 + 位运算
    public int countNodes3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}

