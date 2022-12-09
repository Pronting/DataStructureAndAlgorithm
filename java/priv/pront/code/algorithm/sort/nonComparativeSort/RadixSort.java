package priv.pront.code.algorithm.sort.nonComparativeSort;

/**
 * 基数排序
 * 原理:
 * 准备与原数组一样的辅助空间，循环n次模拟n次的出桶入桶
 * 具体实现放在两个循环里面，准备一个词频表，处理为前缀和词频表
 * 通过出桶可以知道当前位数的权重，进行n次出桶入桶，知道各个位数的权重
 * 从而知道辅助空间元素的位置，最后复制到数组中。完整排序操作
 */
public class RadixSort {
    public static void radixSort(int[]arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxBits(arr));
    }

    public static int maxBits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    public static void radixSort(int[] arr, int l, int r, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
//        有多少个数字就准备多少个辅助空间
        int[] bucket = new int[r - l + 1];
//        根据数组中最大数组右多少位，决定进出桶多少次
        for (int d = 1; d <= digit; d++) {
//            准备10个空间
//            count[0] 当前为（d位）是0的数字有多少个
//            count[i] 当前为 （d为）是i的数字有多少个
            int[]count = new int[radix];

            for (i = l; i <= r; i++) {
//                填充词频表
                j = getDigit(arr[i], d);
                count[j]++;
            }

//          将count处理为前缀和数组
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
//            数组从右往左遍历
            for (i = r; i >= l; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }

            for (i = l, j = 0; i <= r; i++, j++) {
                arr[i] = bucket[j];
            }
        }

    }

    private static int getDigit(int x, int d) {
        return ((x / (int) Math.pow(10, d - 1)) % 10);
    }

    public static void main(String[]args){
        int[] arr = {81, 90, 4, 60, 79, 55, 221, 300};
        radixSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
