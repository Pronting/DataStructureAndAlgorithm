package priv.pront.code.leetcode.algorithm.bs;

import java.util.Arrays;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-11 18:38
 */
public class L164_MaximumGap {

    public static int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int max = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (Math.abs(nums[mid] - nums[mid + 1]) > max) {
                max = Math.abs(nums[mid] - nums[mid + 1]);
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 1};
        System.out.println(maximumGap(nums));

    }
}
