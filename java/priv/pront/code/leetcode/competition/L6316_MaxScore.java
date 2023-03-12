package priv.pront.code.leetcode.competition;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description: 给你一个下标从 0 开始的整数数组 nums 。你可以将 nums 中的元素按 任意顺序 重排（包括给定顺序）。
 * <p>
 * 令 prefix 为一个数组，它包含了 nums 重新排列后的前缀和。换句话说，prefix[i] 是 nums 重新排列后下标从 0 到 i 的元素之和。nums 的 分数 是 prefix 数组中正整数的个数。
 * <p>
 * 返回可以得到的最大分数。
 * @Author: pront
 * @Time:2023-03-12 10:39
 */
public class L6316_MaxScore {


    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        long[] prefix = new long[nums.length];
        prefix[prefix.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0 ; i--) {
            prefix[i] = prefix[i + 1] + nums[i];
        }
        int maxScore = 0;
        for(int i = prefix.length - 1; i >= 0 ;i--){
            if(prefix[i] > 0){
                maxScore++;
            }else{
                break;
            }
        }
        return maxScore;
    }


    public static void main(String[] args) {
        System.out.println(new L6316_MaxScore().maxScore(new int[]{-687767,-860350,950296,52109,510127,545329,-291223,-966728,852403,828596,456730,-483632,-529386,356766,147293,572374,243605,931468,641668,494446}));
    }
}
