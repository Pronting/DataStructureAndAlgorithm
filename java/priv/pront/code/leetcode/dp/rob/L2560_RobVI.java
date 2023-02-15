package priv.pront.code.leetcode.dp.rob;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-15 19:11
 */
public class L2560_RobVI {

    static List<Integer> path = new ArrayList<>();
    static int sum = Integer.MAX_VALUE;

    public static int minCapability(int[] nums, int k) {
        backtracking(nums,k,0);
        return sum;
    }

//    回溯timeout
    public static void backtracking(int[] nums, int k, int startIndex){
        if(path.size() == k){
            int curSum = 0;
            for (Integer integer : path) {
                curSum = Math.max(curSum, integer);
            }
            sum = Math.min(sum, curSum);
            return;
        }
        for(int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            backtracking(nums,k,i + 2);
            path.remove(path.size() - 1);
        }
    }

    public int minCapability2(int[] nums, int k) {
        int length = nums.length;
        int min = nums[0], max = min;
        for (int i = 1; i < length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        while (min <= max) {
            int mid = (min + max) >>> 1;
            if (check(nums, k, mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
    public boolean check(int[] nums, int k, int mid) {
        int cnt = 0;
        // 从左到右枚举每座房子，能抢就抢
        // j 是上一次抢夺的下标
        for (int i = 0, j = -2; i < nums.length; i++) {
            if (nums[i] <= mid && i - j > 1) {
                cnt++;
                j = i;
            }
        }

        return cnt >= k;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 9, 3, 1};
        System.out.println(minCapability(arr, 2));
    }
}
