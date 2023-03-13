package priv.pront.code.lanqiao.competition.province2021;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-13 15:56
 */
//fixme timeout
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrSize = scanner.nextInt();
        Integer[] arr = new Integer[arrSize];
        int operationNum = scanner.nextInt();
        int[][] operationArr = new int[operationNum][2];

        for (int i = 0; i < operationNum; i++) {
            operationArr[i][0] = scanner.nextInt();
            operationArr[i][1] = scanner.nextInt();
        }

        for (int i = 0; i < arrSize; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < operationNum; i++) {
            if (operationArr[i][0] == 1) {
                increase(operationArr[i][1], arr);
            }else if(operationArr[i][0] == 0){
                decrease(operationArr[i][1], arr);
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void increase(int startIndex, Integer[] arr) {
        Arrays.sort(arr, startIndex - 1, arr.length);
    }

    public static void decrease(int endIndex, Integer[] arr) {
        Arrays.sort(arr, 0, endIndex, Collections.reverseOrder());
    }


}
