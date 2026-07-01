package priv.pront.code.od;

import java.util.Scanner;

/**
 * 题目描述
 * 现在有一队小朋友，他们高矮不同，我们以正整数数组表示这一队小朋友的身高，如数组{5,3,1,2,3}。
 *
 * 我们现在希望小朋友排队，以“高”“矮”“高”“矮”顺序排列，每一个“高”位置的小朋友要比相邻的位置高或者相等；每一个“矮”位置的小朋友要比相邻的位置矮或者相等；
 *
 * 要求小朋友们移动的距离和最小，第一个从“高”位开始排，输出最小移动距离即可。
 *
 * 例如，在示范小队{5,3,1,2,3}中，{5, 1, 3, 2, 3}是排序结果。
 *
 * {5, 2, 3, 1, 3} 虽然也满足“高”“矮”“高”“矮”顺序排列，但小朋友们的移动距离大，所以不是最优结果。
 *
 * 移动距离的定义如下所示：
 *
 * 第二位小朋友移到第三位小朋友后面，移动距离为1，若移动到第四位小朋友后面，移动距离为2；
 *
 * 输入描述
 * 排序前的小朋友，以英文空格的正整数：
 *
 * 4 3 5 7 8
 *
 * 注：小朋友<100个
 *
 * 输出描述
 * 排序后的小朋友，以英文空格分割的正整数：4 3 7 5 8
 *
 * 备注：4（高）3（矮）7（高）5（矮）8（高）， 输出结果为最小移动距离，只有5和7交换了位置，移动距离都是1。
 */
public class E2024_高矮个子排队 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] st = sc.nextLine().split(" ");
        int n = st.length;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st[i]);
        for(int i = 0; i < n; i++){
            if(i % 2 == 0 && i != 0){
                // 高
                if(arr[i] < arr[i - 1]) swap(arr, i, i - 1);
            }else if(i % 2 != 0){
                if(arr[i] > arr[i - 1]) swap(arr, i , i - 1);
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
