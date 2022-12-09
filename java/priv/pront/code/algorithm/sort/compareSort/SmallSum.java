package priv.pront.code.algorithm.sort.compareSort;

/**
 * 在一个数组中，每一个数左边比当前数小的累加起来，叫做这个数组的小和。求一个数组的小和
 * 每个数左边比当前数数字小 == 每个数右边比当前数字大
 */
public class SmallSum {
    public static int smallSum(int[]arr){
        if (arr.length < 2 || arr == null) {
            return 0;
        }
        return process(arr, 0, arr.length-1);
    }

    private static int process(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return process(arr, left, mid) + process(arr, mid + 1, right) + merge(arr, left, mid, right);
    }

    private static int merge(int[] arr, int left, int mid, int right) {
//        辅助空间，长度根据right，left可变
        int[] help = new int[right - left + 1];
        int index = 0;
//        设置两个部分的指针
        int p1 = left;
        int p2 = mid + 1;
        int result = 0;
        while (p1 <= mid && p2 <= right) {
            result += arr[p1] < arr[p2] ? (right - p2 + 1) * arr[p1] : 0;
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1<=mid){
            help[index++] = arr[p1++];
        }
        while(p2<=right){
            help[index++] = arr[p2++];
        }
        for (index = 0; index < help.length; index++) {
            arr[left + index] = help[index];
        }
        return result;
    }

    public static void main(String[]args){
        int[] arr = {1, 3, 4, 2, 5};
        System.out.println(smallSum(arr));
    }
}
