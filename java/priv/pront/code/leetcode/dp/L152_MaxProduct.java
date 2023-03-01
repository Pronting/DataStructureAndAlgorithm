package priv.pront.code.leetcode.dp;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-01 14:14
 */
public class L152_MaxProduct {


//    情况没有考虑完(受到爆破气球的启发，使用2维dp)
    public static int maxProduct(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[nums.length][nums.length];

        for(int i = 0; i < nums.length; i++){
            dp[i][i] = nums[i];
        }

        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){

                if(nums[j] <= 0 && j + 1 < nums.length){
                    i = j + 1;
                    continue;
                }else if(nums[j] <= 0 && j + 1 >= nums.length){
                    continue;
                }

                if(dp[i][j] != nums[j]){
                    dp[i][j] = nums[j] * dp[i][j - 1];
                }

                max = Math.max(max,dp[i][j]);
            }
        }
        return max;

    }

    public static int maxProduct2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0], min = nums[0], result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);

            result = Math.max(result, max);
        }

        return result;

    }


    public static void main(String[] args) {
        int[] arr = {-5, -6, 1, -10, 8};
        System.out.println(maxProduct2(arr));
    }
}
