package priv.pront.code.sort.heap;

public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

//        使用这种较快，但还是O(logN)
       /* for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }*/

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize); //O(logN)
            swap(arr, 0, --heapSize); //O(1)
        }
    }


    //      某个数字在index，是否能够向下移动
    private static void heapify(int[] arr, int index, int heapSize) {
        //左子节点下标
        int left = index * 2 + 1;
        //下方还有子节点的情况下
        while (left < heapSize) {
//            两个子节点谁的值大，下标赋值给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
//            父和较大子节点之间，谁的值大，把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    //    某个数组现在处在index位置，往上继续移动
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 3, 0, 1, 8, 5, 3, 9};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
    }
}
