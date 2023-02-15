package priv.pront.code.leetcode.dp.rob;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-15 15:42
 */
public class L213_RobII {

    public static int rob(int[] nums) {
        int length = nums.length;
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (nums.length == 3) {
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }
        return Math.max(robRange(nums, 0, length - 1), robRange(nums, 1, length));
    }

    public static int robRange(int[] nums, int start, int end) {
        int[] dp = new int[end - start];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start == 0 ? start + 2 : start + 1; i < end - start; i++) {
            if (i != 2) {
                dp[i] = dp[i - 1] == dp[i - 2] ? dp[i - 1] + nums[start == 0 ? i : i + 1] : Math.max(dp[i - 1], dp[i - 2] + nums[start == 0 ? i : i + 1]);
            }else{
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start == 0 ? i : i + 1]);
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {6, 6, 4, 8, 4, 3, 3, 10};
        int rob = rob(arr);
        System.out.println(rob);

    }
}
