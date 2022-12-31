package priv.pront.code.lanqiao.LG.P;

import java.util.*;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-11-24 19:09
 */
public class P1059 {
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int number = sc.nextInt();
            if (!set.contains(number)) {
                set.add(number);
            }
        }
        System.out.println(set.size());
        int[] arr = new int[set.size()];
        int index = 0;
        for (Integer integer : set) {
            arr[index++] = integer;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
