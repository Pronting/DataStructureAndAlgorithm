package priv.pront.code.lanqiao.teach;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 素数加速
 * @Author: pront
 * @Time:2022-11-17 21:20
 */
public class PrimeAccelerate {

    private static List<Integer> getPrimeAc(int N){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i =1; i <= N; i++) {
            list.add(i);
        }
//        1不是素数
        list.set(1, 0);
        int x = (int) Math.sqrt(N);
        for (int i = 2; i <= x; i++) {
            if (list.get(i) != 0) {
                int a = i * i;
                while (a <= N) {
                    list.set(a, 0);
                    a += i;
                }
            }
        }
        return list.stream().filter(i -> i != 0).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> primeAc = getPrimeAc(20);
        for (Integer integer : primeAc) {
            System.out.println(integer);
        }

    }
}
