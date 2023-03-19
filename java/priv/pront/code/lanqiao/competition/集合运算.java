package priv.pront.code.lanqiao.competition;

import java.util.*;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-20 10:37
 */
public class 集合运算 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        Set<Integer> bingSet = new TreeSet<>();
        Set<Integer> jiaoSet = new TreeSet<>();
        Set<Integer> yuSet = new TreeSet<>();
        int aSize = scanner.nextInt();
        for (int i = 0; i < aSize; i++) {
            int temp = scanner.nextInt();
            aList.add(temp);
            bingSet.add(temp);
        }
        int bSize = scanner.nextInt();
        for (int i = 0; i < bSize; i++) {
            int temp = scanner.nextInt();
            if (aList.contains(temp)) {
                jiaoSet.add(temp);
            }
            bList.add(temp);
            bingSet.add(temp);
        }

        for (int i : aList) {
            if (!bList.contains(i)) {
                yuSet.add(i);
            }
        }
        if (jiaoSet.size() > 0) {
            System.out.println(jiaoSet.toString().substring(1, jiaoSet.toString().length() - 1).replaceAll(",", ""));
        }
        if (bingSet.size() > 0) {
            System.out.println(bingSet.toString().substring(1, bingSet.toString().length() - 1).replaceAll(",", ""));
        }
        if (yuSet.size() > 0) {
            System.out.println(yuSet.toString().substring(1, yuSet.toString().length() - 1).replaceAll(",", ""));
        }

    }
}
