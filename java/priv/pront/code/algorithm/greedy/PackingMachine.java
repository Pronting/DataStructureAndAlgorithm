package priv.pront.code.algorithm.greedy;

/**
 * @Description: 洗衣机问题
 * @Author: pront
 * @Time:2022-12-06 13:25
 */
public class PackingMachine {


    public static int MinOps(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int size = arr.length;
//        算出总和
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }
//        如果总和不能够北整除，直接返回-1
        if (sum % size != 0) {
            return -1;
        }
//        每一个位置的平均值/目标值
        int avg = sum / size;
//        左边位置的总和
        int leftSum = 0;
        //答案
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
//            负 需要输入   正 需要输出
            int L = i * avg - leftSum;
            int R = (size - i - 1) * avg - (sum - leftSum - arr[i]);
            if (L > 0 && R > 0) {
                ans = Math.max(ans, Math.abs(L) + Math.abs(R));
            } else {
                ans = Math.max(ans, Math.max(Math.abs(L), Math.abs(R)));
            }
            leftSum += arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
