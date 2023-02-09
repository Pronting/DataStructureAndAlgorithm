package priv.pront.code.leetcode.dp;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-09 14:22
 */
public class L53_MaxSubArray {

    // 不使用动态规划版本
    int maxSum = Integer.MIN_VALUE;

    public int maxSubArray(int[] nums) {
        int sum = 0;
        for(int i = 0;i < nums.length; i++){
            sum += nums[i];
            maxSum = Math.max(maxSum,sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }

    // 动态规划版本
    public int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < dp.length; i++){
            dp[i] = dp[i-1] >= 0 ? dp[i-1] + nums[i] : nums[i];
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < dp.length;i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
