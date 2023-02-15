package priv.pront.code.leetcode.dp.rob;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-15 14:11
 */
public class L198_RobI {

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length == 1){
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < dp.length; i++){
            dp[i] = dp[i-1] == dp[i-2] ? dp[i - 1] + nums[i] : Math.max(dp[i-1],dp[i -2] + nums[i]);
        }
        return dp[nums.length -1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2};
        int rob = rob(arr);
        System.out.println(rob);
    }
}
