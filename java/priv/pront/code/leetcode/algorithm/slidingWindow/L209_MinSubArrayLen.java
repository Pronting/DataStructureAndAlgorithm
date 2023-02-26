package priv.pront.code.leetcode.algorithm.slidingWindow;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-26 15:52
 */
public class L209_MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int i = 0;
        int Len = Integer.MAX_VALUE;
        if (nums.length == 0) {
            return 0;
        }
        for (int j = 0; j < nums.length; j++) {
            sum = sum + nums[j];
            while (sum >= target) {
                Len = Math.min(Len, j - i + 1);
                sum = sum - nums[i];
                i++;
            }
        }
        return Len == Integer.MAX_VALUE ? 0 : Len;
    }
}
