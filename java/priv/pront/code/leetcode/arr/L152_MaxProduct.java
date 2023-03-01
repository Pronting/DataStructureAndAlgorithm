package priv.pront.code.leetcode.arr;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-01 20:49
 */
public class L152_MaxProduct {

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int ans = nums[0];
        //两个mDP分别定义为以i结尾的子数组的最大积与最小积；
        int[] maxDP = new int[nums.length];
        int[] minDP = new int[nums.length];
        //初始化DP；
        maxDP[0] = nums[0];
        minDP[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //最大积的可能情况有：元素i自己本身，上一个最大积与i元素累乘，上一个最小积与i元素累乘；
            //与i元素自己进行比较是为了处理i元素之前全都是0的情况；
            maxDP[i] = Math.max(nums[i], Math.max(maxDP[i - 1] * nums[i], minDP[i - 1] * nums[i]));
            minDP[i] = Math.min(nums[i], Math.min(maxDP[i - 1] * nums[i], minDP[i - 1] * nums[i]));
            //记录ans；
            ans = Math.max(ans, maxDP[i]);
        }
        return ans;
    }
}
