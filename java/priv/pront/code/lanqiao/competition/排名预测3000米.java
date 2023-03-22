package priv.pront.code.lanqiao.competition;

import java.util.*;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-22 10:32
 */
public class 排名预测3000米 {

    static int count = 0;
    static Set<String> res = new TreeSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 运动员编号 0 ~n - 1
        int m = scanner.nextInt();  // 围观人员数量
        int errorIndex = 0;
        int acIndex = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        List<Integer>[] errorArr = new ArrayList[10];
        for (int i = 0; i < errorArr.length; i++) {
            errorArr[i] = new ArrayList<>();
        }
        List<Integer>[] acArr = new ArrayList[10];
        for (int i = 0; i < acArr.length; i++) {
            acArr[i] = new ArrayList<>();
        }

//        input
        for (int i = 0; i < m; i++) {
            int nNum = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nNum; j++) {
                list.add(scanner.nextInt());
            }
            if (scanner.nextInt() == 0) {
                errorArr[errorIndex++].addAll(list);
            } else {
                acArr[acIndex++].addAll(list);
            }
        }

        process(arr, errorArr, acArr, 0);
        System.out.println(count);
        for (String re : res) {
            System.out.println(re);
        }
    }

    private static void process(int[] arr, List<Integer>[] errorArr, List<Integer>[] acArr, int startIndex) {
        if (startIndex == arr.length) {
            check(arr, errorArr, acArr);
        }

        for (int i = startIndex; i < arr.length; i++) {
            swap(arr, i, startIndex);
            process(arr, errorArr, acArr, startIndex + 1);
            swap(arr, i, startIndex);
        }
    }

    private static void check(int[] arr, List<Integer>[] errorArr, List<Integer>[] acArr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
//                命中了错误情况跳过
                boolean equals = true; //  初始化和错误预期结果相同
                for (List<Integer> list : errorArr) {
                    if (list.size() == 0) {
                        break;
                    }
                    if(!list.contains(arr[i]) || !list.contains(arr[j])){
                        equals = false;
                    }
//                    只要不全部符合错误的预测，这种可能性就是可行的
//                    某一步的结果和错误答案不符合，就是正确答案，交给正确预测判断
                    if(list.contains(arr[i]) && list.contains(arr[j]) && list.indexOf(arr[i]) > list.indexOf(arr[j])){
                        equals = false;
                        break;
                    }
                }
                    if (equals) {
//                    如果和错误的预测结果完全一致
                        return;
                    }
//                只有全部符合正确的预测，这种可能性才是可行的
                for (List<Integer> list : acArr) {
                    if (list.size() == 0) {
                        break;
                    }
                    if (list.contains(arr[i]) && list.contains(arr[j]) && list.indexOf(arr[i]) > list.indexOf(arr[j])) {
                        return;
                    }
                }
            }
        }
//        没有跳过进行结果处理
        getResult(arr);
    }

    private static void getResult(int[] arr) {
        count++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + " ");
        }
        res.add(sb.toString());
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
