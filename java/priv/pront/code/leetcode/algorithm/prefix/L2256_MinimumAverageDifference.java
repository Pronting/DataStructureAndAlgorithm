package priv.pront.code.leetcode.algorithm.prefix;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-07 13:42
 */
public class L2256_MinimumAverageDifference {

    public int minimumAverageDifference(int[] nums) {
        long[] left = new long[nums.length];
        long[] right = new long[nums.length];
        long[] leftAverage = new long[nums.length];
        long[] rightAverage = new long[nums.length];
        long res = Integer.MAX_VALUE;
        int resIndex = -1;


        left[0] = nums[0];
//      前缀和
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] + nums[i];
        }
//      后缀和
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i];
        }
        // 前平均值
        for(int i = 0; i < nums.length; i++){
            leftAverage[i] = left[i] / (i + 1);
        }

        // 后平均值
        for(int i = 0; i < nums.length - 1; i++){
            rightAverage[i] = right[i + 1] / (nums.length -(i + 1));
        }

        for (int i = 0; i < nums.length; i++) {
            if (res > Math.abs(leftAverage[i] - rightAverage[i])) {
                res = Math.abs(leftAverage[i] - rightAverage[i]);
                resIndex = i;
            }

        }
        return resIndex;
    }

    public static void main(String[] args) {
        System.out.println(new L2256_MinimumAverageDifference().minimumAverageDifference(new int[]{2, 5, 3, 9, 5, 3}));
    }
}
