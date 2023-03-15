package priv.pront.code.lanqiao.competition.province2013;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-15 14:06
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] arr = scanner.nextLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                list.add(Integer.parseInt(arr[j]));
            }

        }
        Collections.sort(list);

        int a = 0, b = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) == 2) {
                a = list.get(i) - 1;
            }
            if (list.get(i).equals(list.get(i - 1))) {
                b = list.get(i);
            }
        }
        System.out.println(a + " " + b);
    }
}
