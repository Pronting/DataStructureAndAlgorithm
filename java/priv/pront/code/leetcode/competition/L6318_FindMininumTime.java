package priv.pront.code.leetcode.competition;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description: 你有一台电脑，它可以 同时 运行无数个任务。给你一个二维整数数组 tasks ，其中 tasks[i] = [starti, endi, durationi] 表示第 i 个任务需要在 闭区间 时间段 [starti, endi] 内运行 durationi 个整数时间点（但不需要连续）。
 *
 * 当电脑需要运行任务时，你可以打开电脑，如果空闲时，你可以将电脑关闭。
 *
 * 请你返回完成所有任务的情况下，电脑最少需要运行多少秒。
 * @Author: pront
 * @Time:2023-03-12 11:37
 */
public class L6318_FindMininumTime {

    public int minTime(int[][] tasks) {
        // 将所有任务按照起始时间从小到大排序
        Arrays.sort(tasks, (a, b) -> a[0] - b[0]);
        int currTime = 0; // 当前时间
        int minTime = 0; // 最小需要运行的时间
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 按照结束时间排序的优先队列
        for (int[] task : tasks) {
            // 将所有结束时间小于等于当前时间的任务从优先队列中删除
            while (!pq.isEmpty() && pq.peek()[1] <= currTime) {
                pq.poll();
            }
            // 将当前任务加入优先队列
            pq.offer(task);
            // 如果电脑当前空闲，则运行下一个任务
            if (pq.size() == 1) {
                minTime += task[2];
                currTime = task[1];
            }
        }
        // 运行所有剩余的任务
        while (!pq.isEmpty()) {
            int[] task = pq.poll();
            minTime += task[2] + Math.max(0, task[0] - currTime);
            currTime = Math.max(currTime, task[1]);
        }
        return minTime;
    }

    public static void main(String[] args) {
        System.out.println(new L6318_FindMininumTime().minTime(new int[][]{{2, 3, 1}, {4, 5, 1}, {1, 5, 2}}));
    }
}
