package priv.pront.code.algorithm.sort.compareSort;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
//            记录有序序列的最后一个下标
            int end = i;
//            等待插入的元素
            int temp = arr[end + 1];
//            每一次的遍历插入
            while (end >= 0) {
//           后面的数字比前面的数字小就向前移动
                if (temp < arr[end]) {
                    arr[end + 1] = arr[end--];
                } else {
                    break;
                }
            }
            arr[end + 1] = temp;
            //代码执行到此位置有两种情况:
            //1.待插入元素找到应插入位置（break跳出循环到此）
            //2.待插入元素比当前有序序列中的所有元素都小（while循环结束后到此）
        }
    }
}
