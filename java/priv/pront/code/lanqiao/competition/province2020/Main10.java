package priv.pront.code.lanqiao.competition.province2020;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description: #」整数小拼接
 * 时间限制：1.0s内存限制：512.0MB本题总分：25分
 * 问题描述
 * 给定义个长度为n的数组A1,A2,·,An。你可以从中选出两个数A;和A;
 * (1不等于j),然后将A;和A;一前一后拼成一个新的整数。例如12和345可
 * 以拼成12345或34512。注意交换A:和A;的顺序总是被视为2种拼法，即便
 * 是A;=A;时。
 * 请你计算有多少种拼法满足拼出的整数小于等于K。
 * 输入格式
 * 第一行包含2个整数n和K。
 * 第二行包含n个整数A1,A2,·,An
 * 输出格式
 * 一个整数代表答案。
 * @Author: pront
 * @Time:2023-03-12 15:25
 */
public class Main10 {
    static int res = 0;
    static List<Integer> path = new ArrayList<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[scanner.nextInt()];
        int k = scanner.nextInt();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        backtracking1(arr, k, 0);
        backtracking2(arr, k, arr.length - 1);
        System.out.println(res);
    }

    public static void backtracking1(int[] arr, int target, int startIndex) {
        int sum = -1;
        if (path.size() == 0) {
            sum = 0;
        } else if (path.size() == 1) {
            sum = path.get(0);
        } else if (path.size() == 2) {
            sum = path.get(0) * 10 + path.get(1);
        }

        if(path.size() == 2 && sum <= target){
            res++;
            return;
        }
        if (path.size() > 2) {
            return;
        }
        for (int i = startIndex; i < arr.length; i++) {
            path.add(arr[i]);
            backtracking1(arr, target, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void backtracking2(int[] arr, int target, int startIndex) {
        int sum = -1;
        if (path.size() == 0) {
            sum = 0;
        } else if (path.size() == 1) {
            sum = path.get(0);
        } else if (path.size() == 2) {
            sum = path.get(0) * 10 + path.get(1);
        }

        if(path.size() == 2 && sum <= target){
            res++;
            return;
        }
        if (path.size() > 2) {
            return;
        }
        for (int i = startIndex; i >= 0; i--) {
            path.add(arr[i]);
            backtracking2(arr, target, i - 1);
            path.remove(path.size() - 1);
        }
    }
}
