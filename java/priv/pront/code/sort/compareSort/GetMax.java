package priv.pront.code.sort.compareSort;

/**
 * 测试一个数组中最大的值
 * 递归master公式(子问题等量的情况下)
 * T(N) = 2 * T(N/2) + o(N^1)
 */
public class GetMax {
    public static void main(String[]args){
        int[] arr = {2, 7, 9, 4, 6, 5};
        int max = getMax(arr);
        System.out.println(max);
    }
    public static int getMax(int[]arr){
        return process(arr, 0, arr.length-1);
    }

    public static int process(int[] arr, int l, int r) {
        if (r == l) {
            return arr[l];
        }
        int mid = r + ((l - r) >> 1);
        int leftMax = process(arr, l, mid);
        int rightMax = process(arr, mid + 1, r);
        return Math.max(rightMax, leftMax);
    }
}

