package priv.pront.code.leetcode.dp.bag;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-11 13:19
 */
public class L416_CanPartition {

    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int n = nums.length;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        //总和为奇数，不能平分
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for(int i = 0; i < n; i++) {
            for(int j = target; j >= nums[i]; j--) {
                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
