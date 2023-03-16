package priv.pront.code.lanqiao.competition.course;

import java.util.Scanner;


public class Main5 {

    public static final int ANS_MOD = (int) Math.pow(10, 9) + 7;
    static int curSum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        long[] arr = new long[T];
        for (int i = 0; i < T; i++) {
            curSum = 0;
            int n = scanner.nextInt();
            int[] numArr = new int[n];
            for (int j = 0; j < n; j++) {
                numArr[j] = j + 1;
            }
            permutation(numArr, 0);
            arr[i] = curSum;
        }
        for (long i : arr) {
            System.out.println(i % ANS_MOD);
        }
    }

    private static void permutation(int[] numArr, int startIndex) {
        if (startIndex == numArr.length - 1) {
            curSum += getSum(numArr);
        }
        for (int i = startIndex; i <= numArr.length - 1; i++) {
            swap(numArr, i, startIndex);
            permutation(numArr, startIndex + 1);
            swap(numArr, i, startIndex);
        }
    }

    private static int getSum(int[] numArr) {
        if (numArr.length == 1) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < numArr.length - 1; j++) {
            int sum = 0;
            for (int k = j + 1; k < numArr.length; k++) {
                if (numArr[j] % numArr[k] == 0) {
                    sum += numArr[k];
                }
            }
            if(sum != 0){
                sum += numArr[j];
            }
            res += sum;
        }
        return res;
    }

    private static void swap(int[] numArr, int i, int j) {
        int t = numArr[i];
        numArr[i] = numArr[j];
        numArr[j] = t;
    }
}
