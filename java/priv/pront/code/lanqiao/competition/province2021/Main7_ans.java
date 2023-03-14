package priv.pront.code.lanqiao.competition.province2021;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-14 13:00
 */

public class Main7_ans {
    static int r = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        char[] arr = str.toCharArray();

        for(int i = 0; i < arr.length; i++){
            int left = 0;
            int right = 0;

            for(int j = i - 1; j >= 0 && arr[j] != arr[i]; j--){
                left++;
            }
            for(int j = i + 1; j < arr.length && arr[j] != arr[i]; j++){
                right++;
            }

            r += (left + 1) * (right + 1);
        }
        System.out.println(r);
    }
}
