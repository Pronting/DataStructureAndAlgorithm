package priv.pront.code.od;

import java.util.*;

public class E2024_悄悄话 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] values = input.split(" ");
        int[] nums = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            nums[i] = Integer.parseInt(values[i]);
        }

        TreeNode root = buildTree(nums);
        int result = maxPathSum(root);
        System.out.println(result);

        scanner.close();
    }

    private static TreeNode buildTree(int[] nums) {
        if (nums == null || nums.length == 0 || nums[0] == -1) {
            return null;
        }

        // 使用List存储所有层的节点（包括null）
        List<TreeNode> nodeList = new ArrayList<>();
        for (int num : nums) {
            if (num != -1) {
                nodeList.add(new TreeNode(num));
            } else {
                nodeList.add(null);
            }
        }

        // 为每个非空节点建立父子关系
        for (int i = 0; i < nodeList.size(); i++) {
            TreeNode node = nodeList.get(i);
            if (node != null) {
                int leftIdx = 2 * i + 1;
                int rightIdx = 2 * i + 2;

                if (leftIdx < nodeList.size()) {
                    node.left = nodeList.get(leftIdx);
                }
                if (rightIdx < nodeList.size()) {
                    node.right = nodeList.get(rightIdx);
                }
            }
        }

        return nodeList.get(0);
    }

    private static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] maxSum = new int[1];
        dfs(root, 0, maxSum);
        return maxSum[0];
    }

    private static void dfs(TreeNode node, int currentSum, int[] maxSum) {
        if (node == null) {
            return;
        }

        currentSum += node.val;

        if (node.left == null && node.right == null) {
            maxSum[0] = Math.max(maxSum[0], currentSum);
            return;
        }

        dfs(node.left, currentSum, maxSum);
        dfs(node.right, currentSum, maxSum);
    }
}
