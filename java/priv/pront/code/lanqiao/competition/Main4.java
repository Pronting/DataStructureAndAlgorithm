package priv.pront.code.lanqiao.competition;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 小蓝有 30 个数，分别为：99, 22, 51, 63, 72, 61, 20, 88, 40, 21, 63, 30, 11,
 * 18, 99, 12, 93, 16, 7, 53, 64, 9, 28, 84, 34, 96, 52, 82, 51, 77 。
 * 　　小蓝可以在这些数中取出两个序号不同的数，共有 30*29/2=435 种取法。
 * 　　请问这 435 种取法中，有多少种取法取出的两个数的乘积大于等于 2022 。
 * @Author: pront
 * @Time:2023-03-03 09:44
 */
public class Main4 {

    static List<Integer> list = new ArrayList<>();
    static int res = 0;

    public static void main(String[] args) {
        int[] arr = {99, 22, 51, 63, 72, 61, 20, 88, 40, 21, 63, 30, 11,
                18, 99, 12, 93, 16, 7, 53, 64, 9, 28, 84, 34, 96, 52, 82, 51, 77};

        backtracking(arr,2,0);
        System.out.println(res);


    }

    public static void backtracking(int[] arr,int size,int startIndex){
        if(list.size() > size){
            return;
        }
        if(list.size() == size && list.get(0) * list.get(1) > 2022){
            res++;
            return;
        }
        for(int i = startIndex; i< arr.length; i++){
            list.add(arr[i]);
            backtracking(arr,size,i+ 1);
            list.remove(list.size() - 1);
        }
    }
}
