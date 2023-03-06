package priv.pront.code.leetcode.dp.bag;

/**
 * @Description: 01背包
 * @Author: pront
 * @Time:2023-03-06 21:43
 */
public class L494_FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum + target) % 2 != 0 || target > sum) {
            return 0;
        }
        int mid = (sum + target) / 2;
        if (mid < 0) {
            return 0;
        }
        int[] dp = new int[mid + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = mid; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[mid];
    }
}
