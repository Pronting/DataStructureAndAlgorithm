package priv.pront.code.algorithm.others;

/**
 * @Description: 给定一个数组，求如果排序之后，相邻两数得最大差值，要求O(N)，不能用非基于比较的排序
 * @Author: pront
 * @Time:2023-02-06 14:22
 */
public class MaxGap {

    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
//        hasNum[i] i号桶是否进来过数字
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];  //maxs[i] i号桶手机的所有数字的最大值
        int[] mins = new int[len + 1];  //mins[i] i号桶收集的所有数字的最小值
        int bid = 0;  //编号
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];  //上一个非空桶的最大值
        int i = 1;
        for (; i < len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }
}
