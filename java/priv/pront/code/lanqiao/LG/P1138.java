package priv.pront.code.lanqiao.LG;

import java.util.*;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-11-24 19:23
 */
public class P1138 {
    static Set<Integer> containsSet = new HashSet<>();
    static List<Integer> list = new ArrayList<>();

    private static void add(int number) {
        if (!containsSet.contains(number)) {
            list.add(number);
            containsSet.add(number);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            add(number);
        }

        Collections.sort(list);
        if (k > list.size()) {
            System.out.println("NO RESULT");
            return;
        }
        System.out.println();
        System.out.println(list.get(k - 1));

    }
}
