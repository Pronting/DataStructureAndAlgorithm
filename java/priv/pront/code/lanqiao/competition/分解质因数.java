package priv.pront.code.lanqiao.competition;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-20 11:18
 */
public class 分解质因数 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        List<Integer> list = getNum();
        for (int i = a; i <= b; i++) {
            System.out.print(i + "=");
            int temp = i;
            for (int j = 0; j < list.size(); j++) {
                while (temp % list.get(j) == 0 && temp != list.get(j)) {
                    temp /= list.get(j);
                    System.out.print(list.get(j) + "*");
                }
                if (temp == list.get(j)) {
                    System.out.print(temp);
                    break;
                }
            }
            System.out.println();
        }
    }

    private static List<Integer> getNum() {
        List<Integer> ans = new ArrayList<>();
        for (int i = 2; i < 10000; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(i);
            }
        }
        return ans;
    }
}
