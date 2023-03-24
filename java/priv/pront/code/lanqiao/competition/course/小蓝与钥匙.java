package priv.pront.code.lanqiao.competition.course;

public class 小蓝与钥匙 {
//    87,178,291,200
//  1286583532342313400
    public static void main(String[] args) {
        int[] arr = new int[14];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        process(arr, 0);
    }

    private static void process(int[] arr, int level) {
        if (level == arr.length) {
            check(arr);
        }
        for (int i = level; i < arr.length; i++) {
            swap(arr, i, i + 1);
            process(arr, level + 1);
            swap(arr, i, i + 1);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void check(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr.length + " ");
        }
    }
}
