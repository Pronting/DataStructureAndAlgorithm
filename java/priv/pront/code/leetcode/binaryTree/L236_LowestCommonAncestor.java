package priv.pront.code.leetcode.binaryTree;

import priv.pront.code.leetcode.utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-01 20:25
 */
public class L236_LowestCommonAncestor {

    //    高效简单
    public TreeNode lowestCommonAncestor2(TreeNode head, TreeNode o1, TreeNode o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        TreeNode left = lowestCommonAncestor2(head.left, o1, o2);
        TreeNode right = lowestCommonAncestor2(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }
//        左右两棵树，并不都有返回值
        return left != null ? left : right;

    }


    public static TreeNode lowestCommonAncestor(TreeNode head, TreeNode o1, TreeNode o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();
        fatherMap.put(head, head);
        process(head, fatherMap);
        HashSet<TreeNode> set1 = new HashSet<>();
        TreeNode cur = o1;
        while (cur != fatherMap.get(cur)) {
//            不是head节点
            set1.add(cur);
            cur = fatherMap.get(cur);
        }
        set1.add(head);
        cur = o2;
        while (cur != fatherMap.get(cur)) {
            cur = fatherMap.get(cur);
            for (TreeNode setValue : set1) {
                if (cur.equals(setValue)) {
                    return cur;
                }
            }
        }
        return null;
    }

    public static void process(TreeNode head, HashMap<TreeNode, TreeNode> fatherMap) {
        if (head == null) {
            return;
        }
        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);
        process(head.left, fatherMap);
        process(head.right, fatherMap);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        TreeNode o1 = new TreeNode(0);
        root.left = o1;
        root.left.left = new TreeNode(-2);
        root.left.right = new TreeNode(4);
        TreeNode o2 = new TreeNode(8);
        root.left.left.left = o2;

        root.right = new TreeNode(3);
        System.out.println(lowestCommonAncestor(root, o1, o2).val);

    }
}
