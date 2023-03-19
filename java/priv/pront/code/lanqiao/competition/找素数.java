package priv.pront.code.lanqiao.competition;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-19 15:15
 */
// FIXME timeout
public class 找素数 {

    private static int getPrimeAc(int startIndex, int endIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 1; i <= endIndex; i++) {
            list.add(i);
        }
//        1不是素数
        list.set(1, 0);
        int x = (int) Math.sqrt(endIndex);
        for (int i = startIndex; i <= x; i++) {
            if (list.get(i) != 0) {
                int a = i * i;
                while (a <= endIndex) {
                    list.set(a, 0);
                    a += i;
                }
            }
        }
        return (int) list.stream().filter(i -> i != 0).count();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int L = scanner.nextInt();
        int R = scanner.nextInt();
        System.out.println(getPrimeAc(L, R));
    }
}
