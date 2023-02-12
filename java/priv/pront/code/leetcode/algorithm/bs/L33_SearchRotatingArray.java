package priv.pront.code.leetcode.algorithm.bs;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-12 12:30
 */
public class L33_SearchRotatingArray {

    //     O(N)
    public static int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] < nums[i - 1]) {
                flag = true;
                return arraySearch(i, nums, target);
            }

        }
        if (!flag) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }


    public static int arraySearch(int leftIndex, int[] nums, int target) {
        int leftPartLeftIndex = 0;
        int leftPartRightIndex = leftIndex - 1;
        int rightPartLeftIndex = leftIndex;
        int rightPartRightIndex = nums.length - 1;
        // 左部分查找
        while (leftPartLeftIndex <= leftPartRightIndex) {
            int mid = leftPartLeftIndex + (leftPartRightIndex - leftPartLeftIndex) / 2;
            if (nums[mid] > target) {
                leftPartRightIndex = mid - 1;
            } else if (nums[mid] < target) {
                leftPartLeftIndex = mid + 1;
            } else {
                return mid;
            }
        }

//      右部分查找
        while (rightPartLeftIndex <= rightPartRightIndex) {
            int mid = rightPartLeftIndex + (rightPartRightIndex - rightPartLeftIndex) / 2;
            if (nums[mid] > target) {
                rightPartRightIndex = mid - 1;
            } else if (nums[mid] < target) {
                rightPartLeftIndex = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


//    logN
    public int search2(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        int left = 0, right = len - 1;
        // 1. 首先明白，旋转数组后，从中间划分，一定有一边是有序的。
        // 2. 由于一定有一边是有序的，所以根据有序的两个边界值来判断目标值在有序一边还是无序一边
        // 3. 这题找目标值，遇到目标值即返回
        // 4. 注意：由于有序的一边的边界值可能等于目标值，所以判断目标值是否在有序的那边时应该加个等号(在二分查找某个具体值得时候如果把握不好边界值，可以再每次查找前判断下边界值，也就是while循环里面的两个if注释)
        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 右边有序
            if (nums[mid] < nums[right]) {
                // 目标值在右边
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                    // 目标值在左边
                } else {
                    right = mid - 1;
                }
                // 左边有序
            } else {
                // 目标值在左边
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                    // 目标值在右边
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1};
        System.out.println(search(arr, 1));
    }
}
