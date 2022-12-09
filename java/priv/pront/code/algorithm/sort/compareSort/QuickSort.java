package priv.pront.code.algorithm.sort.compareSort;

//  O(N*logN)
public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int)(Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1); //  <区域
            quickSort(arr, p[1] + 1, R); //   >区域
        }
    }

    /**
     * <p>这是一个处理arr[L...R]的函数</p>
     * <p>默认以arr[R]做目标值划分，默认下标是L</p>
     * <p></p>
     *
     * @param arr 数组
     * @param L   数组起点下标
     * @param R   数组终点下标
     * @return 小于和大于目标值的下标数组
     */
    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1; // <区右边界
        int more = R;//  >区左边界
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        if(i==j){
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    //    for test
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 7, 9, 6, 2, 3};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
