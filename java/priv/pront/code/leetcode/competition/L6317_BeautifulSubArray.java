package priv.pront.code.leetcode.competition;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 给你一个下标从 0 开始的整数数组nums 。每次操作中，你可以：
 *
 * 选择两个满足 0 <= i, j < nums.length 的不同下标 i 和 j 。
 * 选择一个非负整数 k ，满足 nums[i] 和 nums[j] 在二进制下的第 k 位（下标编号从 0 开始）是 1 。
 * 将 nums[i] 和 nums[j] 都减去 2k 。
 * 如果一个子数组内执行上述操作若干次后，该子数组可以变成一个全为 0 的数组，那么我们称它是一个 美丽 的子数组。
 *
 * 请你返回数组 nums 中 美丽子数组 的数目。
 *
 * 子数组是一个数组中一段连续 非空 的元素序列。
 * @Author: pront
 * @Time:2023-03-12 11:16
 */
public class L6317_BeautifulSubArray {

    public int beautifulArray(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        cnt[0] = 1;
        int ans = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] & 1;
            if (sum >= 2) {
                ans += cnt[sum - 2];
            }
            cnt[sum]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new L6317_BeautifulSubArray().beautifulArray(new int[]{4, 3, 1, 2, 4}));
    }
}
