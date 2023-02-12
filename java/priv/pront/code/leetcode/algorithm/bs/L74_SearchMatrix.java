package priv.pront.code.leetcode.algorithm.bs;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-12 13:47
 */
public class L74_SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length * matrix[0].length -1;
        while(left <= right){
            int mid = left + (right -left) / 2;
            if(matrix[(int)Math.ceil(mid / matrix[0].length)][mid % matrix[0].length] < target){
                left = mid + 1;
            }else if(matrix[(int)Math.ceil(mid / matrix[0].length)][mid % matrix[0].length] > target){
                right = mid -1;
            }else{
                return true;
            }
        }
        return false;
    }
}
