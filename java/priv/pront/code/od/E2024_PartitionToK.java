package priv.pront.code.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 在星球争霸篮球赛对抗赛中，最大的宇宙战队希望每个人都能拿到MVP，MVP的条件是单场最高分得分获得者。 可以并列所以宇宙战队决定在比赛中尽可能让更多队员上场，并且让所有得分的选手得分都相同， 然而比赛过程中的每1分钟的得分都只能由某一个人包揽。
 *
 * 输入描述
 * 输入第一行为一个数字 t ，表示为有得分的分钟数 1 ≤ t ≤ 50。
 *
 *  第二行为 t 个数字，代表每一分钟的得分 p， 1 ≤ p ≤ 50。
 *
 * 输出描述
 * 输出有得分的队员都是MVP时，最少得MVP得分。
 */
public class E2024_PartitionToK {

    static int[] nums;
    static boolean[] used;
    static int sum, n, target;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        nums = new int[n];

        sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }

        // 可选优化：排序（剪枝更快）
        Arrays.sort(nums);

        // 枚举 target（从小到大找第一个可行解 = 最小MVP得分）
        for (int t = 1; t <= sum; t++) {

            if (sum % t != 0) continue;
            target = t;

            used = new boolean[n];

            if (dfs(0, 0, 0)) {
                System.out.println(target);
                return;
            }
        }
    }

    /**
     * usedCount: 已使用元素个数
     * curSum: 当前桶的和
     * start: 当前位置（用于剪枝）
     */
    static boolean dfs(int usedCount, int curSum, int start) {

        // 终止条件：所有数都用完
        if (usedCount == n) return true;

        // 当前桶填满 → 开新桶
        if (curSum == target) {
            return dfs(usedCount, 0, 0);
        }

        for (int i = start; i < n; i++) {
            if (used[i] || curSum + nums[i] > target) continue;

            used[i] = true;

            if (dfs(usedCount + 1, curSum + nums[i], i + 1)) {
                return true;
            }

            used[i] = false;
        }

        return false;
    }
}
