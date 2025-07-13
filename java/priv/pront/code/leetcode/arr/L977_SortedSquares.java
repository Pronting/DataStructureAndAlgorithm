package priv.pront.code.leetcode.arr;

public class L977_SortedSquares {
   public int[] sortedSquares(int[] nums) {
      int[] res = new int[nums.length];
      int l = 0, r = nums.length - 1;
      int idx = r;
      while(l <= r){
         int lpow = nums[l] * nums[l];
         int rpow = nums[r] * nums[r];
         if(lpow > rpow){
            res[idx--] = lpow;
            l++;
         }else{
            res[idx--] = rpow;
            r--;
         }
      }
      return res;
   }
}
