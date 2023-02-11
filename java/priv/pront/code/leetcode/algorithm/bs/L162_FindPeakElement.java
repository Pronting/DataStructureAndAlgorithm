package priv.pront.code.leetcode.algorithm.bs;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-11 18:31
 */
public class L162_FindPeakElement {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
