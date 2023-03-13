package priv.pront.code.lanqiao.competition.province2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-13 15:16
 */
// fixme 内存超限
public class Main1 {
    static int count = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if(N == 1){
            System.out.println(1);;
            return;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        process(list,N);
        System.out.println(count);
    }

    public static void process(List<Integer> list, int N) {
        List<Integer> newList = new ArrayList<>();
        newList.add(1);
        count++;
        int index = 0;
        while (index + 1 < list.size()) {
            count++;
            newList.add(list.get(index++) + list.get(index));
            if (newList.get(newList.size() - 1) == N) {
                return;
            }
        }
        newList.add(1);
        count++;
        process(newList, N);
    }
}
