package priv.pront.code.algorithm.dp;

import java.util.Arrays;

/**
 * @Description: 阿里面试题--动态规划
 * 给你几个参数：
 * N：代表总共有多少个位置。
 * m：机器人的出发位置。
 * k：机器人的目的地。
 * p：机器人必须走p步。
 * 问题：请你求出机器人从m起始位置走p步到达终止位置k，一共有多少种走法？注意，每次机器人必须走一步，不能留在原地，每次只能走一格，可以向右或者向左。
 * @Author: pront
 * @Time:2022-11-09 20:29
 */
public class RobotWalk {


    public static int way1(int n, int m, int k, int p) {
        if (n < 2 || k < 1 || m < 1 || m > n || p < 1) {
            return 0;
        }
        return walk(n, m, k, p);
    }

    /**
     * 只能在1~N这些位置上移动，当前在cur位置，走完rest步之后，停在P位置的方法数作为返回值返回
     *
     * @param n    位置为1 ~ N，固定参数
     * @param cur  当前在cur位置，可变参数
     * @param rest 还剩res步没有走，可变参数
     * @param p    最终目标位置是P，固定参数
     * @return
     */
    private static int walk(int n, int cur, int rest, int p) {
        if (rest == 0) {
            return cur == p ? 1 : 0;
        }
        if (cur == 1) {
            return walk(n, cur + 1, rest - 1, p);
        }
        if (cur == n) {
            return walk(n, cur - 1, rest - 1, p);
        }
        return walk(n, cur + 1, rest - 1, p) + walk(n, cur - 1, rest - 1, p);
    }


    public static int way2(int n, int m, int k, int p) {
        if (n < 2 || k < 1 || m < 1 || m > n || p < 1) {
            return 0;
        }
        int[][] dpCache = new int[k + 1][n + 1];
        initCache(dpCache);
        return walk2(n, m, k, p, dpCache);
    }

    private static void initCache(int[][] cache) {
        for (int[] ints : cache) {
            Arrays.fill(ints, -1);
        }
    }

    private static int walk2(int n, int cur, int rest, int p, int[][] dpCache) {
        if (dpCache[cur][rest] != -1) {
            return dpCache[cur][rest];
        }
//        缓存没命中
        if (rest == 0) {
            dpCache[cur][rest] = cur == p ? 1 : 0;
            return dpCache[cur][rest];
        }

        if (cur == 1) {
            dpCache[cur][rest] = walk2(n, cur + 1, rest - 1, p, dpCache);
            return dpCache[cur][rest];
        } else if (cur == n) {
            dpCache[cur][rest] = walk2(n, cur - 1, rest - 1, p, dpCache);
        } else {
            dpCache[cur][rest] = walk2(n, cur - 1, rest - 1, p, dpCache) + walk2(n, cur + 1, rest - 1, p, dpCache);
        }
        return dpCache[cur][rest];
    }
}
