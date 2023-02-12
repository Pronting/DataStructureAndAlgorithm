package priv.pront.code.leetcode.algorithm.doublePointer;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-12 14:17
 */
public class L27_RemoveElement {

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for(int fast = 0; fast< nums.length;fast++){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
