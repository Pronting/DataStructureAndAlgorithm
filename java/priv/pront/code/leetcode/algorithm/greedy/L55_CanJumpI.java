package priv.pront.code.leetcode.algorithm.greedy;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-16 14:46
 */
public class L55_CanJumpI {

    public static boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }

        int cover = nums[0];
        if(cover == 0){
            return false;
        }
        if(cover >= nums.length - 1){
            return true;
        }

        int i = 1;
        for(; i <= cover && i < nums.length;i++){
            if(cover >= nums.length -1){
                return true;
            }
            cover = Math.max(cover, i + nums[i]);
        }
        return false;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(canJump(arr));
    }
}
