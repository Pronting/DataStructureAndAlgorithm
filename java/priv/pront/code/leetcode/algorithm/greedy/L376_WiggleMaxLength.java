package priv.pront.code.leetcode.algorithm.greedy;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-17 12:07
 */
public class L376_WiggleMaxLength {


    public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                up = down + 1;
            } else if (nums[i] < nums[i-1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }


    public static void main(String[] args) {
        int[] arr = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(wiggleMaxLength(arr));
    }
}
