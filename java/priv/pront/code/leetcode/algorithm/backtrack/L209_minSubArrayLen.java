package priv.pront.code.leetcode.algorithm.backtrack;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-26 15:17
 */
public class L209_minSubArrayLen {

    public static int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int preIndex = i;

            if(count > nums.length){
                return 0;
            }
            while(sum < target && preIndex < nums.length){
                sum += nums[preIndex++];
                count++;
            }
            min = Math.min(min,count);
            sum = 0;
            count = 0;
        }
        return min;

    }


    public static  int minSubArrayLen2(int target, int[] nums) {
        int sum=0;
        int i=0;
        int Len=Integer.MAX_VALUE;
        if(nums.length==0){
            return 0;
        }
        for(int j=0;j<nums.length;j++){
            sum=sum+nums[j];
            while(sum>=target){
                Len=Math.min(Len,j-i+1);
                sum=sum-nums[i];
                i++;
            }
        }
        return Len==Integer.MAX_VALUE?0:Len;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int target = 7;
        minSubArrayLen2(target, arr);

    }
}
