package priv.pront.code.algorithm.dp;

/**
 * @Description: 给定节点数量的二叉树有几种排布方式
 * @Author: pront
 * @Time:2022-11-22 17:42
 */
public class UniqueBST {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    public static int process(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int res = 0;
        for (int leftNum = 0; leftNum <= n - 1; leftNum++) {
            int leftWays = process(leftNum);
            int rightWays = process(n - 1 - leftNum);
            res += leftWays * rightWays;
        }
        return res;
    }

// FIXME 方法有问题
    public static int numTree(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
//        节点个数为i的时候
        for (int i = 1; i < n + 1; i++) {
//            左侧节点个数为j-1 ,右侧节点个数为i-j
            for (int j = 0; j <= i - 1; j++) {
//                左侧节点个数j 右侧为i -j -1
                dp[i] = dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int process = process(3);
        System.out.println(numTree(3));
        System.out.println(process);
    }
}
