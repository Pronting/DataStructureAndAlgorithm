package priv.pront.code.leetcode.algorithm.prefix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-10 19:43
 */
public class L560_SubArraySum {

//    前缀和 O(N^2)
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            preSum[i] = preSum[i - 1] + nums[i];
        }

        for(int i = 0; i < preSum.length; i++){
            count = preSum[i] == k ? count + 1 : count;
            for(int j = 0; j < i; j++){
                if(preSum[i] - preSum[j] == k){
                    count++;
                }
            }
        }
        return count;
    }

// 前缀和 + 哈希表优化O(N)
    public int subarraySum2(int[] nums, int k) {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;

            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }

            // 然后维护 preSumFreq 的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int target = 3;
        System.out.println(new L560_SubArraySum().subarraySum(arr, target));
    }
}
