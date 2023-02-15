package priv.pront.code.leetcode.algorithm.doublePointer;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-14 21:01
 */
public class L11_WaterMaxArea {

    public static int maxArea(int[] height) {
        if (height.length == 2) {
            return height[0] * height[1];
        }
        int max = 0;
        for (int left = 0; left < height.length; left++) {
            for (int right = height.length - 1; right > left; right--) {
                max = Math.max(max, Math.min(height[right], height[left]) * (right - left));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }


}
