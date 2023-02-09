package priv.pront.code.lanqiao.LG.P.bt;

import java.util.*;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-09 17:57
 */
public class P8681_CBTWeight {

    public static class CBTWeightInfo{
        public int level;
        public int sum;

        public CBTWeightInfo(int level, int sum) {
            this.level = level;
            this.sum = sum;
        }
    }

    public static  class CBTWeightComparator implements Comparator<CBTWeightInfo>{

        @Override
        public int compare(CBTWeightInfo o1, CBTWeightInfo o2) {
            return o1.sum == o2.sum ? o1.level - o2.level : o2.sum - o1.sum;
        }
    }

    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nodesWeight = new int[n];
        for (int i = 0; i < n; i++) {
            nodesWeight[i] = scanner.nextInt();
        }
        TreeNode root = generateCBT(nodesWeight, 0);
        int i = 1;
        getMinDepth(root);
    }

    private static TreeNode generateCBT(int[] nodesWeight, int index) {
        TreeNode tn = null;
        if (index < nodesWeight.length) {
            Integer value = nodesWeight[index];
            if (value == null) {
                return null;
            }
            tn = new TreeNode(value);
            tn.left = generateCBT(nodesWeight, 2 * index + 1);
            tn.right = generateCBT(nodesWeight, 2 * index + 2);
            return tn;
        }
        return tn;
    }

    private static void getMinDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        PriorityQueue<CBTWeightInfo> priorityQue = new PriorityQueue(new CBTWeightComparator());
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            level++;
            int sum = 0;
            for (int i = 0; i < queueSize; i++) {
                TreeNode cur = queue.poll();
                sum += cur.value;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            priorityQue.add(new CBTWeightInfo(level, sum));
        }
        CBTWeightInfo info = priorityQue.poll();
        System.out.println(info.level);
    }
}
