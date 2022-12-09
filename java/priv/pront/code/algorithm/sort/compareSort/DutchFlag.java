package priv.pront.code.algorithm.sort.compareSort;

/**
 * [i]<=num ，[i]和<=区域的下一个数字做交换，<=区域向右扩展一个位置,当前位置来到下一个位置
 */

public class DutchFlag {
    public static int[] methodFlag(int[]arr,int target){
        if (arr.length < 2) {
            return null;
        }
        return partition(arr, target,0,arr.length-1);
    }

    public static int[] partition(int[] arr, int target,int left,int right) {
        if (left > right) {
            return new int[]{-1, -1};
        }
        if (left == right) {
            return new int[]{left, right};
        }
//        两个区域的指针
        int index = left;
        int p1 = left - 1;
        int p2 = right;
        while (index < p2) {
            if (arr[index] < target) {
//                [i]和<=区域的下一个数字做交换
                swap(arr, ++p1, index++);
            } else if (arr[index] > target) {
                swap(arr, --p2, index);
            }else{
                index++;
            }
        }
        return new int[]{p1 + 1, p2};
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    //      for test
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 2};
        int[] ans = methodFlag(arr, 4);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}
