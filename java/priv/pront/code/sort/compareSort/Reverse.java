package priv.pront.code.sort.compareSort;

/**
 * 在一个数组中，左边的数如果比右边的数大，则这两个数构成一个逆序对，请打印所有的逆序对
 */
public class Reverse {
    public static int reverse(int[]arr){
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return process(arr, left, mid) + process(arr, mid + 1, right) + merge(arr, left, mid, right);
    }

    private static int merge(int[] arr, int left, int mid, int right) {
//        创建一个辅助空间
        int[] help = new int[right - left + 1];
        int count = 0;
        int index = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            count += arr[p1] > arr[p2] ? (mid - p1 + 1) : 0;
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }
        while (p2 <= right) {
            help[index++] = arr[p2++];
        }
        for (index = 0; index < help.length; index++) {
            arr[left + index] = help[index];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        System.out.println(reverse(arr));
    }
}
