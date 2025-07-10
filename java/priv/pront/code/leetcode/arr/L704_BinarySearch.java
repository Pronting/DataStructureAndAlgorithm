package priv.pront.code.leetcode.arr;

public class L704_BinarySearch {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid = r + l + 1 >> 1;
            if(nums[mid] < target) l = mid;
            else r = mid - 1;;
        }
        if(nums[l] != target) return -1;
        else return l;
    }

    public static void main(String[] args) {

        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(new L704_BinarySearch().search(nums, target));
    }

}
