package priv.pront.code.algorithm.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description: 输入：
 * 正数数组costs
 * 正数数组profits
 * 正数k
 * 正数w
 * 含义：
 * costs[i]表示i号项目的花费
 * profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
 * k表示你只能串行的最多做k个项目
 * w表示你初始的资金
 * 说明：
 * 你每做完一个项目，马上获得的收益，可以支持你去做下一个项目。
 * 输出：
 * 你最后获得的最大钱数。
 * @Author: pront
 * @Time:2022-09-05 10:56
 */
public class IPO {

    public static class Node{
        public int p;
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Node> minConstQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
//        将所有的项目扔到被锁池中，花费组织的小根堆
        for (int i = 0; i < profits.length; i++) {
            minConstQ.add(new Node(profits[i], capital[i]));
        }
        for (int i = 0; i < k; i++) {
//            能力所及的项目全解锁
            while (!minConstQ.isEmpty() && minConstQ.peek().c <= w) {
                maxProfitQ.add(minConstQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return w;
            }
            w += maxProfitQ.poll().p;
        }
        return w;
    }

}
