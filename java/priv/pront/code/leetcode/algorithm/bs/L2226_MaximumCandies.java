package priv.pront.code.leetcode.algorithm.bs;

import java.util.Arrays;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-16 11:22
 */
public class L2226_MaximumCandies {


    public static int maximumCandies(int[] candies, long k) {
        int sum = 0;
        for(int cur : candies){
            sum += cur;
        }
        if(sum < k){
            return 0;
        }
        Arrays.sort(candies);
        int left = 0;
        int right = (int)Math.pow(10,7);
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(sum < k * mid){
                right = mid - 1;
            } else if (sum == k * mid || (sum > k * mid && sum < k * mid + 1)) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] candies = {5, 8, 6};
        System.out.println(maximumCandies(candies,3));
        System.out.println(3 / 4);
    }
}
