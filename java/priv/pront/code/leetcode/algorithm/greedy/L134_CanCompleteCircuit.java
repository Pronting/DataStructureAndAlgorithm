package priv.pront.code.leetcode.algorithm.greedy;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-16 15:37
 */
public class L134_CanCompleteCircuit {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        int sum = 0;
        for (int cur : gas) {
            gasSum += cur;
        }
        for (int cur : cost) {
            costSum += cur;
        }
        if (costSum > gasSum) {
            return -1;
        }
        int[] res = new int[cost.length];
        for (int i = 0; i < cost.length; i++) {
            res[i] = gas[i] - cost[i];
        }

        int times = 0;
        int i = 0;
        for (i = 0; i < res.length && times <= res.length; i++) {
            sum += res[i];
            if (sum < 0) {
                sum = 0;
                times = 0;
                continue;
            }
            times++;
            if (i == res.length - 1) {
                i = -1;
            }
            if (times == res.length && sum == 0) {
                return i + 1;
            }
        }
        return -1;
    }


    //    answer
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int sum = 0;
        int min = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += (gas[i] - cost[i]);
            min = Math.min(sum, min);
        }

        if (sum < 0) {
            return -1;
        }
        if (min >= 0) {
            return 0;
        }

        for (int i = gas.length - 1; i > 0; i--) {
            min += (gas[i] - cost[i]);
            if (min >= 0) return i;
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] cost = {3, 4, 5, 1, 2};
        int[] gas = {1, 2, 3, 4, 5};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
