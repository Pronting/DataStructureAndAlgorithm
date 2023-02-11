package priv.pront.code.leetcode.dp.bag;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-11 13:17
 */
public class L1049_LastStoneWeightII {

    // stones[i] 既是 value[i] 也是 weight[i]
    public int lastStoneWeightII(int[] stones) {

        int sum = 0;
        for (int i : stones) {
            sum += i;
        }
        int target = sum >> 1;
        //初始化dp数组
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            //采用倒序
            for (int j = target; j >= stones[i]; j--) {
                //两种情况，要么放，要么不放
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[target];
    }

}
